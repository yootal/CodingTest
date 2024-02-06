import java.io.*;
import java.util.*;

public class Solution {
	static final int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static final int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] board = new int[n][n];
			for (int i = 0; i < n; i++) {
				String row = br.readLine();
				for (int j = 0; j < n; j++) {
					if (row.charAt(j) == '*')
						board[i][j] = -1;
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i][j] != -1) {
						int count = 0;
						for (int d = 0; d < 8; d++) {
							int nx = i + dx[d];
							int ny = j + dy[d];
							if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == -1) {
								count++;
							}
						}
						board[i][j] = count;
					}
				}
			}
			ArrayDeque<int[]> q = new ArrayDeque<>();
			int ans = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i][j] == 0) {
						ans++;
						q.offerLast(new int[] { i, j });
						board[i][j] = -1;
						while (!q.isEmpty()) {
							int[] cur = q.pollFirst();
							for (int d = 0; d < 8; d++) {
								int nx = cur[0] + dx[d];
								int ny = cur[1] + dy[d];
								if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] != -1) {
									if (board[nx][ny] == 0) {
										board[nx][ny] = -1;
										q.offerLast(new int[] { nx, ny });
									} else {
										board[nx][ny] = -1;
									}
								}
							}
						}
					}
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i][j] != -1)
						ans++;
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

}
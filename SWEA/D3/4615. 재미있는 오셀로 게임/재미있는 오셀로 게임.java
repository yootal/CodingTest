import java.io.*;
import java.util.*;

public class Solution {
	static final int dx[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static final int dy[] = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int board[][] = new int[N][N];
			int center = (N - 1) / 2;
			for (int i = center; i < center + 2; i++) {
				for (int j = center; j < center + 2; j++) {
					if ((i + j) % 2 == 0) {
						board[i][j] = 2;
					} else
						board[i][j] = 1;
				}
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()) - 1;
				int y = Integer.parseInt(st.nextToken()) - 1;
				int s = Integer.parseInt(st.nextToken());
				board[x][y] = s;
				for (int d = 0; d < 8; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
						if (board[nx][ny] == s || board[nx][ny] == 0) {
							continue;
						}
						while (true) {
							nx += dx[d];
							ny += dy[d];
							if (nx < 0 || nx >= N || ny < 0 || ny >= N)
								break;
							if (board[nx][ny] == 0)
								break;
							if (board[nx][ny] == s) {
								while (true) {
									nx -= dx[d];
									ny -= dy[d];
									if (nx == x && ny == y)
										break;
									board[nx][ny] = s;
								}
								break;
							}
						}
					}
				}
			}
			int cnt1 = 0;
			int cnt2 = 0;
			for (int[] row : board) {
				for (int stone : row) {
					if (stone == 1)
						cnt1++;
					else if (stone == 2)
						cnt2++;
				}
			}
			sb.append("#").append(tc).append(" ").append(cnt1 + " " + cnt2).append("\n");
		}
		System.out.print(sb);
	}
}
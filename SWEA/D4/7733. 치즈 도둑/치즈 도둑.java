import java.io.*;
import java.util.*;

public class Solution {
	static final int[] dx = { 1, 0, -1, 0 };
	static final int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] cheese = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int ans = 0;
			int day = 0;
			boolean[][] v;
			Queue<int[]> q;
			while (day <= 100) {
				int cnt = 0;
				v = new boolean[n][n];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (cheese[i][j] > day && !v[i][j]) {
							cnt++;
							v[i][j] = true;
							q = new ArrayDeque<>();
							q.offer(new int[] { i, j });
							while (!q.isEmpty()) {
								int[] cur = q.poll();
								for (int d = 0; d < 4; d++) {
									int nx = cur[0] + dx[d];
									int ny = cur[1] + dy[d];
									if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
										if (cheese[nx][ny] > day && !v[nx][ny]) {
											v[nx][ny] = true;
											q.offer(new int[] { nx, ny });
										}
									}
								}
							}
						}
					}
				}
				ans = Math.max(ans, cnt);
				if (cnt == 0)
					break;
				day++;
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

}
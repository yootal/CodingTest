import java.io.*;
import java.util.*;

public class Solution {
	static final int[] dx = { 0, 1, 0, -1 };
	static final int[] dy = { 1, 0, -1, 0 };
	static int[][] cheese;
	static boolean[][] v;
	static int n;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			cheese = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int ans = 0;
			int day = 0;
			while (day <= 100) {
				int cnt = 0;
				v = new boolean[n][n];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (cheese[i][j] > day && !v[i][j]) {
							cnt++;
							dfs(i, j, day);
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

	static void dfs(int x, int y, int day) {
		v[x][y] = true;
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
				if (cheese[nx][ny] > day && !v[nx][ny]) {
					dfs(nx, ny, day);
				}
			}
		}

	}
}
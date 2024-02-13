import java.io.*;
import java.util.*;

public class Solution {
	static int[][] map;
	static boolean[][] vis;
	static int N;
	static int K;
	static final int[] dx = { -1, 0, 1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };

	public static void main(String args[]) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[][] top_position = new int[5][2];
		map = new int[8][8];
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			int top = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					top = Math.max(map[i][j], top);
				}
			}
			int idx = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == top) {
						top_position[idx++] = new int[] { i, j };
					}
				}
			}
			int ans = 0;
			for (int i = 0; i < idx; i++) {
				vis = new boolean[N][N];
				ans = Math.max(dfs(top_position[i][0], top_position[i][1], 1, true), ans);
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

	static int dfs(int x, int y, int cnt, boolean cut) {
		vis[x][y] = true;
		int dist = cnt;
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
				if (map[x][y] > map[nx][ny] && !vis[nx][ny]) {
					dist = Math.max(dist, dfs(nx, ny, cnt + 1, cut));
				} else if (cut && map[x][y] > map[nx][ny] - K && !vis[nx][ny]) {
					int temp = map[nx][ny];
					map[nx][ny] = map[x][y] - 1;
					dist = Math.max(dist, dfs(nx, ny, cnt + 1, false));
					map[nx][ny] = temp;
				}
			}
		}
		vis[x][y] = false;
		return dist;
	}

}
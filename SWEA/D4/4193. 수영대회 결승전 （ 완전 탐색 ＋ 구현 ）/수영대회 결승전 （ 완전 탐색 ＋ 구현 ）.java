import java.io.*;
import java.util.*;

public class Solution {
	static final int[] dx = { -1, 0, 1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };
	static int ans;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[][] board = new int[15][15];
		boolean[][] vis = new boolean[15][15];
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					vis[i][j] = false;
				}
			}
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			ans = -1;
			bfs(board, vis, sx, sy, ex, ey, N);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

	static void bfs(int[][] board, boolean[][] vis, int sx, int sy, int ex, int ey, int N) {
		Queue<int[]> q = new ArrayDeque<>();
		vis[sx][sy] = true;
		q.offer(new int[] { sx, sy, 0 });
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			int t = cur[2];
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;
				if (nx == ex && ny == ey) {
					ans = t + 1;
					return;
				}
				if (board[nx][ny] == 1 || vis[nx][ny])
					continue;
				if (board[nx][ny] == 2) {
					if (t % 3 == 2 && !vis[nx][ny]) {
						vis[nx][ny] = true;
						q.offer(new int[] { nx, ny, t + 1 });
					} else {
						q.offer(new int[] { x, y, t + 1 });
					}
				} else {
					vis[nx][ny] = true;
					q.offer(new int[] { nx, ny, t + 1 });
				}
			}
		}
	}
}
import java.io.*;
import java.util.*;

public class Main {
	static final int[] dx = { -1, 0, 1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };
	static final int[] hx = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static final int[] hy = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int N, M;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int[][] board = new int[N][M];
		boolean[][][] vis = new boolean[N][M][K + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = Integer.MAX_VALUE;
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { 0, 0, K, 0 });
		vis[0][0][K] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (cur[0] == N - 1 && cur[1] == M - 1) {
				ans = Math.min(cur[3], ans);
				break;
			}
			if (cur[2] > 0) {
				for (int d = 0; d < 8; d++) {
					int nx = cur[0] + hx[d];
					int ny = cur[1] + hy[d];
					if (limitCheck(nx, ny) && board[nx][ny] != 1 && !vis[nx][ny][cur[2] - 1]) {
						vis[nx][ny][cur[2] - 1] = true;
						q.offer(new int[] { nx, ny, cur[2] - 1, cur[3] + 1 });
					}
				}

			}
			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if (limitCheck(nx, ny) && board[nx][ny] != 1 && !vis[nx][ny][cur[2]]) {
					vis[nx][ny][cur[2]] = true;
					q.offer(new int[] { nx, ny, cur[2], cur[3] + 1, cur[3] + 1 });
				}
			}

		}
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}

	static boolean limitCheck(int x, int y) {
		return (x >= 0 && x < N && y >= 0 && y < M);
	}
}
import java.io.*;
import java.util.*;

public class Main {
	static final int[] dx = { -1, 0, 1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };
	static int N, M;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		char[][] board = new char[N][M];
		int[][][] dist = new int[N][M][2];
		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = row.charAt(j);
			}
		}
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { 0, 0, 0 });
		dist[0][0][0] = 1;
		int ans = -1;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (cur[0] == N - 1 && cur[1] == M - 1) {
				ans = dist[N - 1][M - 1][cur[2]];
				break;
			}
			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if (limitCheck(nx, ny)) {
					if (board[nx][ny] == '1' && cur[2] == 0 && dist[nx][ny][cur[2] + 1] == 0) {
						dist[nx][ny][cur[2] + 1] = dist[cur[0]][cur[1]][cur[2]] + 1;
						q.offer(new int[] { nx, ny, cur[2] + 1 });
					} else {
						if (board[nx][ny] == '0' && dist[nx][ny][cur[2]] == 0) {
							dist[nx][ny][cur[2]] = dist[cur[0]][cur[1]][cur[2]] + 1;
							q.offer(new int[] { nx, ny, cur[2] });
						}
					}
				}
			}

		}
		System.out.println(ans);
	}

	static boolean limitCheck(int x, int y) {
		return (x >= 0 && x < N && y >= 0 && y < M);
	}
}
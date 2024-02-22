import java.io.*;
import java.util.*;

public class Main {
	static final int[] dx = { -1, 0, 1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };
	static int N, board[][], dist[][];
	static int ans;
	static Queue<int[]> bq = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		dist = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				dist[i][j] = -1;
			}
		}
		int iNum = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 1 && dist[i][j] == -1) {
					bfs(i, j, iNum++);
				}
			}
		}
		ans = Integer.MAX_VALUE;
		findBridge();
		System.out.println(ans);
	}

	static void bfs(int x, int y, int iNum) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { x, y });
		bq.offer(new int[] { x, y, iNum });
		board[x][y] = iNum;
		dist[x][y] = 0;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && board[nx][ny] == 1 && dist[nx][ny] == -1) {
					dist[nx][ny] = 0;
					board[nx][ny] = iNum;
					q.offer(new int[] { nx, ny });
					bq.offer(new int[] { nx, ny, iNum });
				}
			}
		}
	}

	static void findBridge() {
		while (!bq.isEmpty()) {
			int[] cur = bq.poll();
			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && board[nx][ny] != cur[2]) {
					if (board[nx][ny] != 0) {
						ans = Math.min(ans, dist[nx][ny] + dist[cur[0]][cur[1]]);
					} else {
						dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
						board[nx][ny] = cur[2];
						bq.offer(new int[] { nx, ny, cur[2] });
					}
				}
			}
		}
	}
}
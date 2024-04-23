import java.io.*;
import java.util.*;

public class Main {
	static final int dx[] = { -1, 0, 1, 0 };
	static final int dy[] = { 0, 1, 0, -1 };
	static int N;
	static char board[][];
	static boolean vis[][][];

	static class Point {
		int x, y, cnt;
		boolean state; // 세로 true

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Point(int x, int y, boolean state, int cnt) {
			this.x = x;
			this.y = y;
			this.state = state;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new char[N][N];
		vis = new boolean[N][N][2];
		int Bcnt = 0, Ecnt = 0;
		int Bt[][] = new int[3][2];
		int Et[][] = new int[3][2];
		Point B = null, E = null;
		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < N; j++) {
				board[i][j] = row.charAt(j);
				if (board[i][j] == 'B') {
					Bt[Bcnt][0] = i;
					Bt[Bcnt][1] = j;
					if (Bcnt == 1) {
						B = new Point(i, j);
						B.cnt = 0;
						if (Bt[0][0] == Bt[1][0] - 1) {
							B.state = true;
							vis[i][j][0] = true;
						} else {
							B.state = false;
							vis[i][j][1] = true;
						}
					}
					Bcnt++;
				}
				if (board[i][j] == 'E') {
					Et[Ecnt][0] = i;
					Et[Ecnt][1] = j;
					if (Ecnt == 1) {
						E = new Point(i, j);
						if (Et[0][0] == Et[1][0] - 1) {
							E.state = true;
						} else
							E.state = false;
					}
					Ecnt++;
				}
			}
		}
		int ans = 0;
		Queue<Point> q = new ArrayDeque<>();
		q.offer(B);
		while (!q.isEmpty()) {
			Point cur = q.poll();
			if (cur.x == E.x && cur.y == E.y && cur.state == E.state) {
				ans = cur.cnt;
				break;
			}
			for (int d = 0; d < 5; d++) {
				if (d == 4) {
					if (Tcheck(cur.x, cur.y)) {
						if (cur.state && !vis[cur.x][cur.y][1]) {
							vis[cur.x][cur.y][1] = true;
							q.offer(new Point(cur.x, cur.y, false, cur.cnt + 1));
						} else if (!cur.state && !vis[cur.x][cur.y][0]) {
							vis[cur.x][cur.y][0] = true;
							q.offer(new Point(cur.x, cur.y, true, cur.cnt + 1));

						}
					}
				} else {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];
					if (nx >= 0 && nx < N && ny >= 0 && ny < N && board[nx][ny] != '1') {
						if (cur.state && !vis[nx][ny][0]) {
							if (nx - 1 >= 0 && nx + 1 < N && board[nx - 1][ny] != '1' && board[nx + 1][ny] != '1') {
								vis[nx][ny][0] = true;
								q.offer(new Point(nx, ny, cur.state, cur.cnt + 1));
							}
						} else if (!cur.state && !vis[nx][ny][1]) {
							if (ny - 1 >= 0 && ny + 1 < N && board[nx][ny - 1] != '1' && board[nx][ny + 1] != '1') {
								vis[nx][ny][1] = true;
								q.offer(new Point(nx, ny, cur.state, cur.cnt + 1));
							}
						}
					}
				}
			}
		}
		System.out.println(ans);
	}

	static boolean Tcheck(int x, int y) {
		if (x == 0 || x == N - 1 || y == 0 || y == N - 1)
			return false;
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				if (board[i][j] == '1') {
					return false;
				}
			}
		}
		return true;
	}
}
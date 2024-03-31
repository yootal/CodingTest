import java.io.*;
import java.util.*;

public class Main {
	static final int[] dx = { -1, 0, 1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };
	static int n, m, vis[][][];
	static char board[][];

	static class Minsik {
		int x, y, dist, key;

		public Minsik(int x, int y, int dist, int key) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.key = key;
		}
	}

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new char[n][m];
		vis = new int[n][m][1 << ('f' - 'a' + 1)];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				Arrays.fill(vis[i][j], 10000);
			}
		}
		Queue<Minsik> q = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			String row = br.readLine();
			for (int j = 0; j < m; j++) {
				board[i][j] = row.charAt(j);
				if (board[i][j] == '0') {
					q.offer(new Minsik(i, j, 0, 0));
					vis[i][j][0] = 0;
				}
			}
		}
		int ans = -1;
		while (!q.isEmpty()) {
			Minsik cur = q.poll();
			if (board[cur.x][cur.y] == '1') {
				ans = cur.dist;
				break;
			}
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] != '#') {
					if (board[nx][ny] >= 'A' && board[nx][ny] <= 'F') {
						if ((cur.key & (1 << (board[nx][ny] - 'A'))) != 0 && vis[nx][ny][cur.key] > cur.dist + 1) {
							vis[nx][ny][cur.key] = cur.dist + 1;
							q.offer(new Minsik(nx, ny, vis[nx][ny][cur.key], cur.key));
						}
					} else if (board[nx][ny] >= 'a' && board[nx][ny] <= 'f') {
						if (vis[nx][ny][cur.key] > cur.dist + 1) {
							vis[nx][ny][cur.key] = cur.dist + 1;
							q.offer(new Minsik(nx, ny, vis[nx][ny][cur.key], cur.key | (1 << (board[nx][ny] - 'a'))));
						}
					} else {
						if (vis[nx][ny][cur.key] > cur.dist + 1) {
							vis[nx][ny][cur.key] = cur.dist + 1;
							q.offer(new Minsik(nx, ny, vis[nx][ny][cur.key], cur.key));
						}
					}
				}
			}
		}
		System.out.println(ans);
	}
}
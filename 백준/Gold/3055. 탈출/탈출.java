import java.io.*;
import java.util.*;

public class Main {
	static final int[] dx = { -1, 0, 1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };

	static class Point {
		int x, y, t;
		boolean flag;

		public Point(int x, int y, int t, boolean flag) {
			this.x = x;
			this.y = y;
			this.t = t;
			this.flag = flag;
		}
	}

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] board = new char[n][m];
		ArrayDeque<Point> q = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			String row = br.readLine();
			for (int j = 0; j < m; j++) {
				board[i][j] = row.charAt(j);
				if (board[i][j] == 'S') {
					q.offerLast(new Point(i, j, 0, true));
				} else if (board[i][j] == '*') {
					q.offerFirst(new Point(i, j, 0, false));
				}
			}
		}
		int ans = -1;
		while (!q.isEmpty()) {
			Point cur = q.poll();
			if (board[cur.x][cur.y] == 'D') {
				ans = cur.t;
				break;
			}
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if (cur.flag && (board[nx][ny] == 'D' || board[nx][ny] == '.')) {
						if (board[nx][ny] != 'D')
							board[nx][ny] = 'S';
						q.offer(new Point(nx, ny, cur.t + 1, cur.flag));
					} else if (!cur.flag && (board[nx][ny] == 'S' || board[nx][ny] == '.')) {
						board[nx][ny] = '*';
						q.offer(new Point(nx, ny, 0, cur.flag));
					}
				}
			}
		}
		System.out.println(ans == -1 ? "KAKTUS" : ans);
	}
}
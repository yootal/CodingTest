import java.io.*;
import java.util.*;

public class Solution {
	static final int[] dx = { -1, 0, 1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };

	static class Point {
		int x, y, time, now;

		public Point(int x, int y, int time, int now) {
			this.x = x;
			this.y = y;
			this.time = time;
			this.now = now;
		}
	}

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			char[][] board = new char[n][m];
			ArrayDeque<Point> q = new ArrayDeque<>(); // 악마부터 보내야 수연이가 못감
			for (int i = 0; i < n; i++) {
				String row = br.readLine();
				for (int j = 0; j < m; j++) {
					board[i][j] = row.charAt(j);
					if (board[i][j] == 'S') {
						q.offerLast(new Point(i, j, 0, 1));
					}
					if (board[i][j] == '*') {
						q.offerFirst(new Point(i, j, 0, 2));
					}
				}
			}
			int ans = -1;
			while (!q.isEmpty()) {
				Point cur = q.poll();
				if (board[cur.x][cur.y] == 'D' && cur.now == 1) {
					ans = cur.time;
					break;
				}
				for (int d = 0; d < 4; d++) {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];
					if (nx >= 0 && nx < n && ny >= 0 && ny < m) {

						// 수연
						if (cur.now == 1 && (board[nx][ny] == '.' || board[nx][ny] == 'D')) {
							if (board[nx][ny] != 'D') {
								board[nx][ny] = 'S';
							}
							q.offer(new Point(nx, ny, cur.time + 1, cur.now));

						}
						// 악마
						else if (cur.now == 2 && (board[nx][ny] == '.' || board[nx][ny] == 'S')) {
							board[nx][ny] = '*';
							q.offer(new Point(nx, ny, 0, cur.now));
						}
					}
				}
			}
			sb.append("#").append(tc + " ").append(ans == -1 ? "GAME OVER" : ans).append("\n");
		}
		System.out.print(sb);
	}
}
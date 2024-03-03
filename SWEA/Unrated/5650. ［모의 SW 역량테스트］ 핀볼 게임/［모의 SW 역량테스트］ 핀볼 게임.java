import java.io.*;
import java.util.*;

public class Solution {
	static final int[] dx = { -1, 0, 1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };
	static int N, cnt, board[][], vis[][][];
	static Point[][] wormHole;

	static class Point {
		int x, y, d;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());
		board = new int[100][100];
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			wormHole = new Point[5][2];
			vis = new int[N][N][4];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if (board[i][j] > 5) {
						if (wormHole[board[i][j] - 6][0] == null) {
							wormHole[board[i][j] - 6][0] = new Point(i, j);
						} else
							wormHole[board[i][j] - 6][1] = new Point(i, j);
					}
				}
			}
			int ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] == 0) {
						for (int d = 0; d < 4; d++) {
							if (vis[i][j][d] == 1)
								continue;
							vis[i][j][d] = 1;
							cnt = 1;
							pinBall(i, j, d);
							ans = Math.max(ans, cnt - 1);
						}
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

	static void pinBall(int sx, int sy, int sd) {
		int x = sx;
		int y = sy;
		int d = sd;
		while (true) {
			int cur = board[x][y];
			if (cur > 0 && cur < 6) { // 블록이면 방향 바꾸기
				cnt++;
				switch (cur) {
				case 1:
					if (d == 2) {
						d = 1;
					} else if (d == 3) {
						d = 0;
					} else {
						d = (d + 2) % 4;
					}
					break;
				case 2:
					if (d == 0) {
						d = 1;
					} else if (d == 3) {
						d = 2;
					} else {
						d = (d + 2) % 4;
					}
					break;
				case 3:
					if (d == 0) {
						d = 3;
					} else if (d == 1) {
						d = 2;
					} else {
						d = (d + 2) % 4;
					}
					break;
				case 4:
					if (d == 2) {
						d = 3;
					} else if (d == 1) {
						d = 0;
					} else {
						d = (d + 2) % 4;
					}
					break;
				case 5:
					d = (d + 2) % 4;
					break;
				}
			}
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
				cnt++;
				d = (d + 2) % 4;
				nx = x;
				ny = y;
			}
			if (board[nx][ny] == -1 || (nx == sx && ny == sy))
				return;
			if (board[nx][ny] > 5) {
				int idx = board[nx][ny] - 6;
				if (nx == wormHole[idx][0].x && ny == wormHole[idx][0].y) {
					nx = wormHole[idx][1].x;
					ny = wormHole[idx][1].y;
				} else {
					nx = wormHole[idx][0].x;
					ny = wormHole[idx][0].y;
				}
			}
			if (vis[nx][ny][d] == cnt)
				return;
			vis[nx][ny][d] = cnt;
			x = nx;
			y = ny;
		}
	}
}
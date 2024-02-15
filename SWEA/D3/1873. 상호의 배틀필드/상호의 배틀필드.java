import java.io.*;
import java.util.*;

public class Solution {
	static int N, M;
	static char[][] map;
	static Tank tank;
	static String tank_check = "^v<>";
	static final int[] dx = { -1, 1, 0, 0 };
	static final int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			for (int i = 0; i < N; i++) {
				String row = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = row.charAt(j);
					if (tank_check.contains(row.substring(j, j + 1))) {
						tank = new Tank(i, j, direction(map[i][j]));
						map[i][j] = '.';
					}
				}
			}
			int L = Integer.parseInt(br.readLine());
			String cmd = br.readLine();
			for (int i = 0; i < L; i++) {
				game(cmd.charAt(i));
			}
			map[tank.x][tank.y] = tank_check.charAt(tank.d);
			sb.append("#").append(tc).append(" ");
			for (char[] row : map) {
				for (char c : row) {
					sb.append(c);
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}

	static void game(char cmd) {
		if (cmd == 'S') {
			shoot(tank.x, tank.y);
			return;
		}
		if (cmd == 'U') {
			tank.d = 0;
		} else if (cmd == 'D') {
			tank.d = 1;
		} else if (cmd == 'L') {
			tank.d = 2;
		} else {
			tank.d = 3;
		}
		int nx = tank.x + dx[tank.d];
		int ny = tank.y + dy[tank.d];
		if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == '.') {
			tank.x = nx;
			tank.y = ny;
		}
	}

	static void shoot(int x, int y) {
		int nx = x + dx[tank.d];
		int ny = y + dy[tank.d];
		if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
			if (map[nx][ny] == '#')
				return;
			else if (map[nx][ny] == '*') {
				map[nx][ny] = '.';
				return;
			} else {
				shoot(nx, ny);
			}
		}
	}

	static int direction(char cur) {
		if (cur == '^')
			return 0;
		else if (cur == 'v')
			return 1;
		else if (cur == '<')
			return 2;
		else
			return 3;
	}

	static class Tank {
		int x, y, d;

		public Tank(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}

	}
}
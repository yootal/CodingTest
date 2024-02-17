import java.io.*;
import java.util.*;

public class Solution {
	static final int[] dx = { 0, -1, 0, 1, 0 };
	static final int[] dy = { 0, 0, 1, 0, -1 };
	static int M, A, total, move[][], ap[];
	static int map[][][];
	static User u1, u2;
	static Queue<int[]> q;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			map = new int[10][10][A + 1];
			ap = new int[A + 1];
			move = new int[2][M];
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					move[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 1; i <= A; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken()) - 1;
				int x = Integer.parseInt(st.nextToken()) - 1;
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				ap[i] = p;
				paintMap(x, y, c, i);
			}

			total = 0;
			u1 = new User(0, 0);
			u2 = new User(9, 9);

			for (int k = 0; k <= M; k++) {
				// 둘다 오버랩 아닐때
				if (map[u1.x][u1.y][1] == 0 && map[u2.x][u2.y][1] == 0) {
					if (map[u1.x][u1.y][0] == map[u2.x][u2.y][0]) {
						total += ap[map[u1.x][u1.y][0]];
					} else {
						total += ap[map[u1.x][u1.y][0]] + ap[map[u2.x][u2.y][0]];
					}
				} else {
					// 오버랩이면 반복 아니면 1번 설정하고 반복 슈루룩
					int r1 = 1;
					for (int i = 1; i <= A; i++) {
						if (i == A || map[u1.x][u1.y][i] == 0) {
							r1 = i;
							break;
						}
					}
					int r2 = 1;
					for (int i = 1; i <= A; i++) {
						if (i == A || map[u2.x][u2.y][i] == 0) {
							r2 = i;
							break;
						}
					}
					int maxScore = 0;
					for (int i = 0; i < r1; i++) {
						for (int j = 0; j < r2; j++) {
							if (map[u1.x][u1.y][i] == map[u2.x][u2.y][j]) {
								maxScore = Math.max(maxScore, ap[map[u1.x][u1.y][i]]);
							} else {
								maxScore = Math.max(maxScore, ap[map[u1.x][u1.y][i]] + ap[map[u2.x][u2.y][j]]);
							}
						}
					}
					total += maxScore;
				}
				if (k == M)
					break;
				u1.x += dx[move[0][k]];
				u1.y += dy[move[0][k]];
				u2.x += dx[move[1][k]];
				u2.y += dy[move[1][k]];
			}
			sb.append("#").append(tc).append(" ").append(total).append("\n");
		}
		System.out.print(sb);
	}

	static void paintMap(int x, int y, int c, int num) {
		if (map[x][y][0] == 0) {
			map[x][y][0] = num;
		} else {
			int temp = map[x][y][0];
			for (int i = 0; i < A; i++) {
				if (map[x][y][i] == 0) {
					map[x][y][i] = temp;
					map[x][y][0] = num;
					break;
				}
			}
		}
		q = new ArrayDeque<int[]>();
		q.offer(new int[] { x, y, 0 });
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 1; d < 5; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if (nx >= 0 && nx < 10 && ny >= 0 && ny < 10 && cur[2] < c) {
					if (map[nx][ny][0] == 0) {
						map[nx][ny][0] = num;
						q.offer(new int[] { nx, ny, cur[2] + 1 });
					} else if (map[nx][ny][0] != num) { // 오버랩이면 표시
						int temp = map[nx][ny][0];
						for (int i = 0; i < A; i++) {
							if (map[nx][ny][i] == 0) {
								map[nx][ny][i] = temp;
								map[nx][ny][0] = num;
								break;
							}
						}
						q.offer(new int[] { nx, ny, cur[2] + 1 });
					}
				}

			}
		}
	}

	static class User {
		int x, y;

		public User(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
}
import java.io.*;
import java.util.*;

public class Main {
	static final int[] dx = { 0, -1, 0, 1 };
	static final int[] dy = { -1, 0, 1, 0 };
	static int N, time, area[][];
	static boolean vis[][];
	static Shark s;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		area = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
				if (area[i][j] == 9) {
					s = new Shark(i, j, 2);
					area[i][j] = 0;
				}
			}
		}
		while (true) {
			if (!bfs())
				break;
		}
		System.out.println(time);
	}

	static boolean bfs() {
		Queue<int[]> q = new ArrayDeque<int[]>();
		vis = new boolean[N][N];
		vis[s.x][s.y] = true;
		int minDist = Integer.MAX_VALUE;
		int[] minPos = new int[2];
		q.offer(new int[] { s.x, s.y, 0 });
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !vis[nx][ny]) {
					if (area[nx][ny] > 0) {
						if (area[nx][ny] == s.size) {
							vis[nx][ny] = true;
							q.offer(new int[] { nx, ny, cur[2] + 1 });
						} else if (area[nx][ny] < s.size) {
							vis[nx][ny] = true;
							if (minDist > cur[2] + 1) {
								minDist = cur[2] + 1;
								minPos = new int[] { nx, ny };
							} else if (minDist == cur[2] + 1) {
								if (minPos[0] > nx) {
									minPos = new int[] { nx, ny };
								} else if (minPos[0] == nx && minPos[1] > ny) {
									minPos = new int[] { nx, ny };
								}
							}
							q.offer(new int[] { nx, ny, cur[2] + 1 });
						}
					} else {
						vis[nx][ny] = true;
						q.offer(new int[] { nx, ny, cur[2] + 1 });
					}
				}
			}
		}
		if (minDist != Integer.MAX_VALUE) {
			area[minPos[0]][minPos[1]] = 0;
			s.x = minPos[0];
			s.y = minPos[1];
			s.cnt++;
			if (s.cnt == s.size) {
				s.size++;
				s.cnt = 0;
			}
			time += minDist;
			return true;
		}
		return false;
	}

	static class Shark {
		int x, y, size, cnt;

		public Shark(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.cnt = 0;
		}

	}
}
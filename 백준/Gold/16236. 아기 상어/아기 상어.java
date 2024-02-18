import java.io.*;
import java.util.*;

public class Main {
	static final int[] dx = { 0, -1, 0, 1 };
	static final int[] dy = { -1, 0, 1, 0 };
	static int N, time, area[][];
	static boolean vis[][];
	static Shark s; // 상어

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
				if (area[i][j] == 9) { // 상어 좌표 기록하고 맵에 표시 지우기
					s = new Shark(i, j, 2);
					area[i][j] = 0;
				}
			}
		}
		while (true) {
			if (!bfs()) // 먹을 물고기 없을 때까지 반복
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
		q.offer(new int[] { s.x, s.y, 0 }); // 상어 좌표와 거리
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !vis[nx][ny]) {
					if (area[nx][ny] > 0) { // 물고기가 있는 곳
						if (area[nx][ny] == s.size) { // 상어 크기와 같으면 지나가기만
							vis[nx][ny] = true;
							q.offer(new int[] { nx, ny, cur[2] + 1 });
						} else if (area[nx][ny] < s.size) { // 상어 크기보다 작은 것 중 가깝고 위쪽, 왼쪽 선정
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
					} else { // 물고기 없으면 그냥 거리만 + 1 
						vis[nx][ny] = true;
						q.offer(new int[] { nx, ny, cur[2] + 1 });
					}
				}
			}
		}
		if (minDist != Integer.MAX_VALUE) { // 물고기가 있으면 먹고 거리 카운팅 후 먹었다 표시
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
		return false; // 물고기 없으면 못먹었어요~
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
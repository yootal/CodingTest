import java.io.*;
import java.util.*;

public class Solution {
	static final int[] dx = { -1, 0, 1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };
	static int N, M, K, grid[][], live[][], turn, time;
	static Queue<Point> pointQ = new ArrayDeque<>();
	static PriorityQueue<Point> pq = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			grid = new int[700][700];
			live = new int[700][700];
			pointQ.clear();
			pq.clear();

			for (int i = 0; i < 700; i++) {
				for (int j = 0; j < 700; j++) {
					live[i][j] = -1;
				}
			}

			for (int i = 300; i < 300 + N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 300; j < 300 + M; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
					if (grid[i][j] != 0) {
						pointQ.offer(new Point(i, j, grid[i][j]));
						live[i][j] = 0;
					}
				}
			}

			time = 0;
			turn = -1;
			while (time < K) {
				change();
				if (!pq.isEmpty()) {
					turn = time + 1;
				}
				time++;
			}
			sb.append("#").append(tc).append(" ").append(pointQ.size()).append("\n");
		}
		System.out.print(sb);
	}

	static void change() {
		Queue<Point> nextPointQ = new ArrayDeque<>();
		PriorityQueue<Point> nextPq = new PriorityQueue<>();
		for (Point p : pointQ) {
			live[p.x][p.y]++;
			if (live[p.x][p.y] == p.value) {
				nextPq.offer(p);
			} else if (live[p.x][p.y] == p.value * 2) {
				live[p.x][p.y] = -2;
				continue;
			}
			nextPointQ.offer(p);
		}
		if (time == turn)
			bfs(nextPointQ);

		pointQ = nextPointQ;
		pq = nextPq;
	}

	static void bfs(Queue<Point> nextPointQ) {
		while (!pq.isEmpty()) {
			Point cur = pq.poll();
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				if (live[nx][ny] == -1) {
					grid[nx][ny] = grid[cur.x][cur.y];
					live[nx][ny] = 0;
					nextPointQ.offer(new Point(nx, ny, grid[nx][ny]));
				}
			}
		}
	}

	static class Point implements Comparable<Point> {
		int x, y, value;

		public Point(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}

		@Override
		public int compareTo(Point o) {
			return o.value - value;
		}
	}
}
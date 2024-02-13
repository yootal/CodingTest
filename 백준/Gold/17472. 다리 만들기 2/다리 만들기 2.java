import java.io.*;
import java.util.*;

public class Main {
	static final int[] dx = { -1, 0, 1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };
	static int n;
	static int m;
	static int[][] map;
	static ArrayList<Node>[] graph;
	static int island_limit;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()) == 1 ? -1 : 0;
			}
		}
		island_limit = find_island();
		graph = new ArrayList[island_limit + 1];
		for (int i = 1; i <= island_limit; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 0) {
					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0) {
							find_line(i, j, nx, ny, d, 0);
						}
					}
				}
			}
		}
		boolean[] vis = new boolean[island_limit + 1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(1, 0));
		int ans = 0;
		int useCnt = 0;
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (vis[cur.nxt])
				continue;
			vis[cur.nxt] = true;
			ans += cur.v;
			useCnt++;
			for (Node nxt : graph[cur.nxt]) {
				if (!vis[nxt.nxt]) {
					pq.offer(nxt);
				}
			}
		}
		System.out.println(useCnt == island_limit ? ans : -1);
	}

	static int find_island() {
		int island_num = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == -1) {
					Queue<int[]> q = new ArrayDeque<>();
					map[i][j] = island_num;
					q.offer(new int[] { i, j });
					while (!q.isEmpty()) {
						int[] cur = q.poll();
						for (int d = 0; d < 4; d++) {
							int nx = cur[0] + dx[d];
							int ny = cur[1] + dy[d];
							if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == -1) {
								map[nx][ny] = island_num;
								q.offer(new int[] { nx, ny });
							}
						}
					}
					island_num++;
				}
			}
		}
		return island_num - 1;
	}

	static void find_line(int sx, int sy, int px, int py, int d, int dist) {
		if (map[px][py] != 0) {
			if (dist >= 2) {
				graph[map[sx][sy]].add(new Node(map[px][py], dist));
				graph[map[px][py]].add(new Node(map[sx][sy], dist));
			}
			return;
		}
		int nx = px + dx[d];
		int ny = py + dy[d];
		if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
			find_line(sx, sy, nx, ny, d, dist + 1);
		}

	}

	static class Node implements Comparable<Node> {
		int nxt, v;

		public Node(int nxt, int v) {
			this.nxt = nxt;
			this.v = v;
		}

		@Override
		public int compareTo(Node o) {
			return v - o.v;
		}

	}
}
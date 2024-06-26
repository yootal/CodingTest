import java.util.*;
import java.io.*;

class Main {
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static int N, ans, map[][], dist[][];
	static boolean check[];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[N][N];
		ArrayList<int[]> al = new ArrayList<>();
		int idx = -2;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					map[i][j] = idx--;
					al.add(new int[] { i, j });
				} else if (map[i][j] == -1) {
					al.add(0, new int[] { i, j });
				}
			}
		}
		if (al.size() == 1) {
			System.out.println(0);
		} else {
			dist = new int[al.size()][al.size()];
			for (int row[] : dist) {
				Arrays.fill(row, 1000001);
			}
			for (int i = 0; i < al.size(); i++) {
				int cur[] = al.get(i);
				bfs(cur[0], cur[1]);
			}
			ans = Integer.MAX_VALUE;
			check = new boolean[al.size()];
			check[0] = true;
			solve(0, 0, 0, al.size());
			System.out.println(ans);
		}
	}

	static void bfs(int x, int y) {
		int tempDist[][] = new int[N][N];
		for (int[] row : tempDist) {
			Arrays.fill(row, 1000001);
		}
		tempDist[x][y] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
		pq.offer(new int[] { x, y, tempDist[x][y] });
		while (!pq.isEmpty()) {
			int cur[] = pq.poll();
			if (cur[2] != tempDist[cur[0]][cur[1]])
				continue;
			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if (map[nx][ny] < 0) {
						if (cur[2] < dist[-map[x][y] - 1][-map[nx][ny] - 1]) {
							dist[-map[x][y] - 1][-map[nx][ny] - 1] = cur[2];
							tempDist[nx][ny] = cur[2];
							pq.offer(new int[] { nx, ny, tempDist[nx][ny] });
						}
					} else if ((cur[2] + map[nx][ny] < tempDist[nx][ny])) {
						tempDist[nx][ny] = cur[2] + map[nx][ny];
						pq.offer(new int[] { nx, ny, tempDist[nx][ny] });
					}
				}
			}
		}
	}

	static void solve(int depth, int total, int pre, int size) {
		if (depth == size - 1) {
			ans = Math.min(ans, total + dist[pre][0]);
			return;
		}
		for (int i = 0; i < size; i++) {
			if (check[i])
				continue;
			check[i] = true;
			solve(depth + 1, total + dist[pre][i], i, size);
			check[i] = false;
		}
	}
}
import java.io.*;
import java.util.*;

class Main {
	static final int dx[] = { -1, 0, 1, 0 };
	static final int dy[] = { 0, 1, 0, -1 };
	static int N, M, block[][], vis[][];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		block = new int[N][M];
		vis = new int[N][M];
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				block[i][j] = Integer.parseInt(st.nextToken());
				pq.offer(new int[] { i, j, block[i][j] });
			}
		}
		int ans = 0, idx = 1;
		while (!pq.isEmpty()) {
			int cur[] = pq.poll();
			if (cur[2] != block[cur[0]][cur[1]])
				continue;
			ans += fill(cur[0], cur[1], idx++);
		}
		System.out.println(ans);
	}

	static int fill(int x, int y, int idx) {
		vis[x][y] = idx;
		int h = Integer.MAX_VALUE;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { x, y });
		while (!q.isEmpty()) {
			int cur[] = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				// 나간 경우
				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					return 0;
				else if (vis[nx][ny] == idx)
					continue;
				// 더 낮거나 같은 경우
				else if (block[nx][ny] <= block[cur[0]][cur[1]]) {
					vis[nx][ny] = idx;
					q.offer(new int[] { nx, ny });
				}
				// 더 높은 경우 (물이 찰 수 있는 높이)
				else {
					h = Math.min(h, block[nx][ny]);
				}
			}
		}
		int total = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (vis[i][j] == idx) {
					total += h - block[i][j];
					block[i][j] = h; // 갱신 해줘야 함
				}
			}
		}
		return total;
	}
}
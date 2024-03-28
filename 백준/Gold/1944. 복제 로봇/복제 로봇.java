import java.io.*;
import java.util.*;

public class Main {
	static final int[] dx = { -1, 0, 1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] board = new char[n][n];
		int[][] key = new int[n][n];
		int keyIdx = 1;
		int[] start = null;
		ArrayList<int[]> points = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String row = br.readLine();
			for (int j = 0; j < n; j++) {
				board[i][j] = row.charAt(j);
				if (board[i][j] == 'S') {
					start = new int[] { i, j };
					points.add(new int[] { i, j });
					key[i][j] = keyIdx;
					keyIdx++;
				}
				if (board[i][j] == 'K') {
					points.add(new int[] { i, j });
					key[i][j] = keyIdx;
					keyIdx++;
				}
			}
		}
		ArrayList<int[]>[] graph = new ArrayList[keyIdx];
		for (int i = 0; i < keyIdx; i++) {
			graph[i] = new ArrayList<>();
		}
		ArrayDeque<int[]> q;
		int[][] vis = new int[n][n];
		for (int i = 0; i < points.size(); i++) {
			q = new ArrayDeque<>();
			int[] point = points.get(i);
			q.offer(new int[] { point[0], point[1], 0 });
			vis[point[0]][point[1]] = key[point[0]][point[1]];
			while (!q.isEmpty()) {
				int[] cur = q.poll();
				for (int d = 0; d < 4; d++) {
					int nx = cur[0] + dx[d];
					int ny = cur[1] + dy[d];
					if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] != '1'
							&& vis[nx][ny] != vis[cur[0]][cur[1]]) {
						vis[nx][ny] = vis[cur[0]][cur[1]];
						if (board[nx][ny] == 'K') {
							graph[key[nx][ny]].add(new int[] { vis[cur[0]][cur[1]], cur[2] + 1 });
							graph[vis[cur[0]][cur[1]]].add(new int[] { key[nx][ny], cur[2] + 1 });
						} else {
							q.offer(new int[] { nx, ny, cur[2] + 1 });
						}
					}
				}
			}
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		for (int[] cur : graph[key[start[0]][start[1]]]) {
			pq.offer(cur);
		}
		boolean[] v = new boolean[m + 2];
		v[key[start[0]][start[1]]] = true;
		int cnt = 0;
		int ans = 0;
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			if (v[cur[0]])
				continue;
			v[cur[0]] = true;
			ans += cur[1];
			cnt++;
			for (int[] nxt : graph[cur[0]]) {
				if (!v[nxt[0]]) {
					pq.offer(nxt);
				}
			}
		}
		System.out.println(cnt == m ? ans : -1);
	}
}
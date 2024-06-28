import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int ic = 1; ic <= T; ic++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			ArrayList<int[]> graph[] = new ArrayList[n + 1];
			for (int i = 1; i <= n; i++) {
				graph[i] = new ArrayList<>();
			}
			for (int id = 0; id < d; id++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				// a -> b
				graph[b].add(new int[] { a, s });
			}
			PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
			int dist[] = new int[n + 1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[c] = 0;
			int time = 0;
			pq.offer(new int[] { c, dist[c] });
			while (!pq.isEmpty()) {
				int cur[] = pq.poll();
				if (dist[cur[0]] != cur[1])
					continue;
				time = Math.max(time, dist[cur[0]]);
				for (int nxt[] : graph[cur[0]]) {
					if (dist[nxt[0]] > cur[1] + nxt[1]) {
						dist[nxt[0]] = cur[1] + nxt[1];
						pq.offer(new int[] { nxt[0], dist[nxt[0]] });
					}
				}
			}
			int cnt = 0;
			for (int v : dist) {
				if (v != Integer.MAX_VALUE) {
					cnt++;
				}
			}
			sb.append(cnt).append(" ").append(time).append("\n");
		}
		System.out.print(sb);
	}
}
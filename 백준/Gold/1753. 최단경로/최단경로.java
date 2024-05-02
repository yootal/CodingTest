import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		ArrayList<int[]>[] graph = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}
		int[] dist = new int[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[u].add(new int[] { v, w });
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		dist[K] = 0;
		pq.offer(new int[] { K, dist[K] });
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			if (cur[1] != dist[cur[0]])
				continue;
			for (int[] nxt : graph[cur[0]]) {
				if (cur[1] + nxt[1] < dist[nxt[0]]) {
					dist[nxt[0]] = cur[1] + nxt[1];
					pq.offer(new int[] { nxt[0], dist[nxt[0]] });
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			sb.append(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]).append("\n");
		}
		System.out.print(sb);
	}
}
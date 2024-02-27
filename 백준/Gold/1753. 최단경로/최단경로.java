import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node> {
		int vertex, weight;
		Node link;

		public Node(int vertex, int weight, Node link) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.link = link;
		}

		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}

	}

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		Node[] nodeList = new Node[V + 1];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			nodeList[s] = new Node(e, v, nodeList[s]);
		}
		int[] dist = new int[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[K] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		pq.offer(new int[] { K, dist[K] });
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			if (dist[cur[0]] != cur[1])
				continue;
			for (Node nxt = nodeList[cur[0]]; nxt != null; nxt = nxt.link) {
				if (dist[nxt.vertex] > dist[cur[0]] + nxt.weight) {
					dist[nxt.vertex] = dist[cur[0]] + nxt.weight;
					pq.offer(new int[] { nxt.vertex, dist[nxt.vertex] });
				}
			}
		}
		for (int i = 1; i <= V; i++) {
			sb.append(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]).append("\n");
		}
		System.out.print(sb);
	}
}
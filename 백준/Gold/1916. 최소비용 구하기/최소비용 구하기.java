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
			return Integer.compare(weight, o.weight);
		}

	}

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		Node[] nl = new Node[V + 1];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			nl[from] = new Node(to, weight, nl[from]);
		}
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int[] dist = new int[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[s] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		pq.offer(new int[] { s, dist[s] });
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			if (dist[cur[0]] != cur[1])
				continue;
			if (cur[0] == e)
				break;
			for (Node nxt = nl[cur[0]]; nxt != null; nxt = nxt.link) {
				if (dist[nxt.vertex] > dist[cur[0]] + nxt.weight) {
					dist[nxt.vertex] = dist[cur[0]] + nxt.weight;
					pq.offer(new int[] { nxt.vertex, dist[nxt.vertex] });
				}
			}
		}
		System.out.println(dist[e]);
	}
}
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String args[]) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(stt.nextToken());
		int E = Integer.parseInt(stt.nextToken());
		int st = Integer.parseInt(br.readLine());
		int[] sdt = new int[V + 1];
		ArrayList<Edge>[] graph = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) {
			graph[i] = new ArrayList<Edge>();
		}
		for (int i = 0; i < E; i++) {
			stt = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(stt.nextToken());
			int v = Integer.parseInt(stt.nextToken());
			int w = Integer.parseInt(stt.nextToken());
			graph[u].add(new Edge(v, w));
		}
		for (int i = 1; i <= V; i++) {
			sdt[i] = Integer.MAX_VALUE;
		}
		sdt[st] = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		pq.offer(new Edge(st, sdt[st]));
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (cur.value != sdt[cur.vertex])
				continue;
			for (Edge nxt : graph[cur.vertex]) {
				if (sdt[nxt.vertex] > cur.value + nxt.value) {
					sdt[nxt.vertex] = cur.value + nxt.value;
					pq.offer(new Edge(nxt.vertex, sdt[nxt.vertex]));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			sb.append(sdt[i] == Integer.MAX_VALUE ? "INF" : sdt[i]).append("\n");
		}
		System.out.print(sb);
	}

	static class Edge implements Comparable<Edge> {
		int vertex, value;

		Edge(int vertex, int value) {
			this.vertex = vertex;
			this.value = value;
		}

		@Override
		public int compareTo(Edge e) {
			if (this.value > e.value)
				return 1;
			else
				return -1;
		}
	}
}
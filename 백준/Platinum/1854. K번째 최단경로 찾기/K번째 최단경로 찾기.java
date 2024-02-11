import java.io.*;
import java.util.*;

public class Main {

	public static void main(String args[]) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stt.nextToken());
		int M = Integer.parseInt(stt.nextToken());
		int K = Integer.parseInt(stt.nextToken());
		ArrayList<Edge>[] graph = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<Edge>();
		}
		for (int i = 0; i < M; i++) {
			stt = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stt.nextToken());
			int b = Integer.parseInt(stt.nextToken());
			int c = Integer.parseInt(stt.nextToken());
			graph[a].add(new Edge(b, c));
		}
		PriorityQueue<Integer>[] findK = new PriorityQueue[N + 1];
		for (int i = 1; i <= N; i++) {
			findK[i] = new PriorityQueue<Integer>(Comparator.reverseOrder());
		}
		findK[1].offer(0);
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		pq.offer(new Edge(1, 0));
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			for (Edge nxt : graph[cur.vertex]) {
				if (findK[nxt.vertex].size() < K) {
					findK[nxt.vertex].offer(cur.value + nxt.value);
					pq.offer(new Edge(nxt.vertex, cur.value + nxt.value));
				} else if (findK[nxt.vertex].peek() > cur.value + nxt.value) {
					findK[nxt.vertex].poll();
					findK[nxt.vertex].offer(cur.value + nxt.value);
					pq.offer(new Edge(nxt.vertex, cur.value + nxt.value));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(findK[i].size() == K ? findK[i].peek() : -1).append("\n");
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
			return this.value > e.value ? 1 : -1;
		}
	}
}
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			ArrayList<Node>[] graph = new ArrayList[n + 1];
			for (int i = 1; i <= n; i++) {
				graph[i] = new ArrayList<>();
			}
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				double d = Double.parseDouble(st.nextToken());
				if ((a == g && b == h) || (a == h && b == g))
					d -= 0.1;
				graph[a].add(new Node(b, d));
				graph[b].add(new Node(a, d));
			}
			int[] temp = new int[t];
			for (int i = 0; i < t; i++) {
				temp[i] = Integer.parseInt(br.readLine());
			}
			double[] sdt = new double[n + 1];
			Arrays.fill(sdt, Double.MAX_VALUE);
			sdt[s] = 0;
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(new Node(s, sdt[s]));
			while (!pq.isEmpty()) {
				Node cur = pq.poll();
				if (sdt[cur.idx] != cur.dist)
					continue;
				for (Node nxt : graph[cur.idx]) {
					if (sdt[nxt.idx] > sdt[cur.idx] + nxt.dist) {
						sdt[nxt.idx] = sdt[cur.idx] + nxt.dist;
						pq.offer(new Node(nxt.idx, sdt[nxt.idx]));
					}
				}
			}
			Arrays.sort(temp);
			for (int idx : temp) {
				if (sdt[idx] != Math.ceil(sdt[idx]))
					sb.append(idx + " ");
			}
			sb.append("\n");
		}
		System.out.print(sb);

	}

	static class Node implements Comparable<Node> {
		int idx;
		double dist;

		public Node(int idx, double dist) {
			this.idx = idx;
			this.dist = dist;
		}

		public int compareTo(Node o) {
			return Double.compare(dist, o.dist);
		}
	}
}
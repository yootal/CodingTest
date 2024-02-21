import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		ArrayList<Node>[] graph;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			graph = new ArrayList[V + 1];
			for (int i = 1; i <= V; i++) {
				graph[i] = new ArrayList<>();
			}
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				graph[a].add(new Node(b, v));
				graph[b].add(new Node(a, v));
			}
			boolean[] vis = new boolean[V + 1];
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(new Node(1, 0));
			int cnt = 0;
			long ans = 0;
			while (cnt < V) {
				Node cur = pq.poll();
				if (vis[cur.nxt])
					continue;
				vis[cur.nxt] = true;
				ans += cur.v;
				cnt++;
				for (Node nxt : graph[cur.nxt]) {
					if (!vis[nxt.nxt])
						pq.offer(nxt);
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

	static class Node implements Comparable<Node> {
		int nxt, v;

		public Node(int nxt, int v) {
			this.nxt = nxt;
			this.v = v;
		}

		@Override
		public int compareTo(Node o) {
			return v - o.v;
		}

	}

}
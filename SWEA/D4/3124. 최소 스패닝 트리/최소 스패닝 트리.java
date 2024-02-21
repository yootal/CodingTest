import java.io.*;
import java.util.*;

public class Solution {
	static int[] parent;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			parent = new int[V + 1];
			for (int i = 1; i <= V; i++) {
				parent[i] = i;
			}
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				pq.offer(new Edge(a, b, v));
			}
			int cnt = 0;
			long ans = 0;
			while (cnt < V - 1) {
				Edge cur = pq.poll();
				if (union(cur.s, cur.e)) {
					ans += cur.v;
					cnt++;
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

	static int find(int cur) {
		if (cur != parent[cur])
			parent[cur] = find(parent[cur]);
		return parent[cur];
	}

	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y)
			return false;
		parent[y] = x;
		return true;
	}

	static class Edge implements Comparable<Edge> {
		int s, e, v;

		public Edge(int s, int e, int v) {
			this.s = s;
			this.e = e;
			this.v = v;
		}

		@Override
		public int compareTo(Edge o) {
			return v - o.v;
		}

	}

}
import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			pq.offer(new Edge(a, b, v));
		}
		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		int ans = 0;
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (union(cur.a, cur.b)) {
				ans += cur.value;
			}
		}
		System.out.println(ans);
	}

	static class Edge implements Comparable<Edge> {
		int a, b, value;

		public Edge(int a, int b, int value) {
			this.a = a;
			this.b = b;
			this.value = value;
		}

		@Override
		public int compareTo(Edge o) {
			return value - o.value;
		}
	}

	static int find(int x) {
		if (x != parent[x])
			parent[x] = find(parent[x]);
		return parent[x];
	}

	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y) {
			return false;
		} else {
			parent[y] = x;
			return true;
		}
	}
}
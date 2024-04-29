import java.io.*;
import java.util.*;

class Main {
	static int parent[];

	static class Edge implements Comparable<Edge> {
		int x, y, w;

		public Edge(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}

		@Override
		public int compareTo(Edge x) {
			return Integer.compare(this.w, x.w);
		}
	}

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			pq.offer(new Edge(a, b, c));
		}
		int ans = 0;
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (cur.x == cur.y)
				continue;
			if (union(cur.x, cur.y)) {
				ans += cur.w;
			}
		}
		System.out.println(ans);
	}

	static int find(int a) {
		if (parent[a] != a)
			parent[a] = find(parent[a]);
		return parent[a];
	}

	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b)
			return false;
		if (a < b)
			parent[a] = b;
		else
			parent[b] = a;
		return true;
	}
}
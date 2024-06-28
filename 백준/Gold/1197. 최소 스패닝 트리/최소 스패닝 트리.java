import java.util.*;
import java.io.*;

class Main {
	static int[] parent;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Edge edges[] = new Edge[m];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(a, b, v);
		}
		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		Arrays.sort(edges);
		int ans = 0;
		int useCnt = 0;
		int idx = 0;
		while (useCnt < n - 1) {
			Edge cur = edges[idx++];
			if (union(cur.a, cur.b)) {
				ans += cur.value;
				useCnt++;
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
			return Integer.compare(this.value, o.value);
		}
	}

	static int find(int x) {
		if (x == parent[x])
			return x;
		return parent[x] = find(parent[x]);
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
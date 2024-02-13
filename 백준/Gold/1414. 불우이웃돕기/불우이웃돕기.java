import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		int sum = 0;
		for (int i = 0; i < n; i++) {
			String row = br.readLine();
			for (int j = 0; j < n; j++) {
				char c = row.charAt(j);
				if (c == '0')
					continue;
				else if ('Z' >= c) {
					int value = c - 'A' + 27;
					sum += value;
					pq.offer(new Edge(i, j, value));
				} else {
					int value = c - 'a' + 1;
					sum += value;
					pq.offer(new Edge(i, j, value));
				}
			}
		}
		int ans = 0;
		int useCnt = 0;
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (union(cur.s, cur.e)) {
				ans += cur.v;
				useCnt++;
			}
		}
		System.out.println(useCnt == n - 1 ? sum - ans : -1);
	}

	static int find(int x) {
		if (x != parent[x])
			parent[x] = find(parent[x]);
		return parent[x];
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
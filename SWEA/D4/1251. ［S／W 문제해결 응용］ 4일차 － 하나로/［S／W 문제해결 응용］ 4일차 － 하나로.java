import java.io.*;
import java.util.*;

public class Solution {
	static double e;
	static int[] parent; // 크루스칼(유니온 + 파인드)에 사용할 부모 저장 배열

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			parent = new int[N];
			for (int i = 0; i < N; i++) {
				parent[i] = i;
			}
			Point[] points = new Point[N];
			for (int i = 0; i < N; i++) {
				points[i] = new Point();
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				points[i].x = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				points[i].y = Integer.parseInt(st.nextToken());
			}
			e = Double.parseDouble(br.readLine());
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			for (int i = 0; i < N - 1; i++) {
				for (int j = i; j < N; j++) {
					pq.offer(new Edge(i, j, calcCost(points[i], points[j])));
				}
			}
			int cnt = 0;
			double ans = 0;
			while (cnt < N - 1) {
				Edge cur = pq.poll();
				if (union(cur.s, cur.e)) {
					ans += cur.v;
					cnt++;
				}
			}
			sb.append("#").append(tc).append(" ").append(String.format("%.0f", ans)).append("\n");
		}
		System.out.print(sb);
	}

	static double calcCost(Point p1, Point p2) {
		return e * ((Math.pow((p1.x - p2.x), 2)) + (Math.pow((p1.y - p2.y), 2)));
	}

	static int find(int cur) {
		if (cur != parent[cur]) {
			parent[cur] = find(parent[cur]);
		}
		return parent[cur];
	}

	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y) {
			return false;
		}
		parent[y] = x;
		return true;
	}

	static class Edge implements Comparable<Edge> {
		int s, e;
		double v;

		public Edge(int s, int e, double v) {
			this.s = s;
			this.e = e;
			this.v = v;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(v, o.v);
		}

	}

	static class Point {
		int x, y;

	}
}
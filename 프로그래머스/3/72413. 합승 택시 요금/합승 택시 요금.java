import java.util.*;

class Solution {
	static ArrayList<Node>[] graph;

	static class Node implements Comparable<Node> {
		int p, w;

		public Node(int p, int w) {
			this.p = p;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(w, o.w);
		}
	}

	public int solution(int n, int s, int a, int b, int[][] fares) {
		graph = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int[] row : fares) {
			graph[row[0]].add(new Node(row[1], row[2]));
			graph[row[1]].add(new Node(row[0], row[2]));
		}
		int dist1[] = calcDist(s, fares, n);
		int ans = dist1[a] + dist1[b];
		for (int j = 1; j <= n; j++) {
			if (j == s)
				continue;
			if (j == a || j == b) {
				int dist2[] = calcDist(j, fares, n);
				ans = Math.min(ans, dist1[j] + dist2[j == b ? a : b]);
			} else {
				int dist2[] = calcDist(j, fares, n);
				ans = Math.min(ans, dist1[j] + dist2[a] + dist2[b]);
			}
		}
		return ans;
	}

	static int[] calcDist(int start, int[][] fares, int n) {
		int dist[] = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, dist[start]));
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (cur.w != dist[cur.p])
				continue;
			for (Node nxt : graph[cur.p]) {
				if (dist[nxt.p] > cur.w + nxt.w) {
					dist[nxt.p] = cur.w + nxt.w;
					pq.offer(new Node(nxt.p, dist[nxt.p]));
				}
			}
		}
		return dist;
	}
}
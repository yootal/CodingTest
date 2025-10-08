import java.util.*;

class Solution {
	static ArrayList<int[]>[] graph;
	public int solution(int n, int s, int a, int b, int[][] fares) {
		graph = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int[] row : fares) {
			graph[row[0]].add(new int[]{row[1],row[2]});
			graph[row[1]].add(new int[]{row[0],row[2]});
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
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i->i[1]));
		pq.offer(new int[]{start, dist[start]});
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			if (cur[1] != dist[cur[0]])
				continue;
			for (int[] nxt : graph[cur[0]]) {
				if (dist[nxt[0]] > cur[1] + nxt[1]) {
					dist[nxt[0]] = cur[1] + nxt[1];
					pq.offer(new int[]{nxt[0],dist[nxt[0]]});
				}
			}
		}
		return dist;
	}
}
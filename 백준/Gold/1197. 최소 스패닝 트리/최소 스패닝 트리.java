import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<Node>[] graph = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[a].add(new Node(b, v));
			graph[b].add(new Node(a, v));
		}
		boolean[] vis = new boolean[n + 1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(1, 0));
		int ans = 0;
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (vis[cur.nxt])
				continue;
			vis[cur.nxt] = true;
			ans += cur.value;
			for (Node nxt : graph[cur.nxt]) {
				if (!vis[nxt.nxt])
					pq.offer(nxt);
			}
		}
		System.out.println(ans);
	}

	static class Node implements Comparable<Node> {
		int nxt, value;

		public Node(int nxt, int value) {
			this.nxt = nxt;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			return value - o.value;
		}
	}
}
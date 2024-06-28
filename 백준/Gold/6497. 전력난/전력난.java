import java.util.*;
import java.io.*;

class Main {
	static class Link implements Comparable<Link> {
		int nxt, w;

		public Link(int nxt, int w) {
			this.nxt = nxt;
			this.w = w;
		}

		public int compareTo(Link o) {
			return Integer.compare(this.w, o.w);
		}
	}

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while (true) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			if (m == 0 && n == 0)
				break;
			ArrayList<Link> graph[] = new ArrayList[m];
			for (int i = 0; i < m; i++) {
				graph[i] = new ArrayList<>();
			}
			int total = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				total += z;
				graph[x].add(new Link(y, z));
				graph[y].add(new Link(x, z));
			}
			boolean vis[] = new boolean[m];
			PriorityQueue<Link> pq = new PriorityQueue<>();
			pq.offer(new Link(0, 0));
			int sum = 0;
			int cnt = 0;
			while (cnt < m) {
				Link cur = pq.poll();
				if (vis[cur.nxt])
					continue;
				vis[cur.nxt] = true;
				sum += cur.w;
				cnt++;
				for (Link nxt : graph[cur.nxt]) {
					if (!vis[nxt.nxt]) {
						pq.offer(nxt);
					}
				}
			}
			sb.append(total - sum).append("\n");
		}
		System.out.print(sb);
	}
}
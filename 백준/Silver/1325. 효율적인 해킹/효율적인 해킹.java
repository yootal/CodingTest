import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int max;
	static ArrayList<Integer>[] graph;
	static int[] dist;
	static boolean[] vis;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new ArrayList[n + 1];
		dist = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
		}
		for (int i = 1; i <= n; i++) {
			vis = new boolean[n + 1];
			bfs(i);
		}
		for (int i = 1; i <= n; i++) {
			if (max < dist[i])
				max = dist[i];
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			if (dist[i] == max)
				sb.append(i + " ");
		}
		System.out.println(sb.toString());
	}

	static void bfs(int x) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.add(x);
		vis[x] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int nxt : graph[cur]) {
				if (vis[nxt])
					continue;
				dist[nxt]++;
				vis[nxt] = true;
				q.add(nxt);
			}
		}
	}
}
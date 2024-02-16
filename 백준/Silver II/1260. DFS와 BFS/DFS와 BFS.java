import java.io.*;
import java.util.*;

public class Main {
	static int N, M, V;
	static ArrayList<Integer>[] graph;
	static boolean[] vis;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		for (int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
		}
		vis = new boolean[N + 1];
		dfs(V);
		sb.append("\n");
		vis = new boolean[N + 1];
		bfs();
		System.out.print(sb);
	}

	static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		vis[V] = true;
		q.offer(V);
		while (!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur + " ");
			for (int nxt : graph[cur]) {
				if (!vis[nxt]) {
					vis[nxt] = true;
					q.offer(nxt);
				}
			}
		}
	}

	static void dfs(int cur) {
		vis[cur] = true;
		sb.append(cur + " ");
		for (int nxt : graph[cur]) {
			if (!vis[nxt])
				dfs(nxt);
		}
	}
}
import java.io.*;
import java.util.*;

public class Main {
	static int V;
	static int E;
	static ArrayList<Integer>[] graph;
	static int[] vis;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			graph = new ArrayList[V + 1];
			vis = new int[V + 1];
			for (int j = 0; j <= V; j++) {
				graph[j] = new ArrayList<>();
			}
			for (int j = 0; j < E; j++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				graph[u].add(v);
				graph[v].add(u);
			}
			if (solve()) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
		}
		System.out.print(sb);

	}

	static boolean solve() {
		int flag = 1;
		for (int cur = 1; cur <= V; cur++) {
			if (vis[cur] == 0) {
				if (!bfs(cur, flag)) {
					return false;
				}
				flag *= -1;
			}
		}
		return true;

	}

	static boolean bfs(int x, int flag) {
		vis[x] = flag;
		Queue<Integer> q = new ArrayDeque<>();
		q.add(x);
		while (!q.isEmpty()) {
			int pre = q.poll();
			for (int nxt : graph[pre]) {
				if (vis[nxt] == 0) {
					vis[nxt] = -vis[pre];
					q.add(nxt);
				} else if (vis[nxt] == vis[pre]) {
					return false;
				}
			}
		}
		return true;
	}

}
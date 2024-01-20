import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static ArrayList<int[]>[] graph;
	static boolean[] vis;
	static int[] dist;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<int[]>();
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int cur = Integer.parseInt(st.nextToken());
			while (st.hasMoreTokens()) {
				int nxt = Integer.parseInt(st.nextToken());
				if (nxt == -1)
					break;
				int len = Integer.parseInt(st.nextToken());
				graph[cur].add(new int[] { nxt, len });
			}
		}
		vis = new boolean[N + 1];
		dist = new int[N + 1];
		bfs(1);
		int max = 1;
		for (int i = 2; i <= N; i++) {
			if (dist[max] < dist[i])
				max = i;
		}
		vis = new boolean[N + 1];
		dist = new int[N + 1];
		bfs(max);
		Arrays.sort(dist);
		System.out.println(dist[N]);
	}

	static void bfs(int x) {
		vis[x] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(x);
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int[] nxt : graph[cur]) {
				if (!vis[nxt[0]]) {
					vis[nxt[0]] = true;
					q.offer(nxt[0]);
					dist[nxt[0]] = dist[cur] + nxt[1];
				}
			}
		}
	}
}
import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] tree;
	static int depth[], parent[];
	static boolean vis[];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		tree = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			tree[i] = new ArrayList<>();
		}
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			tree[s].add(e);
			tree[e].add(s);
		}
		depth = new int[n + 1];
		parent = new int[n + 1];
		vis = new boolean[n + 1];
		bfs();
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(lca(a, b));
		}
	}

	static int lca(int a, int b) {
		if (depth[a] < depth[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		while (depth[a] != depth[b]) {
			a = parent[a];
		}
		while (a != b) {
			a = parent[a];
			b = parent[b];
		}
		return a;
	}

	static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(1);
		vis[1] = true;
		int level = 1;
		int size = 1;
		int count = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int nxt : tree[cur]) {
				if (!vis[nxt]) {
					vis[nxt] = true;
					q.add(nxt);
					parent[nxt] = cur;
					depth[nxt] = level;
				}
			}
			count++;
			if (count == size) {
				count = 0;
				size = q.size();
				level++;
			}
		}
	}
}
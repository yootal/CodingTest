import java.io.*;
import java.util.*;

class Main {
	static ArrayList<Integer>[] graph;
	static long tree[], lazy[];
	static int S[], E[], cnt, arr[];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		S = new int[N + 1];
		E = new int[N + 1];
		graph = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int cur = Integer.parseInt(st.nextToken());
			if (cur == -1)
				continue;
			graph[cur].add(i);
		}
		ArrayDeque<Integer> q = new ArrayDeque<Integer>();
		int H = (int) Math.ceil(Math.log(N) / Math.log(2));
		int treeSize = 1 << (H + 1);
		tree = new long[treeSize];
		lazy = new long[treeSize];
		dfs(1, 0);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			if (cmd == 1) {
				int j = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				update_range(1, 1, N, S[j], S[j], w);
			} else if (cmd == 2) {
				int j = Integer.parseInt(st.nextToken());
				sb.append(query(1, 1, N, S[j], E[j])).append("\n");
			}
		}
		System.out.print(sb);
	}

	static void dfs(int x, int p) {
		S[x] = ++cnt;
		for (int nxt : graph[x]) {
			dfs(nxt, x);
		}
		E[x] = cnt;
	}

	static void update_lazy(int node, int s, int e) {
		if (lazy[node] != 0) {
			tree[node] += (e - s + 1) * lazy[node];
			if (s != e) {
				lazy[node * 2] += lazy[node];
				lazy[node * 2 + 1] += lazy[node];
			}
			lazy[node] = 0;
		}
	}

	static void update_range(int node, int s, int e, int l, int r, int diff) {
		update_lazy(node, s, e);
		if (l > e || r < s)
			return;
		if (l <= s && r >= e) {
			lazy[node] += diff;
			update_lazy(node, s, e);
			return;
		}
		update_range(node * 2, s, (s + e) / 2, l, r, diff);
		update_range(node * 2 + 1, (s + e) / 2 + 1, e, l, r, diff);
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}

	static long query(int node, int s, int e, int l, int r) {
		update_lazy(node, s, e);
		if (l > e || r < s) {
			return 0;
		}
		if (l <= s && r >= e) {
			return tree[node];
		}
		long lsum = query(node * 2, s, (s + e) / 2, l, r);
		long rsum = query(node * 2 + 1, (s + e) / 2 + 1, e, l, r);
		return lsum + rsum;
	}
}
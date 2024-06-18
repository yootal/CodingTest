import java.io.*;
import java.util.*;

class Main {
	static ArrayList<Integer>[] graph;
	static int S[], E[], cnt;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		S = new int[N + 1];
		E = new int[N + 1];
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph[A].add(B);
			graph[B].add(A);
		}
		int H = (int) Math.ceil(Math.log(N) / Math.log(2));
		int treeSize = 1 << (H + 1);
		long tree[] = new long[treeSize];
		long lazy[] = new long[treeSize];
		dfs(1, 0);
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int D = Integer.parseInt(st.nextToken());
			update_range(tree, lazy, 1, 1, N, S[i], S[i], D);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			if (cmd == 1) {
				int x = Integer.parseInt(st.nextToken());
				sb.append(query(tree, lazy, 1, 1, N, S[x], E[x])).append("\n");
			} else {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				update_range(tree, lazy, 1, 1, N, S[x], E[x], y);
			}
		}
		System.out.print(sb);
	}

	static void dfs(int x, int p) {
		S[x] = ++cnt;
		for (int nxt : graph[x]) {
			if (nxt == p)
				continue;
			dfs(nxt, x);
		}
		E[x] = cnt;
	}

	static void update_lazy(long[] tree, long[] lazy, int node, int s, int e) {
		if (lazy[node] != 0) {
			tree[node] ^= lazy[node] * ((e - s + 1) % 2);
			if (s != e) {
				lazy[node * 2] ^= lazy[node];
				lazy[node * 2 + 1] ^= lazy[node];
			}
			lazy[node] = 0;
		}
	}

	static void update_range(long[] tree, long[] lazy, int node, int s, int e, int l, int r, long d) {
		update_lazy(tree, lazy, node, s, e);
		if (l > e || r < s)
			return;
		if (l <= s && r >= e) {
			tree[node] ^= d * ((e - s + 1) % 2);
			if (s != e) {
				lazy[node * 2] ^= d;
				lazy[node * 2 + 1] ^= d;
			}
			return;
		}
		update_range(tree, lazy, node * 2, s, (s + e) / 2, l, r, d);
		update_range(tree, lazy, node * 2 + 1, (s + e) / 2 + 1, e, l, r, d);
		tree[node] = tree[node * 2] ^ tree[node * 2 + 1];
	}

	static long query(long[] tree, long[] lazy, int node, int s, int e, int l, int r) {
		update_lazy(tree, lazy, node, s, e);
		if (l > e || r < s) {
			return 0;
		}
		if (l <= s && r >= e) {
			return tree[node];
		}
		long left = query(tree, lazy, node * 2, s, (s + e) / 2, l, r);
		long right = query(tree, lazy, node * 2 + 1, (s + e) / 2 + 1, e, l, r);
		return left ^ right;
	}
}
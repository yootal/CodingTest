import java.io.*;
import java.util.*;

class Main {
	static ArrayList<Integer>[] graph;
	static int S[], E[], cnt;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		S = new int[N + 1];
		E = new int[N + 1];
		graph = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int cur = Integer.parseInt(st.nextToken());
			if (cur == 0)
				continue;
			graph[cur].add(i);
		}
		int H = (int) Math.ceil(Math.log(N) / Math.log(2));
		int treeSize = 1 << (H + 1);
		long tree[] = new long[treeSize];
		long lazy[] = new long[treeSize];
		dfs(1, 0);
		// on 상태로 초기화
		for (int i = 1; i <= N; i++) {
			update_range(tree, lazy, 1, 1, N, S[i], S[i], true);
		}
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			if (cmd == 1) { // on
				int j = Integer.parseInt(st.nextToken());
				for (int nxt : graph[j]) {
					update_range(tree, lazy, 1, 1, N, S[nxt], E[nxt], true);
				}
			} else if (cmd == 2) { // off
				int j = Integer.parseInt(st.nextToken());
				for (int nxt : graph[j]) {
					update_range(tree, lazy, 1, 1, N, S[nxt], E[nxt], false);
				}
			} else { // query
				int j = Integer.parseInt(st.nextToken());
				long sum = 0;
				for (int nxt : graph[j]) {
					sum += query(tree, lazy, 1, 1, N, S[nxt], E[nxt]);
				}
				sb.append(sum).append("\n");
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

	static void update_lazy(long[] tree, long[] lazy, int node, int s, int e) {
		if (lazy[node] == 1) {
			tree[node] = (e - s + 1);
			if (s != e) {
				lazy[node * 2] = 1;
				lazy[node * 2 + 1] = 1;
			}
			lazy[node] = 0;
		} else if (lazy[node] == 2) {
			tree[node] = 0;
			if (s != e) {
				lazy[node * 2] = 2;
				lazy[node * 2 + 1] = 2;
			}
			lazy[node] = 0;
		}
	}

	static void update_range(long[] tree, long[] lazy, int node, int s, int e, int l, int r, boolean flag) {
		update_lazy(tree, lazy, node, s, e);
		if (l > e || r < s)
			return;
		if (l <= s && r >= e) {
			if (flag) {
				lazy[node] = 1;
			} else
				lazy[node] = 2;
			update_lazy(tree, lazy, node, s, e);
			return;
		}
		update_range(tree, lazy, node * 2, s, (s + e) / 2, l, r, flag);
		update_range(tree, lazy, node * 2 + 1, (s + e) / 2 + 1, e, l, r, flag);
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}

	static long query(long[] tree, long[] lazy, int node, int s, int e, int l, int r) {
		update_lazy(tree, lazy, node, s, e);
		if (l > e || r < s) {
			return 0;
		}
		if (l <= s && r >= e) {
			return tree[node];
		}
		long lsum = query(tree, lazy, node * 2, s, (s + e) / 2, l, r);
		long rsum = query(tree, lazy, node * 2 + 1, (s + e) / 2 + 1, e, l, r);
		return lsum + rsum;
	}
}
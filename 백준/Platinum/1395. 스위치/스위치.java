import java.io.*;
import java.util.*;

class Main {
	static long tree[], lazy[];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = (int) Math.ceil(Math.log(N) / Math.log(2));
		int treeSize = 1 << (H + 1);
		tree = new long[treeSize];
		lazy = new long[treeSize];
		int M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int O = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			if (O == 0) {
				update_range(1, 1, N, S, T);
			} else {
				sb.append(query(1, 1, N, S, T)).append("\n");
			}
		}
		System.out.println(sb);
	}

	static void update_lazy(int node, int s, int e) {
		if (lazy[node] % 2 == 1) { // 짝수면 그대로
			tree[node] = (e - s + 1) - tree[node]; // 구간 반전
			if (s != e) {
				lazy[node * 2] += lazy[node];
				lazy[node * 2 + 1] += lazy[node];
			}
			lazy[node] = 0;
		}
	}

	static void update_range(int node, int s, int e, int l, int r) {
		update_lazy(node, s, e);
		if (l > e || r < s) {
			return;
		}
		if (l <= s && e <= r) {
			lazy[node] = 1;
			update_lazy(node, s, e);
			return;
		}
		update_range(node * 2, s, (s + e) / 2, l, r);
		update_range(node * 2 + 1, (s + e) / 2 + 1, e, l, r);
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}

	static long query(int node, int s, int e, int l, int r) {
		update_lazy(node, s, e);
		if (l > e || r < s) {
			return 0;
		}
		if (l <= s && e <= r) {
			return tree[node];
		}
		long lsum = query(node * 2, s, (s + e) / 2, l, r);
		long rsum = query(node * 2 + 1, (s + e) / 2 + 1, e, l, r);
		return lsum + rsum;
	}
}
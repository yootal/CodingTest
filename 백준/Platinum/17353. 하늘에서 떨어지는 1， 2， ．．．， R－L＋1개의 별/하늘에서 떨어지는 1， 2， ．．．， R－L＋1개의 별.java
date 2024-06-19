import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int H = (int) Math.ceil(Math.log(N) / Math.log(2));
		int treeSize = 1 << (H + 1);
		long tree[] = new long[treeSize];
		long lazy[] = new long[treeSize];
		for (int i = 1; i <= N; i++) {
			update_range(tree, lazy, 1, 1, N, i, i, arr[i] - arr[i - 1]);
		}
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			if (cmd == 1) {
				int l = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				update_range(tree, lazy, 1, 1, N, l, r, 1);
				update_range(tree, lazy, 1, 1, N, r + 1, r + 1, -(r - l + 1));
			} else {
				int x = Integer.parseInt(st.nextToken());
				sb.append(query(tree, lazy, 1, 1, N, 1, x)).append("\n");
			}
		}
		System.out.print(sb);
	}

	static void update_lazy(long[] tree, long[] lazy, int node, int s, int e) {
		if (lazy[node] != 0) {
			tree[node] += (e - s + 1) * lazy[node];
			if (s != e) {
				lazy[node * 2] += lazy[node];
				lazy[node * 2 + 1] += lazy[node];
			}
			lazy[node] = 0;
		}
	}

	static void update_range(long[] tree, long[] lazy, int node, int s, int e, int l, int r, int diff) {
		update_lazy(tree, lazy, node, s, e);
		if (l > e || r < s)
			return;
		if (l <= s && r >= e) {
			tree[node] += (e - s + 1) * diff;
			if (s != e) {
				lazy[node * 2] += diff;
				lazy[node * 2 + 1] += diff;
			}
			return;
		}
		update_range(tree, lazy, node * 2, s, (s + e) / 2, l, r, diff);
		update_range(tree, lazy, node * 2 + 1, (s + e) / 2 + 1, e, l, r, diff);
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
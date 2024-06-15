import java.io.*;
import java.util.*;

class Main {
	static long arr[], tree[], lazy[];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int H = (int) Math.ceil(Math.log(N) / Math.log(2));
		int treeSize = 1 << (H + 1);
		tree = new long[treeSize];
		lazy = new long[treeSize];
		init(1, 0, N - 1);
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			if (t == 1) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				update_range(1, 0, N - 1, a, b, c);
			} else {
				int a = Integer.parseInt(st.nextToken());
				sb.append(query(1, 0, N - 1, a, a)).append("\n");
			}
		}
		System.out.println(sb);
	}

	static void init(int node, int s, int e) {
		if (s == e) {
			tree[node] = arr[s];
		} else {
			init(node * 2, s, (s + e) / 2);
			init(node * 2 + 1, (s + e) / 2 + 1, e);
			tree[node] = tree[node * 2] ^ tree[node * 2 + 1];
		}
	}

	static void update_lazy(int node, int s, int e) {
		if (lazy[node] != 0) {
			if ((e - s + 1) % 2 == 1)
				tree[node] ^= lazy[node];
			if (s != e) {
				lazy[node * 2] ^= lazy[node];
				lazy[node * 2 + 1] ^= lazy[node];
			}
			lazy[node] = 0;
		}
	}

	static void update_range(int node, int s, int e, int l, int r, long diff) {
		update_lazy(node, s, e);
		if (l > e || r < s) {
			return;
		}
		if (l <= s && e <= r) {
			if ((e - s + 1) % 2 == 1)
				tree[node] ^= diff;
			if (s != e) {
				lazy[node * 2] ^= diff;
				lazy[node * 2 + 1] ^= diff;
			}
			return;
		}
		update_range(node * 2, s, (s + e) / 2, l, r, diff);
		update_range(node * 2 + 1, (s + e) / 2 + 1, e, l, r, diff);
		tree[node] = tree[node * 2] ^ tree[node * 2 + 1];
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
		return lsum ^ rsum;
	}
}
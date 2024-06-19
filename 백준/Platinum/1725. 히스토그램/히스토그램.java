import java.io.*;

class Main {
	static long tree[];
	static int N, arr[], idx[];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int H = (int) Math.ceil(Math.log(N) / Math.log(2));
		int treeSize = 1 << (H + 1);
		tree = new long[treeSize];
		idx = new int[treeSize];
		init(1, 1, N);
		System.out.println(getAns(1, N));
	}

	static void init(int node, int s, int e) {
		if (s == e) {
			tree[node] = arr[s];
			idx[node] = s;
		} else {
			init(node * 2, s, (s + e) / 2);
			init(node * 2 + 1, (s + e) / 2 + 1, e);
			if (tree[node * 2] == tree[node * 2 + 1]) {
				tree[node] = tree[node * 2];
				idx[node] = arr[idx[node * 2]] <= arr[idx[node * 2 + 1]] ? idx[node * 2] : idx[node * 2 + 1];
			} else if (tree[node * 2] < tree[node * 2 + 1]) {
				tree[node] = tree[node * 2];
				idx[node] = idx[node * 2];
			} else {
				tree[node] = tree[node * 2 + 1];
				idx[node] = idx[node * 2 + 1];
			}
		}
	}

	static int getIdx(int node, int s, int e, int l, int r) {
		if (l > e || r < s) {
			return -1;
		}
		if (l <= s && r >= e) {
			return idx[node];
		}
		int lmin = getIdx(node * 2, s, (s + e) / 2, l, r);
		int rmin = getIdx(node * 2 + 1, (s + e) / 2 + 1, e, l, r);
		if (lmin == -1)
			return rmin;
		else if (rmin == -1)
			return lmin;
		return arr[lmin] <= arr[rmin] ? lmin : rmin;
	}

	static long getAns(int l, int r) {
		if (l == r)
			return arr[l];
		else {
			int minIdx = getIdx(1, 1, N, l, r);
			long value = arr[minIdx] * (r - l + 1);
			if (l <= minIdx - 1) {
				long temp = getAns(l, minIdx - 1);
				value = Math.max(value, temp);
			}
			if (r >= minIdx + 1) {
				long temp = getAns(minIdx + 1, r);
				value = Math.max(value, temp);
			}
			return value;
		}
	}
}
import java.io.*;
import java.util.*;

class Main {
	static int N, arr[], idxTree[];
	static long sumTree[];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int H = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
		sumTree = new long[1 << H];
		idxTree = new int[1 << H];
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		init(1, 0, N - 1);
		System.out.println(getAns(0, N - 1));
	}

	static void init(int node, int s, int e) {
		if (s == e) {
			sumTree[node] = arr[s];
			idxTree[node] = s;
		} else {
			init(node * 2, s, (s + e) / 2);
			init(node * 2 + 1, (s + e) / 2 + 1, e);
			sumTree[node] = sumTree[node * 2] + sumTree[node * 2 + 1];
			idxTree[node] = (arr[idxTree[node * 2]] <= arr[idxTree[node * 2 + 1]]) ? idxTree[node * 2]
					: idxTree[node * 2 + 1];
		}
	}

	static long getSum(int node, int s, int e, int l, int r) {
		if (l > e || r < s) {
			return 0;
		}
		if (l <= s && e <= r) {
			return sumTree[node];
		}
		long lsum = getSum(node * 2, s, (s + e) / 2, l, r);
		long rsum = getSum(node * 2 + 1, (s + e) / 2 + 1, e, l, r);
		return lsum + rsum;
	}

	static int getMinIdx(int node, int s, int e, int l, int r) {
		if (l > e || r < s) {
			return -1;
		}
		if (l <= s && e <= r) {
			return idxTree[node];
		}
		int lmin = getMinIdx(node * 2, s, (s + e) / 2, l, r);
		int rmin = getMinIdx(node * 2 + 1, (s + e) / 2 + 1, e, l, r);
		if (lmin == -1)
			return rmin;
		else if (rmin == -1)
			return lmin;
		return arr[lmin] <= arr[rmin] ? lmin : rmin;
	}

	static long getAns(int l, int r) {
		if (l == r) {
			return (long)arr[l] * arr[l];
		} else {
			int minIdx = getMinIdx(1, 0, N - 1, l, r);
			long sum = getSum(1, 0, N - 1, l, r);
			long value = sum * arr[minIdx];
			if (l <= minIdx - 1) {
				long temp = getAns(l, minIdx - 1);
				if (value < temp)
					value = temp;
			}
			if (r >= minIdx + 1) {
				long temp = getAns(minIdx + 1, r);
				if (value < temp)
					value = temp;
			}
			return value;
		}
	}
}
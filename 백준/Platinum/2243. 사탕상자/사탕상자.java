import java.io.*;
import java.util.*;

class Main {
	static final int n = 1000000;
	static int treeSize, tree[], startIdx;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int h = (int) Math.ceil(Math.log(n) / Math.log(2)) + 1;
		treeSize = 1 << h;
		tree = new int[treeSize];
		startIdx = treeSize / 2 - 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if (a == 1) {
				long b = Long.parseLong(st.nextToken());
				sb.append(binarySearch(b)).append("\n");
			} else {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				change(startIdx + b, c);
			}
		}
		System.out.println(sb);
	}

	static void change(int idx, int diff) {
		while (idx > 0) {
			tree[idx] += diff;
			idx /= 2;
		}
	}

	static long calcSum(int s, int e) {
		long total = 0;
		while (s <= e) {
			if (s % 2 == 1) {
				total += tree[s];
				s++;
			}
			if (e % 2 == 0) {
				total += tree[e];
				e--;
			}
			s /= 2;
			e /= 2;
		}
		return total;
	}

	static int binarySearch(long target) {
		int start = 1;
		int end = n;
		while (start < end) {
			int mid = (start + end) / 2;
			if (target <= calcSum(startIdx + 1, startIdx + mid)) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		change(startIdx + start, -1);
		return start;
	}
}
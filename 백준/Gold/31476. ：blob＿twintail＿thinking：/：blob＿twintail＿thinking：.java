import java.util.*;
import java.io.*;

class Main {
	static int D, N, U, T, a1, a2, cnt, tempCnt, record[];
	static boolean vis[];
	static HashSet<Integer> set;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		D = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			set.add(makeKey(a, b));
		}
		count(1, 1);
		vis = new boolean[1 << D];
		one(1, 1);
		record = new int[D];
		two(1, 1, 0);
		for (int v : record) {
			a2 += v;
		}
		if (a1 == a2) {
			System.out.println(":blob_twintail_thinking:");
		} else if (a1 > a2) {
			System.out.println(":blob_twintail_aww:");
		} else {
			System.out.println(":blob_twintail_sad:");
		}
	}

	static void count(int depth, int node) {
		cnt++;
		if (depth == D)
			return;
		if (!set.contains(makeKey(node, node * 2))) {
			count(depth + 1, node * 2);
		}
		if (!set.contains(makeKey(node, node * 2 + 1))) {
			count(depth + 1, node * 2 + 1);
		}
	}

	static void one(int depth, int node) {
		if (!vis[node]) {
			vis[node] = true;
			tempCnt++;
			if (tempCnt == cnt)
				return;
		}
		if (depth == D)
			return;
		if (!set.contains(makeKey(node, node * 2))) {
			a1 += U;
			one(depth + 1, node * 2);
			if (tempCnt == cnt)
				return;
			a1 += U;
		}
		if (!set.contains(makeKey(node, node * 2 + 1))) {
			a1 += U;
			one(depth + 1, node * 2 + 1);
			if (tempCnt == cnt)
				return;
			a1 += U;
		}
	}

	static void two(int depth, int node, int t) {
		if (depth == D)
			return;
		if (!set.contains(makeKey(node, node * 2)) && !set.contains(makeKey(node, node * 2 + 1))) {
			record[depth] = Math.max(record[depth], U + (t + 1) * T);
			two(depth + 1, node * 2, t + 1);
			two(depth + 1, node * 2 + 1, t + 1);
		} else if (!set.contains(makeKey(node, node * 2)) && set.contains(makeKey(node, node * 2 + 1))) {
			record[depth] = Math.max(record[depth], U + t * T);
			two(depth + 1, node * 2, t);
		} else if (set.contains(makeKey(node, node * 2)) && !set.contains(makeKey(node, node * 2 + 1))) {
			record[depth] = Math.max(record[depth], U + t * T);
			two(depth + 1, node * 2 + 1, t);
		}
	}

	static int makeKey(int a, int b) {
		return a * 100000 + b;
	}
}
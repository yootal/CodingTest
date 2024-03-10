import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static long tree[];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		int treeSize = 1 << (h + 1);
		int startIdx = treeSize / 2 - 1;
		tree = new long[treeSize + 1];
		Arrays.fill(tree, Integer.MAX_VALUE);
		for (int i = startIdx + 1; i <= startIdx + N; i++) {
			tree[i] = Long.parseLong(br.readLine());
		}
		init(treeSize);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(findMin(a + startIdx, b + startIdx)).append("\n");
		}
		System.out.print(sb);
	}

	static void init(int i) {
		while (i != 1) {
			if (tree[i / 2] > tree[i])
				tree[i / 2] = tree[i];
			i--;
		}
	}

	static long findMin(int s, int e) {
		long minValue = Integer.MAX_VALUE;
		while (s <= e) {
			if (s % 2 == 1) {
				minValue = Math.min(minValue, tree[s]);
				s++;
			}
			if (e % 2 == 0) {
				minValue = Math.min(minValue, tree[e]);
				e--;
			}
			s = s / 2;
			e = e / 2;
		}
		return minValue;
	}

}
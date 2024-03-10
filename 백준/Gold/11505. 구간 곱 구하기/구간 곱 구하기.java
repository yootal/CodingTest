import java.io.*;
import java.util.*;

public class Main {
	static int mod = (int) (1e9 + 7);
	static long tree[];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		int treeSize = 1 << (h + 1);
		int startIdx = treeSize / 2 - 1;
		tree = new long[treeSize + 1];
		Arrays.fill(tree, 1);
		for (int i = startIdx + 1; i <= startIdx + N; i++) {
			tree[i] = Long.parseLong(br.readLine());
		}
		init(treeSize);
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == 1) {
				change(b + startIdx, c);
			} else {
				sb.append(calc(b + startIdx, c + startIdx)).append("\n");
			}
		}
		System.out.print(sb);
	}

	static void init(int i) {
		while (i != 1) {
			tree[i / 2] = tree[i / 2] * tree[i] % mod;
			i--;
		}
	}

	static void change(int idx, int val) {
		tree[idx] = val;
		while (idx > 1) {
			idx /= 2;
			tree[idx] = tree[idx * 2] % mod * tree[idx * 2 + 1] % mod;
		}
	}

	static long calc(int s, int e) {
		long value = 1;
		while (s <= e) {
			if (s % 2 == 1) {
				value = value * tree[s] % mod;
				s++;
			}
			if (e % 2 == 0) {
				value = value * tree[e] % mod;
				e--;
			}
			s = s / 2;
			e = e / 2;
		}
		return value % mod;
	}

}
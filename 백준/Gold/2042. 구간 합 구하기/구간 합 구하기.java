import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K;
	static long tree[];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		int treeSize = 1 << (h + 1);
		int startIdx = treeSize / 2 - 1;
		tree = new long[treeSize + 1];
		for (int i = startIdx + 1; i <= startIdx + N; i++) {
			tree[i] = Long.parseLong(br.readLine());
		}
		init(treeSize);
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if (a == 1) {
				change(startIdx + b, c);
			} else {
				b += startIdx;
				c += startIdx;
				sb.append(calcSum(b, (int) c)).append("\n");
			}
		}
		System.out.print(sb);
	}

	static void init(int i) {
		while (i != 1) {
			tree[i / 2] += tree[i];
			i--;
		}
	}

	static void change(int idx, long v) {
		long diff = v - tree[idx];
		while (idx > 0) {
			tree[idx] = tree[idx] + diff;
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
			s = s / 2;
			e = e / 2;
		}
		return total;
	}

}
import java.io.*;
import java.util.*;

class Main {
	static int segTree[];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int h = (int) Math.ceil(Math.log(N + M) / Math.log(2)) + 1;
			int idxM = M - 1;
			int treeSize = 1 << h;
			int startIdx = treeSize / 2;
			segTree = new int[treeSize];
			for (int i = 1; i <= N; i++) {
				change(startIdx + idxM + i, 1);
			}
			int index[] = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				index[i] = idxM + i;
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				int out = Integer.parseInt(st.nextToken());
				sb.append(calcSum(startIdx, startIdx + index[out] - 1));
				change(startIdx + index[out], -1);
				index[out] = idxM;
				change(startIdx + idxM--, 1);
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void change(int idx, int diff) {
		while (idx > 0) {
			segTree[idx] += diff;
			idx /= 2;
		}
	}

	static long calcSum(int s, int e) {
		long total = 0;
		while (s <= e) {
			if (s % 2 == 1) {
				total += segTree[s];
				s++;
			}
			if (e % 2 == 0) {
				total += segTree[e];
				e--;
			}
			s /= 2;
			e /= 2;
		}
		return total;
	}
}
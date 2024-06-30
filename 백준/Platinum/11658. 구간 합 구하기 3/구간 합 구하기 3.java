import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long arr[][] = new long[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Long.parseLong(st.nextToken());
			}
		}
		long tree2D[][] = new long[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				update(tree2D[i], j, arr[i][j]);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			if (w == 0) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				long c = Long.parseLong(st.nextToken());
				update(tree2D[x], y, c - arr[x][y]);
				arr[x][y] = c;
			} else {
				int x1 = Integer.parseInt(st.nextToken());
				int y1 = Integer.parseInt(st.nextToken());
				int x2 = Integer.parseInt(st.nextToken());
				int y2 = Integer.parseInt(st.nextToken());
				long sum = 0;
				for (int r = x1; r <= x2; r++) {
					sum += sum(tree2D[r], y2) - sum(tree2D[r], y1 - 1);
				}
				sb.append(sum + "\n");
			}
		}
		System.out.print(sb);
	}

	static void update(long[] tree, int idx, long val) {
		while (idx < tree.length) {
			tree[idx] += val;
			idx += (idx & -idx);
		}
	}

	static long sum(long[] tree, int idx) {
		long total = 0;
		while (idx > 0) {
			total += tree[idx];
			idx &= (idx - 1);
		}
		return total;
	}
}
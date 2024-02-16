import java.io.*;
import java.util.*;

public class Solution {
	static int N, X, ans;
	static int[] start, end, seq;
	static int[][] guest;
	static boolean[] vis;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			seq = new int[N];
			guest = new int[N][2];
			vis = new boolean[N];
			st = new StringTokenizer(br.readLine());
			start = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
			end = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
			for (int i = 0; i < N; i++) {
				guest[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
			}
			ans = Integer.MAX_VALUE;
			perm(0);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

	static int calc_dist(int[] p1, int[] p2) {
		return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
	}

	static void perm(int cnt) {
		if (cnt == N) {
			int dist = calc_dist(start, guest[seq[0]]) + calc_dist(end, guest[seq[N - 1]]);
			for (int i = 1; i < N; i++) {
				dist += calc_dist(guest[seq[i - 1]], guest[seq[i]]);
				if (dist > ans)
					return;
			}
			ans = Math.min(ans, dist);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (vis[i])
				continue;
			vis[i] = true;
			seq[cnt] = i;
			perm(cnt + 1);
			vis[i] = false;
		}
	}
}
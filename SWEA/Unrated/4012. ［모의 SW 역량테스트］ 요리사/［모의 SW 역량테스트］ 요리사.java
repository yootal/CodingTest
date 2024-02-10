import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int ans;
	static int[][] synergy;
	static boolean[] vis;

	public static void main(String args[]) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			synergy = new int[N][N];
			vis = new boolean[N];
			ans = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			calc(0, 0);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

	static void calc(int depth, int idx) {
		if (depth == N / 2) {
			int sum1 = 0, sum2 = 0;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					if (vis[i] && vis[j])
						sum1 += synergy[i][j] + synergy[j][i];
					else if (!vis[i] && !vis[j])
						sum2 += synergy[i][j] + synergy[j][i];
				}
			}
			ans = Math.min(ans, Math.abs(sum1 - sum2));
			return;
		}

		for (int i = idx; i < N; i++) {
			if (!vis[i]) {
				vis[i] = true;
				calc(depth + 1, i + 1);
				vis[i] = false;
			}
		}
	}
}
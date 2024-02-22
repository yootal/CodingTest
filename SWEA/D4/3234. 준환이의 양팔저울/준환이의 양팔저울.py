import java.io.*;
import java.util.*;

public class Solution {
	static int N, sum, ans;
	static int[] num;
	static boolean[] v;
	static int dp[];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		dp = new int[10];
		dp[1] = 1;
		factorial(9);
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			num = new int[N];
			v = new boolean[N];
			sum = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
				sum += num[i];
			}
			ans = 0;
			solve(0, 0, 0);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

	static void solve(int left, int right, int cnt) {
		if (cnt == N) {
			ans++;
			return;
		}
		if (left > sum / 2) {
			ans += Math.pow(2, N - cnt) * dp[N - cnt];
			return;
		}
		for (int i = 0; i < N; i++) {
			if (v[i])
				continue;
			v[i] = true;
			solve(left + num[i], right, cnt + 1);
			if (left >= right + num[i]) {
				solve(left, right + num[i], cnt + 1);
			}
			v[i] = false;
		}
	}

	static int factorial(int x) {
		if (x == 1)
			return dp[1];
		return dp[x] = x * factorial(x - 1);
	}
}
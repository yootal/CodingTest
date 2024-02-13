import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		/*
		// dp
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		if (n >= 3) dp[3] = 1;
		if (n >= 5) dp[5] = 1;
		for (int i = 5; i <= n; i++) {
			if (dp[i - 3] != Integer.MAX_VALUE) {
				dp[i] = Math.min(dp[i], dp[i - 3] + 1);
			}
			if (dp[i - 5] != Integer.MAX_VALUE) {
				dp[i] = Math.min(dp[i], dp[i - 5] + 1);
			}
		}
		System.out.println(dp[n] == Integer.MAX_VALUE ? -1 : dp[n]);
		*/
		// greedy
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < n/5+1; i++) {
			int rest = n - 5 * i;
			if (rest % 3 == 0) {
				ans = Math.min(ans, i + rest/3);
			}
		}
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}
}
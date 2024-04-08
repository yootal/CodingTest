import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int mod = 1000000000;
		int n = Integer.parseInt(br.readLine());
		int dp[][] = new int[n + 1][10];
		dp[1] = new int[] { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		for (int i = 2; i <= n; i++) {
			dp[i][0] = dp[i - 1][1];
			dp[i][9] = dp[i - 1][8];
			for (int j = 1; j <= 8; j++) {
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
			}
		}
		int ans = 0;
		for (int i = 0; i < 10; i++) {
			ans += dp[n][i];
			ans %= mod;
		}
		System.out.println(ans);
	}
}
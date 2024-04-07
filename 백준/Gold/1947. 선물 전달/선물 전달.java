import java.io.*;

public class Main {
	static int mod = 1000000000;
	// 완전 순열 점화식
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long dp[] = new long[1000001];
		dp[1] = 0;
		dp[2] = 1;
		for (int i = 3; i <= n; i++) {
			dp[i] = (i - 1) * (dp[i - 2] + dp[i - 1]) % mod;
		}
		System.out.println(dp[n]);
	}
}
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int dp[][] = new int[N + 1][K + 1];
		Arrays.fill(dp[0], 1);
		int mod = 1000000000;
		for (int i = 1; i <= N; i++) {
			dp[i][1] = 1;
			for (int j = 1; j <= K; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				dp[i][j] %= mod;
			}
		}
		System.out.println(dp[N][K]);
	}
}
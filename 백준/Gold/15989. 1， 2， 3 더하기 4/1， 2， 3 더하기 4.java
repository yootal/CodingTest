import java.io.*;

class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int dp[][] = new int[10001][4]; //
		dp[1][1] = 1; // 1
		dp[2][1] = 1; // 1 1
		dp[2][2] = 1; // 2
		dp[3][1] = 1; // 1 1 1
		dp[3][2] = 1; // 1 2
		dp[3][3] = 1; // 3
		for (int i = 4; i < 10001; i++) {
			dp[i][1] = dp[i - 1][1];
			dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
			dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
		}
		for (int i = 0; i < T; i++) {
			int temp = Integer.parseInt(br.readLine());
			System.out.println(dp[temp][1] + dp[temp][2] + dp[temp][3]);
		}
	}
}
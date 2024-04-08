import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int num[] = new int[n];
		int dp[][] = new int[n][2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		int ans = num[0];
		dp[0][0] = num[0];
		for (int i = 1; i < n; i++) {
			dp[i][0] = Math.max(dp[i - 1][0] + num[i], num[i]);
			ans = Math.max(ans, dp[i][0]);
		}
		dp[n - 1][1] = num[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			dp[i][1] = Math.max(dp[i + 1][1] + num[i], num[i]);
		}
		for (int i = 1; i < n - 1; i++) {
			int temp = dp[i - 1][0] + dp[i + 1][1];
			ans = Math.max(ans, temp);
		}
		System.out.println(ans);
	}
}
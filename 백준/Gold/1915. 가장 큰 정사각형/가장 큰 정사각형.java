import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int dp[][] = new int[n][m];
		int ans = 0;
		for (int i = 0; i < n; i++) {
			String row = br.readLine();
			for (int j = 0; j < m; j++) {
				dp[i][j] = (int) row.charAt(j) - '0';
				if (dp[i][j] == 1 && j > 0 && i > 0) {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + dp[i][j];
				}
				ans = Math.max(ans, dp[i][j]);
			}
		}
		System.out.println((int) Math.pow(ans, 2));
	}
}
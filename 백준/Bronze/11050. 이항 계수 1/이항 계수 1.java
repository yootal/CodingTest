import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] dp = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			dp[i][1] = i;
			dp[i][0] = 1;
			dp[i][i] = 1;
			if (i >= 2) {
				for (int j = 1; j < i; j++) {
					// i-1에서 j개 다고르나 아니면 j-1개 고르나
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
				}
			}
		}
		System.out.println(dp[n][k]);
	}
}
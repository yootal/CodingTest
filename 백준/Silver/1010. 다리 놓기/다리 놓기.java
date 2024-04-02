import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int[][] dp = new int[31][31];
		for (int i = 1; i < 31; i++) {
			dp[i][1] = i;
			dp[i][0] = 1;
			dp[i][i] = 1;
			if (i >= 2) {
				for (int j = 1; j < i; j++) {
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
				}
			}
		}
		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			sb.append(dp[m][n]).append("\n");
		}
		System.out.print(sb);
	}
}
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N][3];
		st = new StringTokenizer(br.readLine());
		dp[0][0] = Integer.parseInt(st.nextToken());
		dp[0][1] = Integer.parseInt(st.nextToken());
		dp[0][2] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + a;
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + b;
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + c;
		}
		int ans = Integer.MAX_VALUE;
		for (int value : dp[N - 1]) {
			ans = Math.min(value, ans);
		}
		System.out.println(ans);
	}
}
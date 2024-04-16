import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long mod = 1000000007;
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		long dp[][][] = new long[N + 1][L + 1][R + 1];
		dp[1][1][1] = 1;
		for (int n = 2; n <= N; n++) {
			for (int l = 1; l <= L; l++) {
				for (int r = 1; r <= R; r++) {
					dp[n][l][r] = (dp[n - 1][l - 1][r] + dp[n - 1][l][r - 1] + dp[n - 1][l][r] * (n - 2)) % mod;
				}
			}
		}
		System.out.println(dp[N][L][R]);
	}
}
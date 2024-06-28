import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int input[][] = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}
		int dp[][] = new int[N + 1][T + 1];
		for (int i = 1; i <= N; i++) {
			int K = input[i - 1][0];
			int S = input[i - 1][1];
			for (int j = 1; j <= T; j++) {
				dp[i][j] = dp[i - 1][j];
				if (K <= j)
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - K] + S);

			}
		}
		System.out.println(dp[N][T]);
	}
}
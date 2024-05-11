import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num[] = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		long[][] dp = new long[N][21];
		dp[0][num[0]] = 1;
		for (int i = 1; i < N - 1; i++) {
			for (int j = 0; j < 21; j++) {
				if (limit(j + num[i])) {
					dp[i][j + num[i]] += dp[i - 1][j];
				}
				if (limit(j - num[i])) {
					dp[i][j - num[i]] += dp[i - 1][j];
				}
			}
		}
		System.out.println(dp[N - 2][num[N - 1]]);
	}

	static boolean limit(int x) {
		return x >= 0 && x <= 20;
	}
}
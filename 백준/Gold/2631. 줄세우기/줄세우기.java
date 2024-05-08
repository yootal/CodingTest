import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int maxLen = 0;
		int num[] = new int[N];
		int dp[] = new int[N + 1];
		Arrays.fill(dp, 1);
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
			for (int j = 0; j < i; j++) {
				if (num[i] > num[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			maxLen = Math.max(maxLen, dp[i]);
		}
		System.out.println(N - maxLen);
	}
}
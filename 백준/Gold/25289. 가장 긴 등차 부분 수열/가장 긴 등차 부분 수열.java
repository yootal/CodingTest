import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num[] = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		int dp[][] = new int[101][200];
		int ans = 1;
		for (int i = 0; i < n; i++) {
			for (int j = -99; j <= 99; j++) { // 등차
				if (num[i] - j < 1 || num[i] - j > 100) {
					dp[num[i]][j + 99] = 1;
				} else {
					dp[num[i]][j + 99] = dp[num[i] - j][j + 99] + 1;
				}
				ans = Math.max(ans, dp[num[i]][j + 99]);
			}
		}
		System.out.println(ans);
	}
}
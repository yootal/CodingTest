import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String args[]) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int[][] dp = new int[N + 1][L + 1];
			int[] score = new int[N + 1];
			int[] calorie = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				score[i] = Integer.parseInt(st.nextToken());
				calorie[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j < calorie[i]; j++) {
					dp[i][j] = dp[i - 1][j];
				}
				for (int j = calorie[i]; j <= L; j++) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - calorie[i]] + score[i]);
				}
			}
			sb.append("#").append(tc).append(" ").append(dp[N][L]).append("\n");
		}
		System.out.print(sb);
	}
}
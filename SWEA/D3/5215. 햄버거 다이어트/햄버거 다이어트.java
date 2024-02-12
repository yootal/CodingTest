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
			Buger[] buger = new Buger[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int score = Integer.parseInt(st.nextToken());
				int calorie = Integer.parseInt(st.nextToken());
				buger[i] = new Buger(score, calorie);
			}
			for (int i = 1; i <= N; i++) {
				Buger cur = buger[i - 1];
				for (int j = 1; j <= L; j++) {
					if (j < cur.calorie)
						dp[i][j] = dp[i - 1][j];
					else
						dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cur.calorie] + cur.score);
				}
			}
			sb.append("#").append(tc).append(" ").append(dp[N][L]).append("\n");
		}
		System.out.print(sb);
	}

	static class Buger {
		int score, calorie;

		public Buger(int score, int calorie) {
			this.score = score;
			this.calorie = calorie;
		}

	}
}
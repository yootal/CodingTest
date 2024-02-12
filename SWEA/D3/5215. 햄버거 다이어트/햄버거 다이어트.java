import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String args[]) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int N;
		int L;
		Buger[] buger = new Buger[20];
		int[][] dp = new int[21][10001];
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			for (int i = 0; i <= N; i++) {
				for (int j = 0; j <= L; j++) {
					dp[i][j] = 0;
				}
			}
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				buger[i] = new Buger(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
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
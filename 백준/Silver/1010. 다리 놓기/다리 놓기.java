import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int[][] dp = new int[31][31];
		for (int i = 0; i <= 30; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i)
					dp[i][j] = 1;
				else
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			System.out.println(dp[M][N]);
		}
	}
}
import java.io.*;
import java.util.*;

public class Main {
	static int dp[][][];
	static final int force[][] = { 
			{ 1, 2, 2, 2, 2 }, 
			{ 2, 1, 3, 4, 3 }, 
			{ 2, 3, 1, 3, 4 }, 
			{ 2, 4, 3, 1, 3 },
			{ 2, 3, 4, 3, 1 } 
			};

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dp = new int[100001][5][5];
		for (int i = 0; i <= 100000; i++) {
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					dp[i][j][k] = 100000 * 4;
				}
			}
		}
		dp[0][0][0] = 0;
		int idx = 1, cur = 0;
		
		// BottomUp
		StringTokenizer st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			cur = Integer.parseInt(st.nextToken());
			if (cur == 0)
				break;
			for (int i = 0; i < 5; i++) {
				if (i == cur) // 양발 불가능
					continue;
				for (int j = 0; j < 5; j++) {
					dp[idx][i][cur] = Math.min(dp[idx][i][cur], dp[idx - 1][i][j] + force[j][cur]);
				}
			}
			for (int j = 0; j < 5; j++) {
				if (j == cur)
					continue;
				for (int i = 0; i < 5; i++) {
					dp[idx][cur][j] = Math.min(dp[idx][cur][j], dp[idx - 1][i][j] + force[i][cur]);
				}
			}
			idx++;
		}
		idx--;
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				ans = Math.min(ans, dp[idx][i][j]);
			}
		}
		System.out.println(ans);
	}
}
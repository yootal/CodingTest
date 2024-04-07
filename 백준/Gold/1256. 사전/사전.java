import java.io.*;
import java.util.*;

public class Main {
	static int limit = 1000000000;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int dp[][] = new int[201][201];
		for (int i = 0; i < 201; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i)
					dp[i][j] = 1;
				else {
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
					if (dp[i][j] > limit)
						dp[i][j] = limit + 1;
				}
			}
		}
		if (dp[n + m][m] < k) {
			sb.append(-1);
		} else {
			while (!(n == 0 && m == 0)) {
				// a 선택 후 남은 문자로 만들 수 있는 모든 경우의 수가 k 이상
				if (dp[n - 1 + m][m] >= k) {
					sb.append('a');
					n--;
				}
				// 모든 경우의 수가 k 미만
				else {
					sb.append('z');
					k -= dp[n - 1 + m][m];
					m--;
				}
			}
		}
		System.out.println(sb);
	}
}
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] profit = new int[n + 1][m + 1];

		int[][] dp = new int[n + 1][m + 1];
		// D[N][K] : N만큼 투자 가능할때 K번째 회사까지 참여하여 얻을 수 있는 최대 이익

		int[][] pre = new int[n + 1][m + 1];
		// 얼마나 투자했는지 출력을 위해 DP 갱신될 때 금액을 기록해둔다.

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken(); // 금액은 고정이라 저장할 필요없음
			for (int j = 1; j <= m; j++) {
				profit[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i <= n; i++) { // 금액 별로 반복문 돌리고
			for (int j = 1; j <= m; j++) { // 조회할 회사 반복문 돌림
				for (int k = 0; k <= i; k++) { // 0~i 금액 반복해서 앞의 이익 기록과 비교 -> 최대 이익 갱신
					if (dp[i][j] < dp[i - k][j - 1] + profit[k][j]) {
						dp[i][j] = dp[i - k][j - 1] + profit[k][j];
						pre[i][j] = k;
						// 최대 이익이 갱신되면 갱신할때 얼마나 투자했나 기록
					}
				}
			}
		}
		System.out.println(dp[n][m]); // 최대 이익 출력
		StringBuilder sb = new StringBuilder();
		int invest = pre[n][m];
		int curN = n;
		int curM = m;
		// 이전 이익, 이전 회사 최대값을 찾아가면 투자를 얼마나 했는지 알 수 있다.
		while (curM != 0) {
			sb.insert(0, invest + " ");
			curN -= invest;
			curM--;
			invest = pre[curN][curM];
		}
		System.out.println(sb);
	}
}
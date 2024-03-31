import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] info = new int[n][2];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			info[i][0] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			info[i][1] = Integer.parseInt(st.nextToken());
		}
		int[][] dp = new int[n + 1][10001]; // n 번째 까지 사용해서 k 비용으로 얻을 수 있는 최대 메모리 
		int ans = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			int memory = info[i - 1][0];
			int cost = info[i - 1][1];
			for (int j = 0; j < 10001; j++) {
				if (i == 1) { // 처음 초기화
					if (j >= cost)
						dp[i][j] = memory;
				} else {
					if (j >= cost) // j 가 cost 이상이면 최대 메모리 계산
						dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost] + memory);
					else // 아니면 이전거
						dp[i][j] = dp[i - 1][j];
				}
				if (dp[i][j] >= m) // 사용 가능한 메모리가 m 이상이면 최소 비용 갱신
					ans = Math.min(ans, j);
			}
		}
		System.out.println(ans);
	}
}
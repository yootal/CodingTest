import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int advice[][] = new int[n][2];
		int dp[] = new int[n + 1];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			advice[i][0] = Integer.parseInt(st.nextToken());
			advice[i][1] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < n; i++) {
			int idx = i + advice[i][0];
			if (idx <= n) {
				for (int j = idx; j <= n; j++)
					dp[j] = Math.max(dp[j], dp[i] + advice[i][1]);
			}
		}
		System.out.println(dp[n]);
	}
}
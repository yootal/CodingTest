import java.io.*;
import java.util.*;

public class Main {
	static final int dx[] = { -1, 0 };
	static final int dy[] = { 0, -1 };
	static int n, m;
	static char arr[][];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		int dp[][] = new int[n + 1][m + 1];
		int ans = 0;
		for (int i = 0; i < n; i++) {
			String row = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = row.charAt(j);
				if (arr[i][j] == '1') {
					dp[i + 1][j + 1] = 1;
					ans = 1;
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (dp[i - 1][j - 1] != 0 && arr[i - 1][j - 1] == '1') {
					dp[i][j] = dp[i][j] + check(i - 1, j - 1, dp[i - 1][j - 1]);
					ans = Math.max(ans, dp[i][j]);
				}
			}
		}
		System.out.println((int) Math.pow(ans, 2));
	}

	static int check(int x, int y, int d) {
		int nx = x;
		int ny = y;
		for (int i = 0; i < d; i++) {
			nx += -1;
			ny += -1;
			if (nx < 0 || nx > n - 1 || ny < 0 || ny > m - 1)
				return i;
			if (arr[nx][y] != '1' || arr[x][ny] != '1')
				return i;
		}
		return d;
	}
}
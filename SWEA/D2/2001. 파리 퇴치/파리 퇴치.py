import java.io.*;
import java.util.*;

public class Solution {
	static int[][] board;
	static int n;
	static int m;
	static int ans;
	static int sum;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int c = 1; c <= t; c++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			board = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans = 0;
			for (int i = 0; i <= n - m; i++) {
				for (int j = 0; j <= n - m; j++) {
					sum = 0;
					for (int i2 = i; i2 < i + m; i2++) {
						for (int j2 = j; j2 < j + m; j2++) {
							sum += board[i2][j2];
						}
					}
					ans = Math.max(ans, sum);
				}
			}
			sb.append("#").append(c).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

}
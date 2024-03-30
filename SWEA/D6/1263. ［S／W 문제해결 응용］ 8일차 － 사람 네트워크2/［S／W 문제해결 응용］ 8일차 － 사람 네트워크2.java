import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[][] dist = new int[n][n];
			for (int i = 0; i < n * n; i++) {
				dist[i / n][i % n] = Integer.parseInt(st.nextToken());
				if (dist[i / n][i % n] == 0 && i / n != i % n)
					dist[i / n][i % n] = 10000;
			}
			for (int k = 0; k < n; k++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (dist[i][j] > dist[i][k] + dist[k][j]) {
							dist[i][j] = dist[i][k] + dist[k][j];
						}
					}
				}
			}
			int ans = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				int sum = 0;
				for (int j = 0; j < n; j++) {
					if (dist[i][j] != 10000)
						sum += dist[i][j];
				}
				ans = Math.min(ans, sum);
			}
			sb.append("#").append(tc + " ").append(ans).append("\n");
		}
		System.out.print(sb);
	}
}
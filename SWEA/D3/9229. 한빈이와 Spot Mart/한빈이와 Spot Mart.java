import java.io.*;
import java.util.*;

public class Solution {
	static int ans;
	static int[] weights;
	static int n;
	static int m;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			ans = -1;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			weights = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				weights[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(weights);
			int start = 0, end = n - 1;
			while (start < end) {
				int sum = weights[start] + weights[end];

				if (sum > m) {
					end--;
				} else {
					ans = Math.max(sum, ans);
					start++;
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

}
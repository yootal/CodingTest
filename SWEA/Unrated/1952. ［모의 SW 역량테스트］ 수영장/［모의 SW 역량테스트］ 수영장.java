import java.io.*;
import java.util.*;

public class Solution {
	static int ans, plan[], c1, c2, c3, c4;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		plan = new int[12];
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			c1 = Integer.parseInt(st.nextToken());
			c2 = Integer.parseInt(st.nextToken());
			c3 = Integer.parseInt(st.nextToken());
			c4 = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			ans = 0;
			for (int i = 0; i < 12; i++) {
				int d = Integer.parseInt(st.nextToken());
				plan[i] = d * c1;
				ans += plan[i];
			}
			findMin(0, ans);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

	static void findMin(int idx, int total) {
		if (idx >= 12) {
			ans = Math.min(ans, total);
			return;
		}
		
		// 1년
		if (idx == 0) findMin(idx + 12, c4);

		// 1일
		findMin(idx + 1, total);

		// 1달
		findMin(idx + 1, total - plan[idx] + c2);

		// 3달
		int m3 = 0;
		for (int i = idx; i < Math.min(idx + 3, 12); i++) {
			m3 += plan[i];
		}
		findMin(idx + 3, total - m3 + c3);
	}
}
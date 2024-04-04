import java.io.*;
import java.util.*;

public class Solution {
	static int n, b, ans, num[];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			num = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			ans = Integer.MAX_VALUE;
			select(0, 0);
			sb.append("#").append(tc).append(" ").append(ans - b).append("\n");
		}
		System.out.print(sb);
	}

	static void select(int cur, int total) {
		if (total > ans)
			return;
		if (cur == n) {
			if (total >= b) {
				ans = Math.min(ans, total);
			}
			return;
		}
		select(cur + 1, total + num[cur]);
		select(cur + 1, total);
	}
}
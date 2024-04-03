import java.io.*;
import java.util.*;

public class Solution {
	static int N, cnt[], num[], max, min;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			cnt = new int[4];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				cnt[i] = Integer.parseInt(st.nextToken());
			}
			num = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			max = -Integer.MAX_VALUE;
			min = Integer.MAX_VALUE;
			solve(1, num[0]);
			sb.append("#").append(tc).append(" ").append(max - min).append("\n");
		}
		System.out.print(sb);
	}

	static void solve(int cur, int total) {
		if (cur == N) {
			max = Math.max(max, total);
			min = Math.min(min, total);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (cnt[i] > 0) {
				cnt[i]--;
				switch (i) {
				case 0:
					solve(cur + 1, total + num[cur]);
					break;
				case 1:
					solve(cur + 1, total - num[cur]);
					break;
				case 2:
					solve(cur + 1, total * num[cur]);
					break;
				default:
					solve(cur + 1, total / num[cur]);
					break;
				}
				cnt[i]++;
			}
		}
	}
}
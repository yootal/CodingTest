import java.io.*;
import java.util.*;

public class Solution {
	static int D, W, K, R, ans;
	static int[][] film;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			film = new int[D][W];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans = -1;
			for (int i = 0; i <= K; i++) {
				R = i;
				dfs(0, 0);
				if (ans != -1)
					break;
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

	static boolean check() {
		boolean flag;
		for (int j = 0; j < W; j++) {
			int state = -1;
			int cnt = 0;
			flag = false;
			for (int i = 0; i < D; i++) {
				if (state != film[i][j]) {
					state = film[i][j];
					cnt = 1;
				} else {
					cnt++;
				}
				if (cnt == K)
					flag = true;
			}
			if (!flag)
				return false;
		}
		return true;
	}

	static void dfs(int cnt, int idx) {
		if (R - cnt > D - idx)
			return;
		if (cnt == R) {
			if (check()) {
				ans = R;
			}
			return;
		}
		int[] temp = film[idx];

		film[idx] = new int[W];
		Arrays.fill(film[idx], 1);
		dfs(cnt + 1, idx + 1);

		Arrays.fill(film[idx], 0);
		dfs(cnt + 1, idx + 1);

		film[idx] = temp;
		dfs(cnt, idx + 1);
	}
}
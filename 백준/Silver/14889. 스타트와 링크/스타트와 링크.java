import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int ans = Integer.MAX_VALUE;
	static int[][] level;
	static boolean[] vis;

	public static void main(String args[]) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		level = new int[n][n];
		vis = new boolean[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				level[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		backTracking(0, 0);
		System.out.println(ans);
	}

	static void backTracking(int depth, int idx) {
		if (depth == n / 2) {
			int t1 = 0, t2 = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (vis[i] && vis[j])
						t1 += level[i][j];
					else if (!vis[i] && !vis[j])
						t2 += level[i][j];
				}
			}
			ans = Math.min(ans, Math.abs(t1 - t2));
			return;
		}

		for (int i = idx; i < n; i++) {
			if (!vis[i]) {
				vis[i] = true;
				backTracking(depth + 1, i + 1);
				vis[i] = false;
			}
		}
	}
}
import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static long[] ans;
	static ArrayList<Integer>[] graph;
	static boolean[] vis;

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		ans = new long[n];
		for (int i = 0; i < n; i++) {
			ans[i] = 1;
		}
		graph = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			long gcd_ans = gcd(ans[a], ans[b]);
			long gcd_inp = gcd(p, q);
			long lcm = ans[a] / gcd_ans * ans[b];
			vis = new boolean[n];
			dfs(a, lcm / ans[a] * p / gcd_inp);
			dfs(b, lcm / ans[b] * q / gcd_inp);
			graph[a].add(b);
			graph[b].add(a);
		}
		long end_gcd = ans[0];
		for (int i = 0; i < n - 1; i++) {
			end_gcd = gcd(end_gcd, ans[i + 1]);
		}

		for (int i = 0; i < n; i++) {
			sb.append(ans[i] / end_gcd).append(" ");
		}
		System.out.println(sb);
	}

	static long gcd(long x, long y) {
		if (x % y == 0)
			return y;
		return gcd(y, x % y);
	}

	static void dfs(int x, long w) {
		ans[x] *= w;
		vis[x] = true;
		for (int nxt : graph[x]) {
			if (!vis[nxt]) {
				dfs(nxt, w);
			}
		}
	}

}
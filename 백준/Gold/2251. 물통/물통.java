import java.io.*;
import java.util.*;

public class Main {
	static Set<Integer> set;
	static boolean[][] vis;
	static int A, B, C;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		vis = new boolean[A + 1][B + 1];
		set = new HashSet<>();
		dfs(0, 0, C);
		ArrayList<Integer> list = new ArrayList<>(set);
		Collections.sort(list);
		for (int x : list)
			sb.append(x + " ");
		System.out.print(sb);

	}

	static void dfs(int a, int b, int c) {
		if (vis[a][b])
			return;
		vis[a][b] = true;

		if (a == 0) {
			if (!set.contains(c))
				set.add(c);
			else
				return;
		}

		if (a < A) {
			if (b >= A - a)
				dfs(A, b - (A - a), c);
			else
				dfs(a + b, 0, c);
			if (c >= A - a)
				dfs(A, b, c - (A - a));
			else
				dfs(a + c, b, 0);
		}

		if (b < B) {
			if (a >= B - b)
				dfs(a - (B - b), B, c);
			else
				dfs(0, a + b, c);
			if (c > B - b)
				dfs(a, B, c - (B - b));
			else
				dfs(a, b + c, 0);
		}

		if (c < C) {
			if (b >= C - c)
				dfs(a, b - (C - c), C);
			else
				dfs(a, 0, b + c);
			if (a >= C - c)
				dfs(a - (C - c), b, C);
			else
				dfs(0, b, a + c);
		}
	}

}
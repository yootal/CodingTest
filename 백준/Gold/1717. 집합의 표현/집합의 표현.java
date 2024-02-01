import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int a, b, c;
	static int[] parent;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			if (a == 0) {
				union(b, c);
			} else {
				if (check(b, c)) {
					sb.append("YES").append("\n");
				} else
					sb.append("NO").append("\n");
			}
		}
		System.out.print(sb);
	}

	static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	static boolean check(int x, int y) {
		if (find(x) == find(y))
			return true;
		return false;
	}

	static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if (px > py) {
			parent[px] = py;
		} else {
			parent[py] = px;
		}
	}
}
import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int m;
	static int[] parent;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (i < j && num == 1) {
					union(i, j);
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		int pre = Integer.parseInt(st.nextToken());
		boolean flag = false;
		for (int i = 1; i < m; i++) {
			int nxt = Integer.parseInt(st.nextToken());
			if (find(pre) != find(nxt)) {
				flag = true;
				break;
			}
			pre = nxt;
		}
		System.out.println(flag ? "NO" : "YES");
	}

	static void union(int x, int y) {
		int px = find(x);
		int py = find(y);

		if (px > py) {
			parent[px] = py;
		} else {
			parent[py] = px;
		}
		return;
	}

	static int find(int x) {
		if (x != parent[x]) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

}
import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int m;
	static int r;
	static int standard;
	static int[] parent;
	static int[] record;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		record = new int[m];
		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		int ans = 0;
		int check = 0;
		st = new StringTokenizer(br.readLine());
		int know = Integer.parseInt(st.nextToken());
		if (know != 0) {
			int[] knows = new int[know];
			for (int i = 0; i < know; i++) {
				knows[i] = Integer.parseInt(st.nextToken());
			}
			standard = knows[0];
			for (int i = 1; i < know; i++) {
				union(standard, knows[i]);
			}
			check = find(standard);
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			for (int j = 1; j < r; j++) {
				union(start, Integer.parseInt(st.nextToken()));
			}
			record[i] = find(start);
		}
		for (int p : record) {
			if (find(p) != find(check))
				ans++;
		}
		System.out.println(ans);
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

	static int find(int x) {
		if (x != parent[x]) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

}
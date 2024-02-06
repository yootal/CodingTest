import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int know;
	static int standard;
	static int[] parent;
	static int[] record;
	static int[] knows;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int ans = 0;
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		st = new StringTokenizer(br.readLine());
		know = Integer.parseInt(st.nextToken());
		knows = new int[know];
		for (int i = 0; i < know; i++) {
			knows[i] = Integer.parseInt(st.nextToken());
		}
		record = new int[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			for (int j = 1; j < len; j++) {
				union(start, Integer.parseInt(st.nextToken()));
			}
			record[i] = find(start);
		}
		for (int i = 0; i < M; i++) {
			boolean check = true;
			for (int j = 0; j < know; j++) {
				if (find(record[i]) == find(knows[j])) {
					check = false;
					break;
				}
			}
			if (check)
				ans++;
		}
		System.out.println(ans);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);
//		if (px > py) {
//			parent[px] = py;
//		} else {
//			parent[py] = px;
//		}
		if (x != y)
			parent[y] = x;
	}

	static int find(int x) {
		if (x != parent[x]) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

}
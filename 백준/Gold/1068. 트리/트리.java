import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] al;
	static int ans, erase;
	static boolean vis[];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		al = new ArrayList[n];
		vis = new boolean[n];
		for (int i = 0; i < n; i++) {
			al[i] = new ArrayList<>();
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int root = 0;
		for (int i = 0; i < n; i++) {
			int p = Integer.parseInt(st.nextToken());
			if (p == -1)
				root = i;
			else {
				al[p].add(i);
				al[i].add(p);
			}
		}
		erase = Integer.parseInt(br.readLine());
		if (root != erase)
			dfs(root);
		System.out.println(ans);
	}

	static void dfs(int x) {
		vis[x] = true;
		boolean flag = false;
		for (int nxt : al[x]) {
			if (vis[nxt] || nxt == erase)
				continue;
			dfs(nxt);
			flag = true;
		}
		if (!flag)
			ans++;
	}
}
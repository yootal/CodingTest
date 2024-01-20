import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] graph;
	static boolean[] vis;
	static int ans;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N];
		vis = new boolean[N];
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		for (int i = 0 ; i < N ; i++) {
			if (ans == 1) break;
			vis[i] = true;
			dfs(i,0,N);
			vis[i] = false;
		}
		System.out.println(ans);
	}

	static void dfs(int x, int cnt, int check) {
		if (cnt >= 4) {
			ans = 1;
			return;
		}
		for (int nxt : graph[x]) {
			if (!vis[nxt]) {
				vis[nxt] = true;
				dfs(nxt, cnt + 1, check);
				vis[nxt] = false;
			}
		}
	}
}
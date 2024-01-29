import java.io.*;
import java.util.*;

public class Main {
	static int n, m, k, x;
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		ArrayList<Integer> ans = new ArrayList<>();
		int[] vis = new int[n + 1];
		graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
			vis[i] = -1;
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
		}
		Deque<Integer> dq = new ArrayDeque<>();
		dq.offerLast(x);
		vis[x]++;
		while (!dq.isEmpty()) {
			int cur = dq.pollFirst();
			for (int nxt : graph[cur]) {
				if (vis[nxt] == -1) {
					vis[nxt] = vis[cur] + 1;
					dq.offerLast(nxt);
				}
			}
		}
		for (int i = 0; i <= n; i++) {
			if (vis[i] == k) {
				ans.add(i);
			}
		}
		if (ans.isEmpty()) {
			sb.append(-1);
		} else {
			Collections.sort(ans);
			for (int out : ans) {
				sb.append(out).append("\n");
			}
		}
		System.out.print(sb);
	}

}
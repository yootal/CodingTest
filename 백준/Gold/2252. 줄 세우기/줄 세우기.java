import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] indegree;
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		indegree = new int[n + 1];
		graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			indegree[b]++;
		}
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			if (indegree[i] == 0) {
				q.offerLast(i);
			}
		}
		while (!q.isEmpty()) {
			int cur = q.pollFirst();
			sb.append(cur + " ");
			for (int nxt : graph[cur]) {
				indegree[nxt]--;
				if (indegree[nxt] == 0) {
					q.offerLast(nxt);
				}
			}
		}
		System.out.println(sb);
	}

}
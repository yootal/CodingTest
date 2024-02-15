import java.io.*;
import java.util.*;

public class Solution {
	static int N, M, ans;
	static Node[] graph;
	static boolean[] vis;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc < 11; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			graph = new Node[100];
			vis = new boolean[100];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a] = new Node(b, graph[a]);
			}
			ans = 0;
			dfs(0);
			sb.append("#").append(N).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

	static void dfs(int i) {
		if (i == 99 || ans == 1) {
			ans = 1;
			return;
		}
		vis[i] = true;
		for (Node j = graph[i]; j != null; j = j.link) {
			if (!vis[j.vertex]) {
				dfs(j.vertex);
			}
		}
	}

	static class Node {
		int vertex;
		Node link;

		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}

		public Node(int vertex) {
			this.vertex = vertex;
		}

	}
}
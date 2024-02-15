import java.io.*;
import java.util.*;

public class Solution {
	static int N, M, ans;
	static String inp;
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc < 11; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			graph = new ArrayList[100];
			for (int i = 0; i < 100; i++) {
				graph[i] = new ArrayList<>();
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				graph[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
			}
			ans = 0;
			dfs(0);
			sb.append("#").append(N).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

	static void dfs(int cur) {
		if (cur == 99) {
			ans = 1;
			return;
		}
		for (int nxt : graph[cur]) {
			dfs(nxt);
		}
	}

}
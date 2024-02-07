import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] record = new int[n + 1];
		int[] time = new int[n + 1];
		int[] indegree = new int[n + 1];
		ArrayList<Integer>[] graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			while (st.hasMoreTokens()) {
				int nxt = Integer.parseInt(st.nextToken());
				if (nxt != -1) {
					graph[nxt].add(i);
					indegree[i]++;
				}
			}
		}
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			if (indegree[i] == 0) {
				q.offerLast(i);
			}
		}
		while (!q.isEmpty()) {
			int cur = q.pollFirst();
			for (int nxt : graph[cur]) {
				indegree[nxt]--;
				record[nxt] = Math.max(record[nxt], record[cur] + time[cur]);
				if (indegree[nxt] == 0) {
					q.offerLast(nxt);
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			sb.append(record[i] + time[i]).append("\n");
		}
		System.out.println(sb);
	}
}
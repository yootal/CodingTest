import java.io.*;
import java.util.*;

public class Main {

	public static void main(String args[]) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(stt.nextToken());
		int E = Integer.parseInt(stt.nextToken());
		int st = Integer.parseInt(br.readLine());
		int[] sdt = new int[V + 1];
		ArrayList<int[]>[] graph = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) {
			graph[i] = new ArrayList<int[]>();
		}
		for (int i = 0; i < E; i++) {
			stt = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(stt.nextToken());
			int v = Integer.parseInt(stt.nextToken());
			int w = Integer.parseInt(stt.nextToken());
			graph[u].add(new int[] { v, w });
		}
		for (int i = 1; i <= V; i++) {
			sdt[i] = Integer.MAX_VALUE;
		}
		sdt[st] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(Comparator.comparing(o -> o[1]));
		pq.offer(new int[] { st, sdt[st] });
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			if (cur[1] != sdt[cur[0]])
				continue;
			for (int[] nxt : graph[cur[0]]) {
				if (sdt[nxt[0]] > cur[1] + nxt[1]) {
					sdt[nxt[0]] = cur[1] + nxt[1];
					pq.offer(new int[] { nxt[0], sdt[nxt[0]] });
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			sb.append(sdt[i] == Integer.MAX_VALUE ? "INF" : sdt[i]).append("\n");
		}
		System.out.print(sb);
	}
}
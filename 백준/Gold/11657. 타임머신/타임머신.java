import java.io.*;
import java.util.*;

public class Main {

	public static void main(String args[]) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] edges = new int[M][];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edges[i] = new int[] { a, b, c };
		}
		long[] dist = new long[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 최단거리 업데이트
				if (dist[edges[j][0]] != Integer.MAX_VALUE && dist[edges[j][1]] > dist[edges[j][0]] + edges[j][2]) {
					dist[edges[j][1]] = dist[edges[j][0]] + edges[j][2];
				}
			}
		}
		boolean cycleCheck = false;
		for (int i = 0; i < M; i++) { // 음수 사이클 확인
			if (dist[edges[i][0]] != Integer.MAX_VALUE && dist[edges[i][1]] > dist[edges[i][0]] + edges[i][2])
				cycleCheck = true;
		}
		StringBuilder sb = new StringBuilder();
		if (!cycleCheck) { // 음의 사이클 없을 때
			for (int i = 2; i <= N; i++) {
				sb.append(dist[i] == Integer.MAX_VALUE ? "-1" : dist[i]).append("\n");
			}
		} else
			sb.append("-1");
		System.out.print(sb);
	}

}
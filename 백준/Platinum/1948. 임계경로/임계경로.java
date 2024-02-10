import java.io.*;
import java.util.*;

public class Main {

	public static void main(String args[]) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] indegree = new int[N + 1]; // 차수 저장
		int[] last = new int[N + 1]; // 도착 시간
		ArrayList<int[]>[] graph = new ArrayList[N + 1]; // 갈 때 쓸 그래프
		ArrayList<int[]>[] return_graph = new ArrayList[N + 1]; // 돌아올 때 쓸 그래프
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<int[]>();
			return_graph[i] = new ArrayList<int[]>();
		}
		for (int i = 0; i < M; i++) {
			stt = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stt.nextToken());
			int b = Integer.parseInt(stt.nextToken());
			int t = Integer.parseInt(stt.nextToken());
			graph[a].add(new int[] { t, b });
			return_graph[b].add(new int[] { t, a });
			indegree[b]++;
		}
		stt = new StringTokenizer(br.readLine());
		int st = Integer.parseInt(stt.nextToken());
		int en = Integer.parseInt(stt.nextToken());
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] { 0, st });
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int[] nxt : graph[cur[1]]) {
				indegree[nxt[1]]--;
				last[nxt[1]] = Math.max(last[nxt[1]], last[cur[1]] + nxt[0]); // 가장 늦은 시간 저장
				if (indegree[nxt[1]] == 0) {
					q.offer(new int[] { last[nxt[1]], nxt[1] });
				}
			}
		}
		System.out.println(last[en]); // 도착지 도착 시간 출력
		int route_cnt = 0;
		boolean[] check = new boolean[N + 1]; // 방문 체크
		check[en] = true;
		q.offer(new int[] { last[en], en });
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int[] nxt : return_graph[cur[1]]) {
				if (last[nxt[1]] == cur[0] - nxt[0]) {
					route_cnt++; // 경로 수 카운팅
					if (!check[nxt[1]]) { // 처음 인 것만 넣음
						check[nxt[1]] = true;
						q.offer(new int[] { last[nxt[1]], nxt[1] });
					}
				}
			}
		}
		System.out.println(route_cnt); // 경로 수 출력
	}
}
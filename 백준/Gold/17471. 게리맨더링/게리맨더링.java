import java.io.*;
import java.util.*;

public class Main {
	static int N, R, cnt[], ans = Integer.MAX_VALUE;
	static int[] group;
	static int[] group2;
	static boolean[] visited;
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		cnt = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			cnt[i] = Integer.parseInt(st.nextToken());
		}
		graph = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int range = Integer.parseInt(st.nextToken());
			for (int j = 0; j < range; j++) {
				int link = Integer.parseInt(st.nextToken());
				graph[i].add(link);
				graph[link].add(i);
			}
		}

		for (int i = 1; i < N; i++) {
			R = i;
			group = new int[R];
			group2 = new int[N - R];
			comb(0, 1);
		}
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}

	static void comb(int count, int idx) {
		if (count == R) {
			int j = 0;
//			System.out.println(Arrays.toString(visited));
			for (int i = 1; i <= N; i++) {
				if (!visited[i])
					group2[j++] = i;
			}
//			System.out.println(Arrays.toString(group));
//			System.out.println(Arrays.toString(group2));
			if (link_check(group[0], group) && link_check(group2[0], group2)) {
				int sum1 = 0;
				int sum2 = 0;
				for (int g1 : group) {
					sum1 += cnt[g1];
				}
				for (int g2 : group2) {
					sum2 += cnt[g2];
				}
				ans = Math.min(ans, Math.abs(sum1 - sum2));
			}
			return;
		}
		for (int i = idx; i <= N; i++) {
			visited[i] = true;
			group[count] = i;
			comb(count + 1, i + 1);
			visited[i] = false;
		}
	}

	static boolean link_check(int x, int[] g) {
		boolean[] vis = new boolean[N + 1];
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(x);
		vis[x] = true;
		int gCnt = 1;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int nxt : graph[cur]) {
				if (!vis[nxt]) {
					if (num_check(nxt, g)) {
						vis[nxt] = true;
						q.offer(nxt);
						gCnt++;
					} else {
						vis[nxt] = true;
					}
				}
			}
		}
		if (gCnt == g.length)
			return true;
		return false;
	}

	static boolean num_check(int x, int[] g) {
		for (int mem : g) {
			if (mem == x)
				return true;
		}
		return false;
	}
}
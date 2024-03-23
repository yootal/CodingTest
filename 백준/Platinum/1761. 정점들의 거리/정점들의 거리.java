import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<int[]>[] tree;
	static int n, maxDepth, depth[], parent[][], dist[];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		tree = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			tree[i] = new ArrayList<>();
		}
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			// 다음 노드랑 거리를 같이 넣어놔야 루트에서 다른 노드까지 거리 활용가능
			tree[s].add(new int[] { e, d }); 
			tree[e].add(new int[] { s, d });
		}
		dist = new int[n + 1]; 
		depth = new int[n + 1];
		maxDepth = (int) (Math.log(n) / Math.log(2));
		parent = new int[maxDepth + 1][n + 1];
		bfs();
		for (int k = 1; k <= maxDepth; k++) {
			for (int j = 1; j <= n; j++) {
				parent[k][j] = parent[k - 1][parent[k - 1][j]];
			}
		}
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// a 까지 거리 +  b 까지 거리 - (최소 공통 조상까지 거리 * 2)
			sb.append(dist[a] + dist[b] - (dist[lca(a, b)] * 2)).append("\n");
		}
		System.out.print(sb);
	}

	static int lca(int a, int b) {
		if (depth[a] > depth[b]) { // b depth 크도록 조정
			int temp = a;
			a = b;
			b = temp;
		}
		for (int k = maxDepth; k >= 0; k--) { // b K값 줄여나가며 높이 차이 0될때 까지 이동
			if (Math.pow(2, k) <= depth[b] - depth[a]) {
				if (depth[a] <= depth[parent[k][b]]) {
					b = parent[k][b];
				}
			}
		}
		for (int k = maxDepth; k >= 0; k--) { // 위치를 맞춘 후 동시에 이동함
			if (parent[k][a] != parent[k][b]) {
				a = parent[k][a];
				b = parent[k][b];
			}
		}
		int result = a;
		if (a != b) { // 다르면 하나 위 노드
			result = parent[0][a];
		}
		return result;
	}

	static void bfs() {
		boolean vis[] = new boolean[n + 1];
		Queue<Integer> q = new ArrayDeque<>();
		q.add(1);
		vis[1] = true;
		int level = 1;
		int size = 1;
		int count = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int[] nxt : tree[cur]) {
				if (!vis[nxt[0]]) {
					vis[nxt[0]] = true;
					q.add(nxt[0]);
					parent[0][nxt[0]] = cur;
					depth[nxt[0]] = level;
					dist[nxt[0]] = dist[cur] + nxt[1];
				}
			}
			count++;
			if (count == size) {
				count = 0;
				size = q.size();
				level++;
			}
		}
	}
}
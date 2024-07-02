import java.util.*;
import java.io.*;

class Main {
	static ArrayList<int[]> graph[];
	static int N, depth[], maxDepth, parent[][], parentMinDist[][], parentMaxDist[][], minDist, maxDist;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		boolean parentCheck[] = new boolean[N + 1];
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new int[] { b, c });
			graph[b].add(new int[] { a, c });
			parentCheck[b] = true;
		}
		int root = -1;
		for (int i = 1; i <= N; i++) {
			if (!parentCheck[i]) {
				root = i;
				break;
			}
		}
		depth = new int[N + 1];
		maxDepth = (int) (Math.log(N) / Math.log(2));
		parent = new int[maxDepth + 1][N + 1];
		parentMaxDist = new int[maxDepth + 1][N + 1];
		parentMinDist = new int[maxDepth + 1][N + 1];
		// D[K][N] : N부터 2^K번째 부모까지 중 최소/최대 길이의 경로
		bfs(root);
		for (int i = 1; i <= maxDepth; i++) {
			for (int j = 1; j <= N; j++) {
				parent[i][j] = parent[i - 1][parent[i - 1][j]];
				parentMinDist[i][j] = Math.min(parentMinDist[i - 1][j], parentMinDist[i - 1][parent[i - 1][j]]);
				parentMaxDist[i][j] = Math.max(parentMaxDist[i - 1][j], parentMaxDist[i - 1][parent[i - 1][j]]);
			}
		}
		StringBuilder sb = new StringBuilder();
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			lca(d, e);
			sb.append(minDist + " " + maxDist).append("\n");
		}
		System.out.print(sb);
	}

	static void lca(int a, int b) {
		minDist = Integer.MAX_VALUE;
		maxDist = Integer.MIN_VALUE;
		if (depth[a] > depth[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		for (int i = maxDepth; i >= 0; i--) {
			if (Math.pow(2, i) <= depth[b] - depth[a]) {
				if (depth[a] <= depth[parent[i][b]]) {
					minDist = Math.min(minDist, parentMinDist[i][b]);
					maxDist = Math.max(maxDist, parentMaxDist[i][b]);
					b = parent[i][b];
				}
			}
		}
		if (a != b) {
			for (int i = maxDepth; i >= 0; i--) {
				if (parent[i][a] != parent[i][b]) {
					minDist = Math.min(minDist, Math.min(parentMinDist[i][a], parentMinDist[i][b]));
					maxDist = Math.max(maxDist, Math.max(parentMaxDist[i][a], parentMaxDist[i][b]));
					a = parent[i][a];
					b = parent[i][b];
				}
			}
			minDist = Math.min(minDist, Math.min(parentMinDist[0][a], parentMinDist[0][b]));
			maxDist = Math.max(maxDist, Math.max(parentMaxDist[0][a], parentMaxDist[0][b]));
		}
	}

	static void bfs(int root) {
		boolean vis[] = new boolean[N + 1];
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { root, 0 });
		vis[root] = true;
		int level = 1;
		int size = 1;
		int count = 0;
		while (!q.isEmpty()) {
			int cur[] = q.poll();
			for (int nxt[] : graph[cur[0]]) {
				if (!vis[nxt[0]]) {
					vis[nxt[0]] = true;
					q.offer(nxt);
					parent[0][nxt[0]] = cur[0];
					parentMinDist[0][nxt[0]] = nxt[1];
					parentMaxDist[0][nxt[0]] = nxt[1];
					depth[nxt[0]] = level;
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
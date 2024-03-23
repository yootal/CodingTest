import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] tree;
	static int n, maxDepth, depth[], parent[][];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());

		// 트리 정보 초기화
		tree = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			tree[i] = new ArrayList<>();
		}
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			tree[s].add(e);
			tree[e].add(s);
		}

		depth = new int[n + 1]; // 노드 별 깊이 기록
		maxDepth = (int) (Math.log(n) / Math.log(2)); // 최대 가능 깊이 -> log2 계산
		parent = new int[maxDepth + 1][n + 1]; // parent[K][N] = N번 노드의 2^K번째 부모 노드의 번호

		bfs(); // parent, level 초기화

		// 점화식을 바탕으로 부모 배열 초기화
		for (int k = 1; k <= maxDepth; k++) {
			for (int j = 1; j <= n; j++) {
				parent[k][j] = parent[k - 1][parent[k - 1][j]];
				// 점화식: N의 2^K번째 부모노드는 N의 2^(K-1)번째 부모노드의 2^(K-1)번째 부모노드와 같다
			}
		}
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(lca(a,b)).append("\n");
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
		int result = a; // 최소 공통 조상
		if (a != b) { // 다르면 하나 위 노드
			result = parent[0][result];
		}
		return result;
	}

	static void bfs() {
		boolean vis[] = new boolean[n + 1]; // 노드 방문 체크
		Queue<Integer> q = new ArrayDeque<>();
		q.add(1);
		vis[1] = true;
		int level = 1;
		int size = 1;
		int count = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int nxt : tree[cur]) {
				if (!vis[nxt]) {
					vis[nxt] = true;
					q.add(nxt);
					parent[0][nxt] = cur; // K = 0, 2^0 = 1, 즉 바로 이전 부모
					depth[nxt] = level;
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
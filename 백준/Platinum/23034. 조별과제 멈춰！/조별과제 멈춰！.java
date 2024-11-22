import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static ArrayList<int[]>[] graph, mst;
    static int[][] parent, maxEdge;
    static int[] depth;
    static boolean[] vis;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        mst = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
            mst[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c});
        }
        long total = makeMST();

        // Prepare LCA tables
        parent = new int[N + 1][17]; // log2(100000) ≈ 17
        maxEdge = new int[N + 1][17];
        depth = new int[N + 1];
        vis = new boolean[N + 1];
        dfs(1, 0);

        // Process queries
        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int maxWeight = getMaxWeight(x, y);
            sb.append(total - maxWeight).append("\n");
        }
        System.out.print(sb);
    }

    static long makeMST() {
        long total = 0;
        vis = new boolean[N + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{1, 0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int from = cur[1];
            int dist = cur[2];
            if (vis[node]) continue;
            vis[node] = true;
            if (from != 0) {
                mst[from].add(new int[]{node, dist});
                mst[node].add(new int[]{from, dist});
            }
            total += dist;
            for (int[] nxt : graph[node]) {
                if (!vis[nxt[0]]) {
                    pq.offer(new int[]{nxt[0], node, nxt[1]});
                }
            }
        }
        return total;
    }

    static void dfs(int node, int par) {
        vis[node] = true;
        for (int[] nxt : mst[node]) {
            int nextNode = nxt[0];
            int weight = nxt[1];
            if (!vis[nextNode]) {
                depth[nextNode] = depth[node] + 1;
                parent[nextNode][0] = node;
                maxEdge[nextNode][0] = weight;
                for (int i = 1; i < 17; i++) {
                    parent[nextNode][i] = parent[parent[nextNode][i - 1]][i - 1];
                    maxEdge[nextNode][i] = Math.max(maxEdge[nextNode][i - 1], maxEdge[parent[nextNode][i - 1]][i - 1]);
                }
                dfs(nextNode, node);
            }
        }
    }

    static int getMaxWeight(int x, int y) {
        if (depth[x] < depth[y]) {
            int temp = x;
            x = y;
            y = temp;
        }
        int maxWeight = 0;
        for (int i = 16; i >= 0; i--) {
            if (depth[x] - (1 << i) >= depth[y]) {
                maxWeight = Math.max(maxWeight, maxEdge[x][i]);
                x = parent[x][i];
            }
        }
        if (x == y) return maxWeight;
        for (int i = 16; i >= 0; i--) {
            if (parent[x][i] != parent[y][i]) {
                maxWeight = Math.max(maxWeight, maxEdge[x][i]);
                maxWeight = Math.max(maxWeight, maxEdge[y][i]);
                x = parent[x][i];
                y = parent[y][i];
            }
        }
        return Math.max(maxWeight, Math.max(maxEdge[x][0], maxEdge[y][0]));
    }
}
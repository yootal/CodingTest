import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<int[]>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        graph = new ArrayList[V + 3];
        for (int i = 1; i <= V + 2; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }
        boolean[] check = new boolean[V + 1];
        int mac = V + 1;
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int m = Integer.parseInt(st.nextToken());
            check[m] = true;
            graph[mac].add(new int[]{m, 0});
        }
        int star = V + 2;
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < S; i++) {
            int s = Integer.parseInt(st.nextToken());
            check[s] = true;
            graph[star].add(new int[]{s, 0});
        }
        int[] mDist = new int[V + 3];
        Arrays.fill(mDist, Integer.MAX_VALUE);
        dijkstra(mDist, mac);
        int[] sDist = new int[V + 3];
        Arrays.fill(sDist, Integer.MAX_VALUE);
        dijkstra(sDist, star);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= V; i++) {
            if (!check[i] && mDist[i] <= x && sDist[i] <= y) {
                ans = Math.min(ans, mDist[i] + sDist[i]);
            }
        }
        System.out.println(ans != Integer.MAX_VALUE ? ans : -1);
    }

    static void dijkstra(int[] dist, int start) {
        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.offer(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (dist[cur[0]] != cur[1]) continue;
            for (int[] nxt : graph[cur[0]]) {
                if (dist[nxt[0]] > cur[1] + nxt[1]) {
                    dist[nxt[0]] = cur[1] + nxt[1];
                    pq.offer(new int[]{nxt[0], dist[nxt[0]]});
                }
            }
        }
    }
}

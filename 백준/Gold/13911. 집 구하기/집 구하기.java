import java.io.*;
import java.util.*;

public class Main {
    static int V, E;
    static ArrayList<int[]>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
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
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] mac = new int[M];
        for (int i = 0; i < M; i++) {
            mac[i] = Integer.parseInt(st.nextToken());
            check[mac[i]] = true;
        }
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int[] sta = new int[S];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < S; i++) {
            sta[i] = Integer.parseInt(st.nextToken());
            check[sta[i]] = true;
        }
        int ans = Integer.MAX_VALUE;
        int[] distMac = dijkstra(mac);
        int[] distSta = dijkstra(sta);
        for (int i = 1; i <= V; i++) {
            if (!check[i] && distMac[i] <= x && distSta[i] <= y) {
                ans = Math.min(ans, distMac[i] + distSta[i]);
            }
        }
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static int[] dijkstra(int[] start) {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[1]));
        for (int point : start) {
            dist[point] = 0;
            pq.offer(new int[]{point, dist[point]});
        }
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[1] != dist[cur[0]]) continue;
            for (int[] nxt : graph[cur[0]]) {
                if (dist[nxt[0]] > cur[1] + nxt[1]) {
                    dist[nxt[0]] = cur[1] + nxt[1];
                    pq.offer(new int[]{nxt[0], dist[nxt[0]]});
                }
            }
        }
        return dist;
    }
}
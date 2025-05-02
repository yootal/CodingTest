import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<int[]>[] graph;
    static long[] height;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        height = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            height[i] = Long.parseLong(st.nextToken());
        }
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, n});
            graph[b].add(new int[]{a, n});
        }
        long[] dist1 = new long[N + 1];
        Arrays.fill(dist1, Long.MAX_VALUE);
        dijkstra(dist1, 1);
        long[] dist2 = new long[N + 1];
        Arrays.fill(dist2, Long.MAX_VALUE);
        dijkstra(dist2, N);
        long ans = -Long.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            if (dist1[i] != Long.MAX_VALUE && dist2[i] != Long.MAX_VALUE) {
                ans = Math.max(ans, height[i] * E - (dist1[i] + dist2[i]) * D);
            }
        }
        System.out.println(ans != -Long.MAX_VALUE ? ans : "Impossible");
    }

    static void dijkstra(long[] dist, int start) {
        dist[start] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o[1]));
        pq.offer(new long[]{start, 0});
        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            if (dist[(int) cur[0]] != cur[1]) continue;
            for (int[] nxt : graph[(int) cur[0]]) {
                if (dist[nxt[0]] > cur[1] + nxt[1] && height[nxt[0]] > height[(int) cur[0]]) {
                    dist[nxt[0]] = cur[1] + nxt[1];
                    pq.offer(new long[]{nxt[0], dist[nxt[0]]});
                }
            }
        }
    }
}

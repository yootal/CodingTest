import java.io.*;
import java.util.*;

public class Main {
    static int N, M, X;
    static ArrayList<int[]>[] graph, graphReverse;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        graphReverse = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            graphReverse[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            graph[s].add(new int[]{e, t});
            graphReverse[e].add(new int[]{s, t});
        }
        int[] dist = dijkstra(X, graph);
        int[] dist2 = dijkstra(X, graphReverse);
        int[] round = new int[N + 1];
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            round[i] = dist[i] + dist2[i];
            ans = Math.max(ans, round[i]);
        }
        System.out.println(ans);
    }

    static int[] dijkstra(int s, ArrayList<int[]>[] graph) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[1]));
        pq.offer(new int[]{s, dist[s]});
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
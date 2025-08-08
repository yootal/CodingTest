import java.io.*;
import java.util.*;

public class Main {
    static int N, M, X;
    static ArrayList<int[]>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            graph[s].add(new int[]{e, t});
        }
        int[] round = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int[] dist = dijkstra(i);
            if (i == X) {
                for (int j = 1; j <= N; j++) {
                    round[j] += dist[j];
                }
            } else {
                round[i] += dist[X];
            }
        }
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, round[i]);
        }
        System.out.println(ans);
    }

    static int[] dijkstra(int s) {
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
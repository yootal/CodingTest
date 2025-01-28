import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<int[]>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c});
        }
        int ans = -1;
        int s = 0, e = 1000000;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (dijkstra(mid, N, K)) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        System.out.println(ans);
    }

    static boolean dijkstra(int limit, int N, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.offer(new int[]{1, 0});
        dist[1] = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (dist[cur[0]] < cur[1]) continue;
            for (int[] nxt : graph[cur[0]]) {
                int nxtDist = cur[1];
                if (nxt[1] > limit) {
                    nxtDist++;
                }
                if (nxtDist < dist[nxt[0]]) {
                    dist[nxt[0]] = nxtDist;
                    pq.add(new int[]{nxt[0], nxtDist});
                }
            }
        }
        return dist[N] <= K;
    }
}
import java.io.*;
import java.util.*;

public class Main {
    static class Info {
        int idx;
        long value;

        public Info(int idx, long value) {
            this.idx = idx;
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] check = new int[N];
        for (int i = 0; i < N; i++) {
            check[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<int[]>[] graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            if ((check[a] != 1 && check[b] != 1) || ((a == N - 1 && check[b] == 0) || (b == N - 1 && check[a] == 0))) {
                graph[a].add(new int[]{b, t});
                graph[b].add(new int[]{a, t});
            }
        }
        long[] dist = new long[N];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o.value));
        pq.offer(new Info(0, dist[0]));
        while (!pq.isEmpty()) {
            Info cur = pq.poll();
            if (dist[cur.idx] != cur.value) continue;
            for (int[] nxt : graph[cur.idx]) {
                if (dist[nxt[0]] > cur.value + nxt[1]) {
                    dist[nxt[0]] = cur.value + nxt[1];
                    pq.offer(new Info(nxt[0], dist[nxt[0]]));
                }
            }
        }
        System.out.println(dist[N - 1] == Long.MAX_VALUE ? -1 : dist[N - 1]);
    }
}
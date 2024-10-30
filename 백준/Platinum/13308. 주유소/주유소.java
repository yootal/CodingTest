import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<int[]>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] price = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }
        long[][] dist = new long[N + 1][2501];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], (long) 1e15);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c});
        }
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o[1]));
        dist[1][price[1]] = 0;
        pq.offer(new long[]{1, dist[1][price[1]], price[1]});
        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            if (cur[1] != dist[(int) cur[0]][(int) cur[2]]) continue;
            for (int[] nxt : graph[(int) cur[0]]) {
                long nxtTotal = cur[1] + nxt[1] * cur[2];
                int minCost = (int) Math.min(cur[2], price[nxt[0]]);
                if (dist[nxt[0]][minCost] > nxtTotal) {
                    dist[nxt[0]][minCost] = nxtTotal;
                    pq.offer(new long[]{nxt[0], nxtTotal, minCost});
                }
            }
        }
        long ans = (long) 1e15;
        for (int i = 1; i <= 2500; i++) {
            ans = Math.min(ans, dist[N][i]);
        }
        System.out.println(ans);
    }
}
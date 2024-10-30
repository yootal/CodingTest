import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] dist = new int[M + 1][N + 1];
            for (int j = 1; j <= M; j++) {
                Arrays.fill(dist[j], (int) 1e9);
            }
            ArrayList<int[]>[] graph = new ArrayList[N + 1];
            for (int j = 1; j <= N; j++) {
                graph[j] = new ArrayList<>();
            }
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                graph[u].add(new int[]{v, d, c});
            }
            for (int j = 1; j <= N; j++) {
                graph[j].sort(Comparator.comparingInt(o -> o[1]));
            }
            dist[0][1] = 0;
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
            pq.offer(new int[]{1, dist[0][1], 0});
            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                if (dist[cur[2]][cur[0]] != cur[1]) continue;
                for (int[] nxt : graph[cur[0]]) {
                    int nxtCost = cur[2] + nxt[2];
                    int nxtTime = cur[1] + nxt[1];
                    if (nxtCost <= M && nxtTime < dist[nxtCost][nxt[0]]) {
                        for (int j = nxtCost + 1; j <= M; j++) {
                            if (dist[j][nxt[0]] <= nxtTime)
                                break;
                            dist[j][nxt[0]] = nxtTime;
                        }
                        dist[nxtCost][nxt[0]] = nxtTime;
                        pq.offer(new int[]{nxt[0], nxtTime, nxtCost});
                    }
                }
            }
            int ans = Integer.MAX_VALUE;
            for (int j = 1; j <= M; j++) {
                ans = Math.min(ans, dist[j][N]);
            }
            sb.append(ans == (int) 1e9 ? "Poor KCM" : ans).append("\n");
        }
        System.out.println(sb);
    }
}
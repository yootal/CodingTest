import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<int[]>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int h1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            graph[h1].add(new int[]{h2, k});
            graph[h2].add(new int[]{h1, k});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> -o[1]));
        boolean[] vis = new boolean[N + 1];
        pq.offer(new int[]{s, 1000001});
        int ans = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (vis[cur[0]]) continue;
            vis[cur[0]] = true;
            if (cur[0] == e) {
                ans = cur[1];
                break;
            }
            for (int[] nxt : graph[cur[0]]) {
                if (!vis[nxt[0]]) {
                    pq.offer(new int[]{nxt[0], Math.min(cur[1], nxt[1])});
                }
            }
        }
        System.out.println(ans);
    }
}
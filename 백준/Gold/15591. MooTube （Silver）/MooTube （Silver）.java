import java.io.*;
import java.util.*;

public class Main {

    static int N, Q;
    static ArrayList<int[]>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            graph[p].add(new int[]{q, r});
            graph[q].add(new int[]{p, r});
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            sb.append(bfs(k, v)).append("\n");
        }
        System.out.println(sb);
    }

    static int bfs(int k, int v) {
        boolean[] vis = new boolean[N + 1];
        int[] dist = new int[N + 1];
        vis[v] = true;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{v, Integer.MAX_VALUE});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] nxt : graph[cur[0]]) {
                if (!vis[nxt[0]]) {
                    vis[nxt[0]] = true;
                    dist[nxt[0]] = Math.min(cur[1], nxt[1]);
                    q.offer(new int[]{nxt[0], dist[nxt[0]]});
                }
            }
        }
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] >= k) cnt++;
        }
        return cnt;
    }
}

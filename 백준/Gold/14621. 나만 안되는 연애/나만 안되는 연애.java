import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[] sex = new char[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sex[i] = st.nextToken().charAt(0);
        }
        ArrayList<int[]>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if (sex[u - 1] == sex[v - 1]) continue;
            graph[u].add(new int[]{v, d});
            graph[v].add(new int[]{u, d});
        }
        boolean[] vis = new boolean[N + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int cnt = 0;
        int dist = 0;
        pq.offer(new int[]{1, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (vis[cur[0]]) continue;
            vis[cur[0]] = true;
            cnt++;
            dist += cur[1];
            for (int[] nxt : graph[cur[0]]) {
                if (!vis[nxt[0]] && sex[cur[0] - 1] != sex[nxt[0] - 1]) {
                    pq.offer(nxt);
                }
            }
        }
        System.out.println(cnt == N ? dist : -1);
    }
}
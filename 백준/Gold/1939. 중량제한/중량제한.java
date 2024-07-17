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
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c});
        }
        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> -o[1]));
        int[] weight = new int[N + 1];
        weight[from] = 1000000000;
        pq.offer(new int[]{from, weight[from]});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[1] != weight[cur[0]]) continue;
            if (cur[0] == to) break;
            for (int[] nxt : graph[cur[0]]) {
                int d = Math.min(cur[1], nxt[1]);
                if (weight[nxt[0]] < d) {
                    weight[nxt[0]] = d;
                    pq.offer(new int[]{nxt[0], weight[nxt[0]]});
                }
            }
        }
        System.out.println(weight[to]);
    }
}
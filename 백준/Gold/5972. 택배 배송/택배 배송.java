import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<int[]>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            graph[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c});
        }
        int[] dist = new int[N + 1];
        Arrays.fill(dist, 50000000);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{1, 0});
        dist[1] = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (dist[cur[0]] < cur[1]) continue;
            for (int[] edge : graph[cur[0]]) {
                if (dist[edge[0]] > cur[1] + edge[1]) {
                    dist[edge[0]] = cur[1] + edge[1];
                    pq.add(new int[]{edge[0], dist[edge[0]]});
                }
            }
        }
        System.out.println(dist[N]);
    }
}
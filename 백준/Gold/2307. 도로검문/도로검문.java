import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] pre;
    static int[][] graph;
    static ArrayList<int[]> edge;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(graph[i], 10000001);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            graph[x][y] = z;
            graph[y][x] = z;
        }
        int minDist = dijkstra();
        edge = new ArrayList<>();
        int end = N;
        while (end != 1) {
            int start = pre[end];
            edge.add(new int[]{start, end});
            end = start;
        }
        int ans = 0;
        for (int[] temp : edge) {
            int tempDist = graph[temp[0]][temp[1]];
            graph[temp[0]][temp[1]] = 10000001;
            graph[temp[1]][temp[0]] = 10000001;
            ans = Math.max(ans, dijkstra());
            graph[temp[0]][temp[1]] = tempDist;
            graph[temp[1]][temp[0]] = tempDist;
        }
        System.out.println(ans == 10000001 ? -1 : ans - minDist);
    }

    static int dijkstra() {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, 10000001);
        pre = new int[N + 1];
        dist[1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.offer(new int[]{1, dist[1]});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[1] != dist[cur[0]]) continue;
            for (int nxt = 1; nxt <= N; nxt++) {
                if (cur[0] == nxt) continue;
                if (dist[nxt] > cur[1] + graph[cur[0]][nxt]) {
                    pre[nxt] = cur[0];
                    dist[nxt] = cur[1] + graph[cur[0]][nxt];
                    pq.offer(new int[]{nxt, dist[nxt]});
                }
            }
        }
        return dist[N];
    }
}
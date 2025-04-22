import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static ArrayList<Integer>[] graph;
    static boolean[] vis;
    static boolean[] cycle;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        vis = new boolean[N + 1];
        cycle = new boolean[N + 1];
        dist = new int[N + 1];
        dfs(1, 0);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(dist[i]).append(" ");
        }
        System.out.print(sb);
    }

    static boolean dfs(int pos, int pre) {
        vis[pos] = true;
        boolean flag = false;
        for (int nxt : graph[pos]) {
            if (nxt != pre) {
                if (vis[nxt]) {
                    cycle[pos] = true;
                    cycle[nxt] = true;
                    return true;
                } else {
                    boolean check = dfs(nxt, pos);
                    if (check) flag = true;
                    if (cycle[pos]) {
                        bfs(pos);
                        return false;
                    }
                }
            }
        }
        return cycle[pos] = flag;
    }

    static void bfs(int pos) {
        Arrays.fill(dist, -1);
        dist[pos] = 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{pos, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int nxt : graph[cur[0]]) {
                if (dist[nxt] == -1) {
                    if (cycle[nxt]) {
                        dist[nxt] = 0;
                        q.offer(new int[]{nxt, dist[nxt]});
                    } else {
                        dist[nxt] = cur[1] + 1;
                        q.offer(new int[]{nxt, dist[nxt]});
                    }
                }
            }
        }
    }
}

import java.util.*;
import java.io.*;

public class Main {

    static int N, A, B;
    static ArrayList<int[]>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        if (A == B) {
            System.out.println(0);
        } else {

            graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[a].add(new int[]{b, v});
                graph[b].add(new int[]{a, v});
            }
            int[][] vis = new int[N + 1][2];
            for (int i = 0; i <= N; i++) {
                Arrays.fill(vis[i], 100000001);
            }
            vis[A][0] = 0;
            vis[B][1] = 0;
            ArrayDeque<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{A, 0, 0});
            q.offer(new int[]{B, 0, 1});
            int ans = Integer.MAX_VALUE;
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                for (int[] nxt : graph[cur[0]]) {
                    ans = Math.min(ans, cur[1] + vis[nxt[0]][(cur[2] + 1) % 2]);
                    if (vis[nxt[0]][cur[2]] > cur[1] + nxt[1]) {
                        vis[nxt[0]][cur[2]] = cur[1] + nxt[1];
                        q.offer(new int[]{nxt[0], cur[1] + nxt[1], cur[2]});
                    }
                }
            }
            System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
        }
    }
}
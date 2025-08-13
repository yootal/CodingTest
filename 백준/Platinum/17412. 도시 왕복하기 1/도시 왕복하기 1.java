import java.util.*;
import java.io.*;

public class Main {
    static int N, P;
    static int[][] capacity, flow;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        capacity = new int[N + 1][N + 1];
        flow = new int[N + 1][N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            capacity[s][e] = 1;
            graph[s].add(e);
            graph[e].add(s);
        }
        System.out.println(edmondsKarp());
    }

    static int edmondsKarp() {
        int cnt = 0;
        while (true) {
            ArrayDeque<Integer> q = new ArrayDeque<>();
            q.offer(1);
            int[] prev = new int[N + 1];
            Arrays.fill(prev, -1);
            prev[1] = 0;
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int nxt : graph[cur]) {
                    if (capacity[cur][nxt] - flow[cur][nxt] > 0 && prev[nxt] == -1) {
                        prev[nxt] = cur;
                        q.offer(nxt);
                        if (nxt == 2) {
                            q.clear();
                            break;
                        }
                    }
                }
            }
            if (prev[2] == -1) break;
            int add = Integer.MAX_VALUE, v = 2;
            while (v != 1) {
                add = Math.min(add, capacity[prev[v]][v] - flow[prev[v]][v]);
                v = prev[v];
            }
            v = 2;
            while (v != 1) {
                flow[prev[v]][v] += add;
                flow[v][prev[v]] -= add;
                v = prev[v];
            }
            cnt += add;
        }
        return cnt;
    }
}
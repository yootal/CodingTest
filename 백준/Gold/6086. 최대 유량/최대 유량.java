import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] capacity, flow;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        capacity = new int[52][52];
        flow = new int[52][52];
        graph = new ArrayList[52];
        for (int i = 0; i < 52; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = id(st.nextToken().charAt(0));
            int e = id(st.nextToken().charAt(0));
            int size = Integer.parseInt(st.nextToken());
            capacity[s][e] += size;
            capacity[e][s] += size;
            graph[s].add(e);
            graph[e].add(s);
        }
        System.out.println(edmondsKarp());
    }

    static int edmondsKarp() {
        int cnt = 0;
        while (true) {
            ArrayDeque<Integer> q = new ArrayDeque<>();
            q.offer(0);
            int[] prev = new int[52];
            Arrays.fill(prev, -1);
            prev[0] = 0;
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int nxt : graph[cur]) {
                    if (capacity[cur][nxt] - flow[cur][nxt] > 0 && prev[nxt] == -1) {
                        prev[nxt] = cur;
                        q.offer(nxt);
                        if (nxt == 25) {
                            q.clear();
                            break;
                        }
                    }
                }
            }
            if (prev[25] == -1) break;
            int add = Integer.MAX_VALUE, v = 25;
            while (v != 0) {
                add = Math.min(add, capacity[prev[v]][v] - flow[prev[v]][v]);
                v = prev[v];
            }
            v = 25;
            while (v != 0) {
                flow[prev[v]][v] += add;
                flow[v][prev[v]] -= add;
                v = prev[v];
            }
            cnt += add;
        }
        return cnt;
    }

    static int id(char c) {
        if ('A' <= c && c <= 'Z') return c - 'A';
        else return c - 'a' + 26;
    }
}
import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static ArrayDeque<Integer> stack;
    static boolean[] vis, indegree;
    static int[] id, scc;
    static int idx, sccIdx;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }
            stack = new ArrayDeque<>();
            vis = new boolean[N + 1];
            id = new int[N + 1];
            scc = new int[N + 1];
            idx = 0;
            sccIdx = 0;
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[x].add(y);
            }
            for (int i = 1; i <= N; i++) {
                if (id[i] == 0) dfs(i);
            }
            /* 위상정렬 응용 */
            indegree = new boolean[sccIdx];
            for (int i = 1; i <= N; i++) {
                for (int j = 0; j < graph[i].size(); j++) {
                    int cur = graph[i].get(j);
                    if (scc[i] != scc[cur]) {
                        indegree[scc[cur]] = true;
                    }
                }
            }
            int ans = 0;
            for (int i = 0; i < sccIdx; i++) {
                if (!indegree[i]) {
                    ans++;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    static int dfs(int x) {
        id[x] = ++idx;
        stack.push(x);
        int root = id[x];
        for (int nxt : graph[x]) {
            if (id[nxt] == 0) {
                root = Math.min(root, dfs(nxt));
            } else if (!vis[nxt]) {
                root = Math.min(root, id[nxt]);
            }
        }
        if (root == id[x]) {
            while (!stack.isEmpty()) {
                int cur = stack.pop();
                vis[cur] = true;
                scc[cur] = sccIdx;
                if (cur == x) break;
            }
            sccIdx++;
        }
        return root;
    }
}
import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static ArrayDeque<Integer> stack;
    static boolean[] vis;
    static int[] id, sccId;
    static int idx, sccIdx;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N];
        stack = new ArrayDeque<>();
        vis = new boolean[N];
        id = new int[N];
        sccId = new int[N];
        sccIdx = 0;
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }
        for (int i = 0; i < N; i++) {
            if (id[i] == 0) dfs(i);
        }
        int[] inDegree = new int[sccIdx];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                int cur = graph[i].get(j);
                if (sccId[i] != sccId[cur]) {
                    inDegree[sccId[cur]]++;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < sccIdx; i++) {
            if (inDegree[i] == 0) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    static int dfs(int x) {
        id[x] = ++idx;
        stack.push(x);
        int result = id[x];
        for (int nxt : graph[x]) {
            if (id[nxt] == 0) {
                result = Math.min(result, dfs(nxt));
            } else if (!vis[nxt]) {
                result = Math.min(result, id[nxt]);
            }
        }
        if (result == id[x]) {
            while (!stack.isEmpty()) {
                int cur = stack.pop();
                vis[cur] = true;
                sccId[cur] = sccIdx;
                if (cur == x) break;
            }
            sccIdx++;
        }
        return result;
    }
}
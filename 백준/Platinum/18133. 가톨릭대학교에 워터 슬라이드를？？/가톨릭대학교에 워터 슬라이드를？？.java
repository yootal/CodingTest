import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static ArrayDeque<Integer> stack;
    static boolean[] vis;
    static int[] id, sccId;
    static int idx, sccIdx;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        idx = 0;
        sccIdx = 0;
        id = new int[N + 1];
        sccId = new int[N + 1];
        vis = new boolean[N + 1];
        graph = new ArrayList[N + 1];
        stack = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }
        for (int i = 1; i <= N; i++) {
            if (id[i] == 0) dfs(i);
        }
        int[] inDegree = new int[sccIdx];
        for (int i = 1; i <= N; i++) {
            for (int nxt : graph[i]) {
                if (sccId[i] != sccId[nxt]) {
                    inDegree[sccId[nxt]]++;
                }
            }
        }
        int cnt = 0;
        for (int v : inDegree) {
            if (v == 0) cnt++;
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
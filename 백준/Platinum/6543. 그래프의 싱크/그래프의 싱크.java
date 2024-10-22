import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<ArrayList<Integer>> SCC;
    static ArrayList<Integer>[] graph;
    static ArrayDeque<Integer> stack;
    static boolean[] vis;
    static int[] id, sccId;
    static int idx, sccIdx;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) break;
            int M = Integer.parseInt(st.nextToken());

            // 초기화
            idx = 0;
            sccIdx = 0;
            id = new int[N + 1];
            sccId = new int[N + 1];
            vis = new boolean[N + 1];
            graph = new ArrayList[N + 1];
            stack = new ArrayDeque<>();
            SCC = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
            }

            // SCC 만들기
            for (int i = 1; i <= N; i++) {
                if (id[i] == 0) dfs(i);
            }

            // 나가는 수 기록
            int[] outDegree = new int[sccIdx];
            for (int i = 1; i <= N; i++) {
                for (int nxt : graph[i]) {
                    if (sccId[i] != sccId[nxt]) {
                        outDegree[sccId[i]]++;
                    }
                }
            }

            ArrayList<Integer> ans = new ArrayList<>();
            for (int i = 0; i < sccIdx; i++) {
                if (outDegree[i] == 0) {
                    ans.addAll(SCC.get(i));
                }
            }

            Collections.sort(ans);
            for (int v : ans) {
                sb.append(v).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
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
            ArrayList<Integer> al = new ArrayList<>();
            while (!stack.isEmpty()) {
                int cur = stack.pop();
                vis[cur] = true;
                sccId[cur] = sccIdx;
                al.add(cur);
                if (cur == x) break;
            }
            sccIdx++;
            SCC.add(al);
        }
        return result;
    }
}
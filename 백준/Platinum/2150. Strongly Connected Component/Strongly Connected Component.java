import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> SCC;
    static ArrayList<Integer>[] graph;
    static ArrayDeque<Integer> stack;
    static boolean[] vis;
    static int[] id;
    static int idx;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        graph = new ArrayList[V + 1];
        stack = new ArrayDeque<>();
        vis = new boolean[V + 1];
        id = new int[V + 1];
        SCC = new ArrayList<>();
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }
        for (int i = 1; i <= V; i++) {
            if (id[i] == 0) dfs(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SCC.size()).append('\n');
        Collections.sort(SCC,Comparator.comparing(scc -> scc.get(0)));
        for(ArrayList<Integer> scc : SCC) {
            for(Integer x : scc) {
                sb.append(x).append(" ");
            }
            sb.append(-1).append("\n");
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
                al.add(cur);
                vis[cur] = true;
                if (cur == x) break;
            }
            Collections.sort(al);
            SCC.add(al);
        }
        return result;
    }
}
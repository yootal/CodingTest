import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> SCC;
    static ArrayList<Integer>[] graph;
    static ArrayDeque<Integer> stack;
    static boolean[] vis;
    static int[] id, cost;
    static int idx;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        cost = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < N; j++) {
                if (row.charAt(j) == '1') graph[i].add(j);
            }
        }
        stack = new ArrayDeque<>();
        vis = new boolean[N + 1];
        id = new int[N + 1];
        Arrays.fill(id, -1);
        SCC = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (id[i] == -1) dfs(i);
        }
        int total = 0;
        for (ArrayList<Integer> scc : SCC) {
            int c = Integer.MAX_VALUE;
            for (Integer i : scc) {
                c = Math.min(c, cost[i]);
            }
            total += c;
        }
        System.out.println(total);
    }

    static int dfs(int x) {
        id[x] = ++idx;
        stack.push(x);
        int result = id[x];
        for (int nxt : graph[x]) {
            if (id[nxt] == -1) {
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
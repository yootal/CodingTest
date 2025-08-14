import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static int[] match;
    static boolean[] vis;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }
        match = new int[N + 1];
        Arrays.fill(match, -1);
        System.out.println(solve());
    }

    static int solve() {
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            vis = new boolean[N + 1];
            if (dfs(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    static boolean dfs(int idx) {
        for (int nxt : graph[idx]) {
            if (vis[nxt]) continue;
            vis[nxt] = true;
            if (match[nxt] == -1 || dfs(match[nxt])) {
                match[nxt] = idx;
                return true;
            }
        }
        return false;
    }
}
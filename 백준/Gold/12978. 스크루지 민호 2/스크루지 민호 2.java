import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] dp;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) graph[i] = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        dp = new int[N + 1][2];
        System.out.println(Math.min(solve(1, 0, 1) + 1, solve(1, 0, 0)));
    }

    static int solve(int idx, int pre, int flag) {
        if (dp[idx][flag] != 0) return dp[idx][flag];
        int value = 0;
        for (int nxt : graph[idx]) {
            if (nxt == pre) continue;
            if (flag == 0) {
                value += solve(nxt, idx, 1) + 1;
            } else {
                value += Math.min(solve(nxt, idx, 0), solve(nxt, idx, 1) + 1);
            }
        }
        return dp[idx][flag] = value;
    }
}
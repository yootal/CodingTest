import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        dp = new int[N + 1][2];
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        System.out.println(Math.min(solve(1, 0, 0), solve(1, 0, 1) + 1));
    }

    static int solve(int x, int pre, int flag) {
        if (dp[x][flag] != 0) return dp[x][flag];
        int value = 0;
        for (int nxt : graph[x]) {
            if (nxt != pre) {
                if (flag == 0) {
                    value += solve(nxt, x, 1) + 1;
                } else {
                    value += Math.min(solve(nxt, x, 0), solve(nxt, x, 1) + 1);
                }
            }
        }
        dp[x][flag] = value;
        return dp[x][flag];
    }
}
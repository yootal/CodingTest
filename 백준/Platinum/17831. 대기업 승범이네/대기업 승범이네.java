import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] value, vis;
    static int[][] dp;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= N; i++) {
            int from = Integer.parseInt(st.nextToken());
            graph[from].add(i);
        }
        st = new StringTokenizer(br.readLine());
        value = new int[N + 1];
        for (int i = 1; i <= N; i++) value[i] = Integer.parseInt(st.nextToken());
        vis = new int[N + 1];
        dp = new int[N + 1][2];
        for (int[] row : dp) Arrays.fill(row, -1);
        System.out.println(Math.max(solve(1, 0), solve(1, 1)));
    }

    static int solve(int idx, int flag) {
        if (dp[idx][flag] != -1) return dp[idx][flag];
        int sum = 0;
        if (flag == 0) {
            for (int nxt : graph[idx]) {
                sum += Math.max(solve(nxt, 0), solve(nxt, 1));
            }
        } else {
            int temp = 0;
            for (int nxt : graph[idx]) {
                int case1 = solve(nxt, 0);
                int case2 = solve(nxt, 1);
                if (case1 > case2) {
                    temp += case1;
                    vis[nxt] = 0;
                } else {
                    temp += case2;
                    vis[nxt] = 1;
                }
            }
            for (int nxt : graph[idx]) {
                int ex_sum = temp - solve(nxt, vis[nxt]) + solve(nxt, 0) + value[idx] * value[nxt];
                sum = Math.max(sum, ex_sum);
            }
        }
        return dp[idx][flag] = sum;
    }
}


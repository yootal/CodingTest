import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] info;
    static int[][] dp;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        info = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            info[i] = Integer.parseInt(st.nextToken());
        }
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        dp = new int[N + 1][2];
        solve(1, 0);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    static void solve(int idx, int pre) {
        dp[idx][0] = 0;
        dp[idx][1] = info[idx];
        for (int nxt : graph[idx]) {
            if (nxt != pre) {
                solve(nxt, idx);
                dp[idx][0] += Math.max(dp[nxt][0], dp[nxt][1]);
                dp[idx][1] += dp[nxt][0];
            }
        }
    }
}
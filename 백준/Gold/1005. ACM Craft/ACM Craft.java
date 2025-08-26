import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] time, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            time = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }
            dp = new int[N + 1];
            Arrays.fill(dp, -1);
            graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                graph[Y].add(X);
            }
            int W = Integer.parseInt(br.readLine());
            sb.append(solve(W)).append("\n");
        }
        System.out.print(sb);
    }

    static int solve(int idx) {
        if (dp[idx] != -1) return dp[idx];
        int value = time[idx];
        for (int nxt : graph[idx]) {
            value = Math.max(value, solve(nxt) + time[idx]);
        }
        return dp[idx] = value;
    }
}
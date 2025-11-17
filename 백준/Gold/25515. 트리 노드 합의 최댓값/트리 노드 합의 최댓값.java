import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[] value, dp;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        st = new StringTokenizer(br.readLine());
        value = new long[N];
        for (int i = 0; i < N; i++) {
            value[i] = Long.parseLong(st.nextToken());
        }
        dp = new long[N];
        Arrays.fill(dp, -1);
        System.out.println(solve(0, -1));
    }

    static long solve(int idx, int pre) {
        if (dp[idx] != -1) return dp[idx];
        dp[idx] = value[idx];
        for (int nxt : graph[idx]) {
            if (nxt == pre) continue;
            dp[idx] = Math.max(dp[idx] + solve(nxt, idx), dp[idx]);
        }
        return dp[idx];
    }
}


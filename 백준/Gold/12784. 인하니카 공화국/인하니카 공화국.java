import java.util.*;
import java.io.*;

public class Main {
    static int T, N, M;
    static ArrayList<int[]>[] graph;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
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
                int c = Integer.parseInt(st.nextToken());
                graph[a].add(new int[]{b, c});
                graph[b].add(new int[]{a, c});
            }
            dp = new int[N + 1];
            int ans = solve(1, 0, Integer.MAX_VALUE);
            sb.append(ans == Integer.MAX_VALUE ? 0 : ans).append("\n");
        }
        System.out.print(sb);
    }

    static int solve(int cur, int pre, int cutValue) {
        if (dp[cur] != 0) return dp[cur];
        dp[cur] = cutValue;
        int temp = 0;
        for (int[] nxt : graph[cur]) {
            if (nxt[0] != pre) {
                temp += solve(nxt[0], cur, nxt[1]);
            }
        }
        if (temp != 0) {
            dp[cur] = Math.min(dp[cur], temp);
        }
        return dp[cur];
    }
}
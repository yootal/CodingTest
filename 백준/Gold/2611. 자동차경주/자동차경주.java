import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] pre, dp;
    static ArrayList<int[]>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            graph[q].add(new int[]{p, r});
        }
        dp = new int[N + 1];
        pre = new int[N + 1];
        Arrays.fill(dp, -1);
        System.out.println(solve(1));
        int idx = 1;
        sb.append(" ").append(1);
        while (pre[idx] != 1) {
            sb.insert(0, " " + pre[idx]);
            idx = pre[idx];
        }
        sb.insert(0, 1);
        System.out.println(sb);
    }

    static int solve(int idx) {
        if (dp[idx] != -1) return dp[idx];
        int value = 0;
        for (int[] nxt : graph[idx]) {
            int temp = nxt[0] == 1 ? nxt[1] : solve(nxt[0]) + nxt[1];
            if (value < temp) {
                value = temp;
                pre[idx] = nxt[0];
            }
        }
        return dp[idx] = value;
    }
}
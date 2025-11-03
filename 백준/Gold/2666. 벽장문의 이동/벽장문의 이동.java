import java.io.*;
import java.util.*;

public class Main {
    static int m;
    static int[] info;
    static int[][][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        info = new int[m];
        for (int i = 0; i < m; i++) {
            info[i] = Integer.parseInt(br.readLine());
        }
        dp = new int[n + 1][n + 1][m + 1];
        System.out.println(solve(a, b, 0));
    }

    static int solve(int a, int b, int idx) {
        if (idx == m) return 0;
        if (dp[a][b][idx] != 0) return dp[a][b][idx];
        int v1 = Math.abs(info[idx] - a) + solve(info[idx], b, idx + 1);
        int v2 = Math.abs(info[idx] - b) + solve(a, info[idx], idx + 1);
        dp[a][b][idx] = Math.min(v1, v2);
        return dp[a][b][idx];
    }
}
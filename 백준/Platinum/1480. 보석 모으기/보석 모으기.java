import java.io.*;
import java.util.*;

public class Main {

    static int N, M, C;
    static int[] weight;
    static int[][][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        weight = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N][M][1 << N];
        System.out.println(solve(0, 0, 0, 0));
    }

    static int solve(int flag, int cur, int bag, int curWeight) {
        if (dp[cur][bag][flag] != 0) return dp[cur][bag][flag];
        for (int j = 0; j < N; j++) {
            if ((flag & (1 << j)) == 0) {
                if (curWeight + weight[j] <= C) {
                    dp[cur][bag][flag] = Math.max(dp[cur][bag][flag], solve(flag | (1 << j), j, bag, curWeight + weight[j]) + 1);
                } else if (bag + 1 < M && weight[j] <= C) {
                    dp[cur][bag][flag] = Math.max(dp[cur][bag][flag], solve(flag | (1 << j), j, bag + 1, weight[j]) + 1);
                }
            }
        }
        return dp[cur][bag][flag];
    }
}

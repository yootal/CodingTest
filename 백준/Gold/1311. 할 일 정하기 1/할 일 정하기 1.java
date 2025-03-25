import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] cost, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        cost = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[1 << N][N];
        System.out.println(solve(0, 0));
    }

    static int solve(int flag, int idx) {
        if (flag == ((1 << N) - 1)) {
            return 0;
        }
        if (dp[flag][idx] != 0)
            return dp[flag][idx];
        int temp = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if (((1 << i) & flag) == 0) {
                temp = Math.min(temp, solve(flag | (1 << i), idx + 1) + cost[idx][i]);
            }
        }
        dp[flag][idx] = temp;
        return dp[flag][idx];
    }
}

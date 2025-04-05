import java.io.*;

public class Main {

    static int N;
    static int[][] cost, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cost = new int[N][N];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < N; j++) {
                cost[i][j] = row.charAt(j) - '0';
            }
        }
        dp = new int[N][1 << N];
        System.out.println(solve(1, 0, 0) + 1);
    }

    static int solve(int flag, int i, int pre) {
        if (dp[i][flag] != 0) return dp[i][flag];
        for (int j = 1; j < N; j++) {
            if ((flag & (1 << j)) == 0 && pre <= cost[i][j]) {
                dp[i][flag] = Math.max(dp[i][flag], solve(flag | (1 << j), j, cost[i][j]) + 1);
            }
        }
        return dp[i][flag];
    }
}

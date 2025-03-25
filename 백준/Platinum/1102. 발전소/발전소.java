import java.io.*;
import java.util.*;

public class Main {

    static int N, P;
    static int[][] cost;
    static int[] dp;

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
        String check = br.readLine();
        P = Integer.parseInt(br.readLine());
        int flag = 0;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (check.charAt(i) == 'Y') {
                flag |= (1 << i);
                cnt++;
            }
        }
        dp = new int[1 << N];
        Arrays.fill(dp, -1);
        int ans = solve(flag, cnt);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static int solve(int flag, int cnt) {
        if (cnt >= P) return 0;
        if (dp[flag] != -1) return dp[flag];
        dp[flag] = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if ((flag & (1 << i)) != 0) {
                for (int j = 0; j < N; j++) {
                    if ((flag & (1 << j)) == 0) {
                        dp[flag] = Math.min(dp[flag], solve(flag | (1 << j), cnt + 1) + cost[i][j]);
                    }
                }
            }
        }
        return dp[flag];
    }
}

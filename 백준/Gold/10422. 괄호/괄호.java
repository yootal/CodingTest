import java.io.*;

public class Main {
    static final int M = 1000000007;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[5001];
        dp[0] = 1;
        dp[2] = 1;
        for (int i = 4; i <= 5000; i += 2) {
            for (int j = 0; j < i; j += 2) {
                dp[i] += dp[j] * dp[i - j - 2];
                dp[i] %= M;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            int L = Integer.parseInt(br.readLine());
            sb.append(dp[L]).append("\n");
        }
        System.out.print(sb);
    }
}
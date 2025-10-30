import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[][] dp = new long[31][31];
        for (int i = 1; i <= 30; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= 30; i++) {
            for (int j = 0; j < 30; j++) {
                if (j == 0) dp[i][j] = dp[i - 1][j + 1];
                else dp[i][j] = dp[i][j - 1] + dp[i - 1][j + 1];
            }
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            sb.append(dp[n][0]).append('\n');
        }
        System.out.print(sb);
    }
}
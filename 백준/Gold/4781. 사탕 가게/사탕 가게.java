import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            double m = Double.parseDouble(st.nextToken());
            if (n == 0 && m == 0.00) break;
            int[][] info = new int[n][2];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                double p = Double.parseDouble(st.nextToken());
                info[i][0] = c;
                info[i][1] = (int) (p * 100 + 0.5);
            }
            int[][] dp = new int[n + 1][(int) (m * 100 + 0.5) + 1];
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= (int) (m * 100 + 0.5); j++) {
                    if (i == 0 || j == 0) continue;
                    int[] cur = info[i - 1];
                    if (j >= cur[1]) {
                        dp[i][j] = Math.max(dp[i - 1][j],
                                Math.max(dp[i - 1][j - cur[1]] + cur[0], dp[i][j - cur[1]] + cur[0]));
                    } else
                        dp[i][j] = dp[i - 1][j];
                }
            }
            sb.append(dp[n][(int) (m * 100 + 0.5)]).append("\n");
        }
        System.out.print(sb);
    }
}
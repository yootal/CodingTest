import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[][] info = new int[k][2];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[k + 1][t + 1];
        for (int i = 0; i <= k; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= k; i++) {
            int v = info[i - 1][0];
            int c = info[i - 1][1];
            for (int j = 1; j <= t; j++) {
                for (int l = 0; l <= c; l++) {
                    if (j - (v * l) < 0) break;
                    dp[i][j] += dp[i - 1][j - (v * l)];
                }
            }
        }
        System.out.println(dp[k][t]);
    }
}
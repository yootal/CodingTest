import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] num = new int[N][N];
        for (int i = 0; i < N; i++) {
            num[i][i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                num[j][i] = num[j][i - 1] + num[i][i];
            }
        }
        int[][] dp = new int[N][M + 1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -100000000);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][1] = Math.max(dp[i][1], num[j][i]);
            }
        }
        for (int k = 2; k <= M; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < i; j++) {
                    for (int r = j + 2; r <= i; r++) {
                        dp[i][k] = Math.max(dp[i][k], dp[j][k - 1] + num[r][i]);
                    }
                }
            }
        }
        int ans = -Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, dp[i][M]);
        }
        System.out.println(ans);
    }
}
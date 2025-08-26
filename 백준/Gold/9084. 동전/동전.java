import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] coin = new int[N];
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(br.readLine());
            int[][] dp = new int[N][M + 1];
            for (int i = 0; i < N; i++) {
                coin[i] = Integer.parseInt(st.nextToken());
                dp[i][0] = 1;
            }
            for (int i = 0; i < N; i++) {
                int cur = coin[i];
                for (int j = 1; j <= M; j++) {
                    if (i - 1 >= 0) {
                        dp[i][j] += dp[i - 1][j];
                    }
                    if (j - cur >= 0) {
                        dp[i][j] += dp[i][j - cur];
                    }
                }
            }
            System.out.println(dp[N - 1][M]);
        }
    }
}
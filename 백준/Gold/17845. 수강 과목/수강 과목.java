import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] info = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int I = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            info[i] = new int[]{I, T};
        }
        int[][] dp = new int[N + 1][M + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    int a = info[i - 1][0];
                    int b = info[i - 1][1];
                    if (j >= b) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - b] + a);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        System.out.println(dp[N][M]);
    }
}
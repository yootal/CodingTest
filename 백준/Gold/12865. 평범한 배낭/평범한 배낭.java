import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] info = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            int w = info[i - 1][0];
            int v = info[i - 1][1];
            for (int j = 1; j <= K; j++) {
                if (w > j)
                    dp[i][j] = dp[i - 1][j];
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
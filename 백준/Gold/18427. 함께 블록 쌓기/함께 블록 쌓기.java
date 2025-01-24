import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[][] list = new int[N + 1][M];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = 0;
            while (st.hasMoreTokens()) {
                list[i][idx++] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[N + 1][H + 1];
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= H; w++) {
                for (int j = 0; j < M; j++) {
                    if (list[i][j] == 0) {
                        break;
                    } else if (w >= list[i][j]) {
                        dp[i][w] += dp[i - 1][w - list[i][j]];
                        dp[i][w] %= 10007;
                    }
                }
                dp[i][w] += dp[i - 1][w];
                dp[i][w] %= 10007;
            }
        }
        System.out.println(dp[N][H]);
    }
}
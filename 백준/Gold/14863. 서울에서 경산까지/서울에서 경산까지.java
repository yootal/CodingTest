import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] info = new int[N][4];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
            info[i][2] = Integer.parseInt(st.nextToken());
            info[i][3] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[N + 1][K + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        for (int i = 1; i <= N; i++) {
            int[] cur = info[i - 1];
            if (i == 1) {
                int t1, v1, t2, v2;
                if (cur[0] >= cur[2]) {
                    t1 = cur[2];
                    v1 = cur[3];
                    t2 = cur[0];
                    v2 = cur[1];
                } else {
                    t1 = cur[0];
                    v1 = cur[1];
                    t2 = cur[2];
                    v2 = cur[3];
                }
                for (int j = t1; j <= K; j++)
                    dp[i][j] = v1;
                for (int j = t2; j <= K; j++)
                    dp[i][j] = Math.max(v1, v2);
            } else {
                for (int j = K; j >= 0; j--) {
                    if (j - cur[0] >= 0 && dp[i - 1][j - cur[0]] != -1)
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - cur[0]] + cur[1]);
                    if (j - cur[2] >= 0 && dp[i - 1][j - cur[2]] != -1)
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - cur[2]] + cur[3]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
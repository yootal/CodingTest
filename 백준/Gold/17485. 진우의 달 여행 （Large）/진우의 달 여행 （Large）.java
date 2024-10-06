import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][][] dp = new int[N][M][3];
        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(dp[i][j], 100001);
            }
        }
        for (int i = 0; i < M; i++) {
            Arrays.fill(dp[0][i], board[0][i]);
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j == 0) {
                    dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + board[i][j];
                    dp[i][j][1] = dp[i - 1][j][0] + board[i][j];
                } else if (j == M - 1) {
                    dp[i][j][1] = dp[i - 1][j][2] + board[i][j];
                    dp[i][j][2] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][0]) + board[i][j];
                } else {
                    dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + board[i][j];
                    dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + board[i][j];
                    dp[i][j][2] = Math.min(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]) + board[i][j];
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                ans = Math.min(ans, dp[N - 1][i][j]);
            }
        }
        System.out.println(ans);
    }
}
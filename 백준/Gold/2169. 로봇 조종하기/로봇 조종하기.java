import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[N][M];
        dp[0][0] = board[0][0];
        for (int i = 1; i < M; i++) {
            dp[0][i] = dp[0][i - 1] + board[0][i];
        }
        for (int i = 1; i < N - 1; i++) {
            int[] temp1 = new int[M];
            temp1[0] = dp[i - 1][0] + board[i][0];
            for (int j = 1; j < M; j++) {
                temp1[j] = Math.max(dp[i - 1][j], temp1[j - 1]) + board[i][j];
            }
            int[] temp2 = new int[M];
            temp2[M - 1] = dp[i - 1][M - 1] + board[i][M - 1];
            for (int j = M - 2; j >= 0; j--) {
                temp2[j] = Math.max(dp[i - 1][j], temp2[j + 1]) + board[i][j];
            }
            for (int j = 0; j < M; j++) {
                dp[i][j] = Math.max(temp1[j], temp2[j]);
            }
        }
        if (N > 1) {
            dp[N - 1][0] = dp[N - 2][0] + board[N - 1][0];
            for (int i = 1; i < M; i++) {
                dp[N - 1][i] = Math.max(dp[N - 1][i - 1], dp[N - 2][i]) + board[N - 1][i];
            }
        }
        System.out.println(dp[N - 1][M - 1]);
    }
}

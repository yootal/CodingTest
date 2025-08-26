import java.io.*;
import java.util.*;

public class Main {
    static int n, ans;
    static int[][] board, dp;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                solve(i, j);
            }
        }
        System.out.println(ans);
    }

    static int solve(int x, int y) {
        if (dp[x][y] != 0) return dp[x][y];
        dp[x][y] = 1;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] > board[x][y]) {
                dp[x][y] = Math.max(dp[x][y], solve(nx, ny) + 1);
            }
        }
        ans = Math.max(ans, dp[x][y]);
        return dp[x][y];
    }
}
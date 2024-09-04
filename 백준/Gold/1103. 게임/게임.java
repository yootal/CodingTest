import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static int N, M, ans;
    static int[][] board, dp;
    static boolean[][] vis;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        dp = new int[N][M];
        vis = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                char x = row.charAt(j);
                board[i][j] = x == 'H' ? -1 : x - '0';
            }
        }
        vis[0][0] = true;
        dfs(0, 0, 1);
        System.out.println(ans);
    }

    static void dfs(int x, int y, int cnt) {
        if (ans == -1) return;
        ans = Math.max(ans, cnt);
        int value = board[x][y];
        for (int d = 0; d < 4; d++) {
            int nx = x + value * dx[d];
            int ny = y + value * dy[d];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] != -1 && cnt + 1 > dp[nx][ny]) {
                if (vis[nx][ny]) {
                    ans = -1;
                    return;
                } else {
                    dp[nx][ny] = cnt + 1;
                    vis[nx][ny] = true;
                    dfs(nx, ny, cnt + 1);
                    vis[nx][ny] = false;
                }
            }
        }
    }
}
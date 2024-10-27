import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static char[][] board;
    static boolean[][] dp;
    static boolean[][] vis;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        dp = new boolean[N][M];
        vis = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = row.charAt(j);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                vis[i][j] = true;
                play(i, j);
                vis[i][j] = false;
            }
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dp[i][j]) cnt++;
            }
        }
        System.out.println(cnt);
    }

    static boolean play(int x, int y) {
        if (dp[x][y]) return true;
        if (board[x][y] == 'U') {
            int nx = x + dx[0];
            int ny = y + dy[0];
            if (check(x, y, nx, ny)) return false;
        } else if (board[x][y] == 'R') {
            int nx = x + dx[1];
            int ny = y + dy[1];
            if (check(x, y, nx, ny)) return false;
        } else if (board[x][y] == 'D') {
            int nx = x + dx[2];
            int ny = y + dy[2];
            if (check(x, y, nx, ny)) return false;
        } else if (board[x][y] == 'L') {
            int nx = x + dx[3];
            int ny = y + dy[3];
            if (check(x, y, nx, ny)) return false;
        }
        return dp[x][y];
    }

    static boolean check(int x, int y, int nx, int ny) {
        if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
            dp[x][y] = true;
        } else if (!vis[nx][ny]) {
            vis[nx][ny] = true;
            dp[x][y] = play(nx, ny);
            vis[nx][ny] = false;
        }
        else return true;
        return false;
    }
}
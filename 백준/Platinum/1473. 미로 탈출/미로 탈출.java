import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N, M;
    static int[][] board;
    static boolean[][][][] vis;

    static class Info {
        int x, y, r, c, cnt;

        public Info(int x, int y, int r, int c, int cnt) {
            this.x = x;
            this.y = y;
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = row.charAt(j) - 'A';
            }
        }
        vis = new boolean[1 << N][1 << M][N][M];
        int ans = -1;
        ArrayDeque<Info> q = new ArrayDeque<>();
        q.offer(new Info(0, 0, 0, 0, 0));
        vis[0][0][0][0] = true;
        while (!q.isEmpty()) {
            Info cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            if (x == N - 1 && y == M - 1) {
                ans = cur.cnt;
                break;
            }
            int r = cur.r;
            int c = cur.c;
            int cnt = cur.cnt;
            int cm = mode(x, y, r, c);
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (check(cm, mode(nx, ny, r, c), d) && !vis[r][c][nx][ny]) {
                        vis[r][c][nx][ny] = true;
                        q.offer(new Info(nx, ny, r, c, cnt + 1));
                    }
                }
            }
            int nxtR = (1 << x) ^ r;
            int nxtC = (1 << y) ^ c;
            if (!vis[nxtR][nxtC][x][y]) {
                vis[nxtR][nxtC][x][y] = true;
                q.offer(new Info(x, y, nxtR, nxtC, cnt + 1));
            }
        }
        System.out.println(ans);
    }

    static int mode(int x, int y, int r, int c) {
        boolean flag = (((1 << x) & r) == 0) ^ (((1 << y) & c) == 0);
        if (!flag) return board[x][y];
        else {
            if (board[x][y] < 2) return board[x][y];
            else return board[x][y] == 2 ? 3 : 2;
        }
    }

    static boolean check(int a, int b, int d) {
        if (a == 0 && (b == 0 || (d < 2 && b == 2) || (d >= 2 && b == 3))) return true;
        else if (a == 2 && ((d < 2 && b == 0) || (d < 2 && b == 2))) return true;
        else return a == 3 && (d >= 2 && b == 0 || (d >= 2 && b == 3));
    }
}
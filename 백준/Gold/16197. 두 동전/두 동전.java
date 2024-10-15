import java.io.*;
import java.util.*;

public class Main {
    static class Coin {
        int x1, y1, x2, y2, t;

        public Coin(int x1, int y1, int x2, int y2, int t) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.t = t;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    static char[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        int x1 = -1, y1 = -1, x2 = -1, y2 = -1;
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = row.charAt(j);
                if (board[i][j] == 'o') {
                    board[i][j] = '.';
                    if (x1 == -1 && y1 == -1) {
                        x1 = i;
                        y1 = j;
                    } else {
                        x2 = i;
                        y2 = j;
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        ArrayDeque<Coin> q = new ArrayDeque<>();
        q.offer(new Coin(x1, y1, x2, y2, 0));
        while (!q.isEmpty()) {
            Coin c = q.poll();
            if (c.t == 10) continue;
            for (int d = 0; d < 4; d++) {
                int nx1 = c.x1 + dx[d];
                int ny1 = c.y1 + dy[d];
                int nx2 = c.x2 + dx[d];
                int ny2 = c.y2 + dy[d];
                if ((nx1 < 0 || nx1 >= N || ny1 < 0 || ny1 >= M) && (nx2 < 0 || nx2 >= N || ny2 < 0 || ny2 >= M)) {
                    continue;
                } else if (nx1 < 0 || nx1 >= N || ny1 < 0 || ny1 >= M) {
                    ans = Math.min(ans, c.t + 1);
                    continue;
                } else if (nx2 < 0 || nx2 >= N || ny2 < 0 || ny2 >= M) {
                    ans = Math.min(ans, c.t + 1);
                    continue;
                }
                if (board[nx1][ny1] == '#') {
                    nx1 -= dx[d];
                    ny1 -= dy[d];
                }
                if (board[nx2][ny2] == '#') {
                    nx2 -= dx[d];
                    ny2 -= dy[d];
                }
                q.offer(new Coin(nx1, ny1, nx2, ny2, c.t + 1));
            }
        }
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}
import java.io.*;
import java.util.*;

public class Main {
    static int[] kx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] ky = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] rx = {-1, 0, 1, 0};
    static int[] ry = {0, 1, 0, -1};
    static int[] bx = {-1, 1, 1, -1};
    static int[] by = {1, 1, -1, -1};

    static int N, minTime, minChange;
    static int[][] chess;
    static int[][][][] cCheck;

    static ArrayDeque<Piece> q;

    static class Piece {
        int x, y, time, mode, num, change;

        public Piece(int x, int y, int time, int mode, int num, int change) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.mode = mode;
            this.num = num;
            this.change = change;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        chess = new int[N][N];
        minTime = Integer.MAX_VALUE;
        minChange = Integer.MAX_VALUE;
        int sx = -1, sy = -1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                chess[i][j] = Integer.parseInt(st.nextToken());
                if (chess[i][j] == 1) {
                    sx = i;
                    sy = j;
                }
            }
        }
        game(sx, sy);
        System.out.println(minTime + " " + minChange);
    }

    static void game(int sx, int sy) {
        int end = N * N;
        cCheck = new int[N * N + 1][3][N][N];
        for (int i = 0; i <= end; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < N; k++) {
                    Arrays.fill(cCheck[i][j][k], Integer.MAX_VALUE);
                }
            }
        }
        q = new ArrayDeque<>();
        for (int i = 0; i < 3; i++) {
            cCheck[1][i][sx][sy] = 0;
            q.offer(new Piece(sx, sy, 0, i, 1, 0));
        }

        while (!q.isEmpty()) {
            Piece cur = q.poll();

            // 종료
            if (cur.num == end && chess[cur.x][cur.y] == end) {
                minTime = Math.min(minTime, cur.time);
                if (cur.time == minTime) {
                    minChange = Math.min(minChange, cur.change);
                }
                continue;
            }

            changeMode(cur);

            // 나이트
            if (cur.mode == 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = cur.x + kx[i];
                    int ny = cur.y + ky[i];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        int num = chess[nx][ny] == cur.num + 1 ? cur.num + 1 : cur.num;
                        if (cur.change < cCheck[num][cur.mode][nx][ny]) {
                            cCheck[num][cur.mode][nx][ny] = cur.change;
                            q.offer(new Piece(nx, ny, cur.time + 1, cur.mode, num, cur.change));
                        }
                    }
                }
            }

            // 룩
            else if (cur.mode == 1) {
                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + rx[d];
                    int ny = cur.y + ry[d];
                    while (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        int num = chess[nx][ny] == cur.num + 1 ? cur.num + 1 : cur.num;
                        if (cur.change < cCheck[num][cur.mode][nx][ny]) {
                            cCheck[num][cur.mode][nx][ny] = cur.change;
                            q.offer(new Piece(nx, ny, cur.time + 1, cur.mode, num, cur.change));
                        }
                        nx += rx[d];
                        ny += ry[d];
                    }
                }
            }

            // 비숍
            else {
                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + bx[d];
                    int ny = cur.y + by[d];
                    while (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        int num = chess[nx][ny] == cur.num + 1 ? cur.num + 1 : cur.num;
                        if (cur.change < cCheck[num][cur.mode][nx][ny]) {
                            cCheck[num][cur.mode][nx][ny] = cur.change;
                            q.offer(new Piece(nx, ny, cur.time + 1, cur.mode, num, cur.change));
                        }
                        nx += bx[d];
                        ny += by[d];
                    }
                }
            }
        }
    }

    static void changeMode(Piece p) {
        for (int i = 0; i < 3; i++) {
            if (i == p.mode) continue;
            if (p.change + 1 < cCheck[p.num][i][p.x][p.y]) {
                cCheck[p.num][i][p.x][p.y] = p.change + 1;
                q.offer(new Piece(p.x, p.y, p.time + 1, i, p.num, p.change + 1));
            }
        }
    }
}
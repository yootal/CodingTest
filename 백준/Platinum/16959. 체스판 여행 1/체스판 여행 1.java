import java.io.*;
import java.util.*;

public class Main {
    static int[] kx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] ky = {-2, -1, 1, 2, 2, 1, -1, -2};

    static int N;
    static int[][] chess;
    static int[][][][] timeCheck;

    static ArrayDeque<Piece> q;

    static class Piece {
        int x, y, time, mode, nxt;

        public Piece(int x, int y, int time, int mode, int nxt) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.mode = mode;
            this.nxt = nxt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        chess = new int[N][N];
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
        System.out.println(game(sx, sy));
    }

    static int game(int sx, int sy) {
        int end = N * N;
        timeCheck = new int[N][N][3][N * N + 1]; // 높이, 넓이, 말 종류, 현재 가야할 번호
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 3; k++) {
                    Arrays.fill(timeCheck[i][j][k], Integer.MAX_VALUE);
                }
            }
        }
        q = new ArrayDeque<>();
        for (int i = 0; i < 3; i++) {
            timeCheck[sx][sy][i][1] = 0;
            q.offer(new Piece(sx, sy, 0, i, 1));
        }
        while (!q.isEmpty()) {
            Piece cur = q.poll();

            // 최소 시간 아니면 스킵
            if (cur.time != timeCheck[cur.x][cur.y][cur.mode][cur.nxt]) continue;

            // 종료
            if (cur.nxt == end && chess[cur.x][cur.y] == end) {
                return cur.time;
            }

            // 나이트
            if (cur.mode == 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = cur.x + kx[i];
                    int ny = cur.y + ky[i];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        if (checkNxt(nx, ny, cur.time + 1, cur.mode, cur.nxt + 1)) {
                            timeCheck[nx][ny][cur.mode][cur.nxt + 1] = cur.time + 1;
                            q.offer(new Piece(nx, ny, cur.time + 1, cur.mode, cur.nxt + 1));
                        } else if (cur.time + 1 < timeCheck[nx][ny][cur.mode][cur.nxt]) {
                            timeCheck[nx][ny][cur.mode][cur.nxt] = cur.time + 1;
                            q.offer(new Piece(nx, ny, cur.time + 1, cur.mode, cur.nxt));
                        }
                    }
                }
                changeMode(cur);
            }

            // 룩
            else if (cur.mode == 1) {
                for (int i = 0; i < N; i++) {
                    if (i != cur.x) {
                        if (checkNxt(i, cur.y, cur.time + 1, cur.mode, cur.nxt + 1)) {
                            timeCheck[i][cur.y][cur.mode][cur.nxt + 1] = cur.time + 1;
                            q.offer(new Piece(i, cur.y, cur.time + 1, cur.mode, cur.nxt + 1));
                        } else if (cur.time + 1 < timeCheck[i][cur.y][cur.mode][cur.nxt]) {
                            timeCheck[i][cur.y][cur.mode][cur.nxt] = cur.time + 1;
                            q.offer(new Piece(i, cur.y, cur.time + 1, cur.mode, cur.nxt));
                        }
                    }
                    if (i != cur.y) {
                        if (checkNxt(cur.x, i, cur.time + 1, cur.mode, cur.nxt + 1)) {
                            timeCheck[cur.x][i][cur.mode][cur.nxt + 1] = cur.time + 1;
                            q.offer(new Piece(cur.x, i, cur.time + 1, cur.mode, cur.nxt + 1));
                        } else if (cur.time + 1 < timeCheck[cur.x][i][cur.mode][cur.nxt]) {
                            timeCheck[cur.x][i][cur.mode][cur.nxt] = cur.time + 1;
                            q.offer(new Piece(cur.x, i, cur.time + 1, cur.mode, cur.nxt));
                        }
                    }
                }
                changeMode(cur);
            }

            // 비숍
            else {

                // 왼쪽 위 대각
                int x = cur.x - 1;
                int y = cur.y - 1;
                while (x >= 0 && y >= 0) {
                    if (checkNxt(x, y, cur.time + 1, cur.mode, cur.nxt + 1)) {
                        timeCheck[x][y][cur.mode][cur.nxt + 1] = cur.time + 1;
                        q.offer(new Piece(x, y, cur.time + 1, cur.mode, cur.nxt + 1));
                    } else if (cur.time + 1 < timeCheck[x][y][cur.mode][cur.nxt]) {
                        timeCheck[x][y][cur.mode][cur.nxt] = cur.time + 1;
                        q.offer(new Piece(x, y, cur.time + 1, cur.mode, cur.nxt));
                    }
                    x--;
                    y--;
                }

                // 오른쪽 위 대각
                x = cur.x - 1;
                y = cur.y + 1;
                while (x >= 0 && y < N) {
                    if (checkNxt(x, y, cur.time + 1, cur.mode, cur.nxt + 1)) {
                        timeCheck[x][y][cur.mode][cur.nxt + 1] = cur.time + 1;
                        q.offer(new Piece(x, y, cur.time + 1, cur.mode, cur.nxt + 1));
                    } else if (cur.time + 1 < timeCheck[x][y][cur.mode][cur.nxt]) {
                        timeCheck[x][y][cur.mode][cur.nxt] = cur.time + 1;
                        q.offer(new Piece(x, y, cur.time + 1, cur.mode, cur.nxt));
                    }
                    x--;
                    y++;
                }

                // 오른쪽 아래 대각
                x = cur.x + 1;
                y = cur.y + 1;
                while (x < N && y < N) {
                    if (checkNxt(x, y, cur.time + 1, cur.mode, cur.nxt + 1)) {
                        timeCheck[x][y][cur.mode][cur.nxt + 1] = cur.time + 1;
                        q.offer(new Piece(x, y, cur.time + 1, cur.mode, cur.nxt + 1));
                    } else if (cur.time + 1 < timeCheck[x][y][cur.mode][cur.nxt]) {
                        timeCheck[x][y][cur.mode][cur.nxt] = cur.time + 1;
                        q.offer(new Piece(x, y, cur.time + 1, cur.mode, cur.nxt));
                    }
                    x++;
                    y++;
                }

                // 왼쪽 아래 대각
                x = cur.x + 1;
                y = cur.y - 1;
                while (x < N && y >= 0) {
                    if (checkNxt(x, y, cur.time + 1, cur.mode, cur.nxt + 1)) {
                        timeCheck[x][y][cur.mode][cur.nxt + 1] = cur.time + 1;
                        q.offer(new Piece(x, y, cur.time + 1, cur.mode, cur.nxt + 1));
                    } else if (cur.time + 1 < timeCheck[x][y][cur.mode][cur.nxt]) {
                        timeCheck[x][y][cur.mode][cur.nxt] = cur.time + 1;
                        q.offer(new Piece(x, y, cur.time + 1, cur.mode, cur.nxt));
                    }
                    x++;
                    y--;
                }
                changeMode(cur);
            }
        }
        return 0;
    }

    static void changeMode(Piece p) {
        for (int i = 0; i < 3; i++) {
            if (i == p.mode) continue;
            if (p.time + 1 < timeCheck[p.x][p.y][i][p.nxt]) {
                timeCheck[p.x][p.y][i][p.nxt] = p.time + 1;
                q.offer(new Piece(p.x, p.y, p.time + 1, i, p.nxt));
            }
        }
    }

    static boolean checkNxt(int nx, int ny, int time, int mode, int nxt) {
        return chess[nx][ny] == nxt && time < timeCheck[nx][ny][mode][nxt];
    }
}
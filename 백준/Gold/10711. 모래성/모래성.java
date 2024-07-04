import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int N, M;
    static int[][] board1, board2;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board1 = new int[N][M];
        board2 = new int[N][M];
        ArrayDeque<Point> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                char temp = row.charAt(j);
                if (temp == '.') {
                    board1[i][j] = 0;
                } else {
                    board1[i][j] = temp - '0';
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board1[i][j] != 0)
                    board2[i][j] = breakCheck(i, j);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board1[i][j] != 0) {
                    if (board1[i][j] - board2[i][j] <= 0) {
                        board1[i][j] = 0;
                        q.offer(new Point(i, j));
                    } else {
                        board1[i][j] -= board2[i][j];
                    }
                }
            }
        }
        int turn = 0;
        while (!q.isEmpty()) {
            int cnt = 0;
            int size = q.size();
            while (cnt != size) {
                Point cur = q.poll();
                for (int d = 0; d < 8; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && board1[nx][ny] != 0) {
                        board1[nx][ny]--;
                        if (board1[nx][ny] == 0) {
                            q.offer(new Point(nx, ny));
                        }
                    }
                }
                cnt++;
            }
            turn++;
        }
        System.out.println(turn);
    }

    static int breakCheck(int x, int y) {
        int cnt = 0;
        for (int d = 0; d < 8; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && board1[nx][ny] == 0)
                cnt++;
        }
        return cnt;
    }
}
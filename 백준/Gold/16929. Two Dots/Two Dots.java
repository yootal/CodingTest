import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static boolean[][] check;

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
        check = new boolean[N][M];
        loop();
    }

    static void loop() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!check[i][j]) {
                    if (solve(i, j)) {
                        System.out.println("Yes");
                        return;
                    }
                }
            }
        }
        System.out.println("No");
    }

    static boolean solve(int i, int j) {
        check[i][j] = true;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i, j, 0, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && (nx != cur[2] || ny != cur[3]) && board[cur[0]][cur[1]] == board[nx][ny]) {
                    if (check[nx][ny]) {
                        return true;
                    } else {
                        check[nx][ny] = true;
                        q.offer(new int[]{nx, ny, cur[0], cur[1]});
                    }
                }
            }
        }
        return false;
    }
}

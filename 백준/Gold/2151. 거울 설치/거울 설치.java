import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[][][] vis = new boolean[N][N][4];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = row.charAt(j);
                if (board[i][j] == '#' && q.isEmpty()) {
                    for (int d = 0; d < 4; d++) {
                        q.offer(new int[]{i, j, 0, d});
                    }
                    board[i][j] = '@';
                }
            }
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];
            int cd = cur[3];
            if (vis[x][y][cd]) continue;
            vis[x][y][cd] = true;
            if (board[x][y] == '#') {
                System.out.println(cnt);
                break;
            }
            if (board[x][y] == '!') {
                int s = 0, e = 2;
                if (cd < 2) {
                    s = 2;
                    e = 4;
                }
                for (int d = s; d < e; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (limit(nx, ny) && !vis[nx][ny][d]) {
                        q.offerLast(new int[]{nx, ny, cnt + 1, d});
                    }
                }
            }
            int nx = x + dx[cd];
            int ny = y + dy[cd];
            if (limit(nx, ny) && !vis[nx][ny][cd]) {
                q.offerFirst(new int[]{nx, ny, cnt, cd});
            }
        }
    }

    static boolean limit(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N && board[x][y] != '*';
    }
}

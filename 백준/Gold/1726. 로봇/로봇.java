import java.util.*;
import java.io.*;

public class Main {
    static int[][] board;
    static int N, M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        boolean[][][] vis = new boolean[N][M][4];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int sx = Integer.parseInt(st.nextToken()) - 1;
        int sy = Integer.parseInt(st.nextToken()) - 1;
        int sd = dir(Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        int ex = Integer.parseInt(st.nextToken()) - 1;
        int ey = Integer.parseInt(st.nextToken()) - 1;
        int ed = dir(Integer.parseInt(st.nextToken()));
        vis[sx][sy][sd] = true;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy, sd, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == ex && cur[1] == ey && cur[2] == ed) {
                System.out.println(cur[3]);
                break;
            }
            for (int i = 3; i >= 1; i--) {
                int nx = cur[0] + dx[cur[2]] * i;
                int ny = cur[1] + dy[cur[2]] * i;
                if (!check(cur[0], cur[1], cur[2], i)) continue;
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || board[nx][ny] == 1 || vis[nx][ny][cur[2]])
                    continue;
                vis[nx][ny][cur[2]] = true;
                q.offer(new int[]{nx, ny, cur[2], cur[3] + 1});
            }
            int ld = (cur[2] + 1) % 4;
            if (!vis[cur[0]][cur[1]][ld]) {
                vis[cur[0]][cur[1]][ld] = true;
                q.offer(new int[]{cur[0], cur[1], ld, cur[3] + 1});
            }
            int rd = (cur[2] + 3) % 4;
            if (!vis[cur[0]][cur[1]][rd]) {
                vis[cur[0]][cur[1]][rd] = true;
                q.offer(new int[]{cur[0], cur[1], rd, cur[3] + 1});
            }
        }
    }

    static int dir(int d) {
        switch (d) {
            case 1:
                return 1;
            case 2:
                return 3;
            case 3:
                return 2;
            default:
                return 0;
        }
    }

    static boolean check(int x, int y, int d, int r) {
        for (int i = r; i >= 1; i--) {
            int nx = x + dx[d] * i;
            int ny = y + dy[d] * i;
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (board[nx][ny] == 1) return false;
        }
        return true;
    }
}
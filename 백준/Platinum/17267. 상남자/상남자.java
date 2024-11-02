import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][][] vis = new int[N][M][2];
        int[][] board = new int[N][M];
        int sx = -1, sy = -1;
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = row.charAt(j) - '0';
                if (board[i][j] == 2) {
                    sx = i;
                    sy = j;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(vis[i][j], -1);
            }
        }
        vis[sx][sy][0] = L;
        vis[sx][sy][1] = R;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy, L, R, 0});
        q.offer(new int[]{sx, sy, L, R, 1});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int l = cur[2];
            int r = cur[3];
            if (cur[4] == 0) { // 상하
                int nx = x - 1;
                while (nx >= 0) {
                    if (board[nx][y] == 1) break;
                    boolean check = false;
                    if (vis[nx][y][0] < l) {
                        vis[nx][y][0] = l;
                        check = true;
                    }
                    if (vis[nx][y][1] < r) {
                        vis[nx][y][1] = r;
                        check = true;
                    }
                    if (check)
                        q.offer(new int[]{nx, y, l, r, 1});
                    else break;
                    nx--;
                }
                nx = x + 1;
                while (nx < N) {
                    if (board[nx][y] == 1) break;
                    boolean check = false;
                    if (vis[nx][y][0] < l) {
                        vis[nx][y][0] = l;
                        check = true;
                    }
                    if (vis[nx][y][1] < r) {
                        vis[nx][y][1] = r;
                        check = true;
                    }
                    if (check)
                        q.offer(new int[]{nx, y, l, r, 1});
                    else break;
                    nx++;
                }
            } else { // 좌우
                int diff = 1;
                while (y - diff >= 0 && l - diff >= 0) {
                    if (board[x][y - diff] == 1) break;
                    boolean check = false;
                    if (vis[x][y - diff][0] < l) {
                        vis[x][y - diff][0] = l;
                        check = true;
                    }
                    if (vis[x][y - diff][1] < r) {
                        vis[x][y - diff][1] = r;
                        check = true;
                    }
                    if (check)
                        q.offer(new int[]{x, y - diff, l - diff, r, 0});
                    else break;
                    diff++;
                }
                diff = 1;
                while (y + diff < M && r - diff >= 0 && board[x][y + diff] != 1) {
                    if (board[x][y + diff] == 1) break;
                    boolean check = false;
                    if (vis[x][y + diff][0] < l) {
                        vis[x][y + diff][0] = l;
                        check = true;
                    }
                    if (vis[x][y + diff][1] < r) {
                        vis[x][y + diff][1] = r;
                        check = true;
                    }
                    if (check)
                        q.offer(new int[]{x, y + diff, l, r - diff, 0});
                    else break;
                    diff++;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (vis[i][j][0] != -1 || vis[i][j][1] != -1) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
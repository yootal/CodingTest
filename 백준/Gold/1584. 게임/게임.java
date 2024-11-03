import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[501][501];
        boolean[][] vis = new boolean[501][501];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int x = Math.min(x1, x2); x <= Math.max(x1, x2); x++) {
                for (int y = Math.min(y1, y2); y <= Math.max(y1, y2); y++) {
                    board[x][y] = 1;
                }
            }
        }
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int x = Math.min(x1, x2); x <= Math.max(x1, x2); x++) {
                for (int y = Math.min(y1, y2); y <= Math.max(y1, y2); y++) {
                    vis[x][y] = true;
                }
            }
        }
        int ans = -1;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        vis[0][0] = true;
        q.offer(new int[]{0, 0, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == 500 && cur[1] == 500) {
                ans = cur[2];
                break;
            }
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (nx >= 0 && nx < 501 && ny >= 0 && ny < 501 && !vis[nx][ny]) {
                    vis[nx][ny] = true;
                    if (board[nx][ny] == 0) {
                        q.offerFirst(new int[]{nx, ny, cur[2]});
                    } else {
                        q.offer(new int[]{nx, ny, cur[2] + 1});
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
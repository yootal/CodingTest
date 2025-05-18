import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0, -1, 1, -1, 1};
    static int[] dy = {0, 1, 0, -1, -1, 1, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = row.charAt(j) == '\\' ? 0 : 1;
            }
        }
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int[][][] vis = new int[N][M][2];
        for (int[][] vis2 : vis) {
            for (int[] vis3 : vis2) {
                Arrays.fill(vis3, Integer.MAX_VALUE);
            }
        }
        if (board[0][0] == 0) {
            vis[0][0][0] = 0;
            q.offer(new int[]{0, 0, 0, 0}); // x, y, 방향, 교체 횟수
        } else {
            vis[0][0][1] = 0;
            vis[0][0][0] = 1;
            q.offer(new int[]{0, 0, 0, 1});
        }
        int cnt = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[3] != vis[cur[0]][cur[1]][cur[2]]) continue;
            if (cur[0] == N - 1 && cur[1] == M - 1 && cur[2] == 0) {
                cnt = cur[3];
                break;
            }
            int nxt = cur[2] == 0 ? 1 : 0;
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (board[nx][ny] == nxt && vis[nx][ny][nxt] > cur[3]) {
                        vis[nx][ny][nxt] = cur[3];
                        q.offerFirst(new int[]{nx, ny, board[nx][ny], cur[3]});
                    } else if (board[nx][ny] != nxt && vis[nx][ny][nxt] > cur[3] + 1) {
                        vis[nx][ny][nxt] = cur[3] + 1;
                        q.offerLast(new int[]{nx, ny, nxt, cur[3] + 1});
                    }
                }
            }
            int s = 4, e = 6;
            if (cur[2] == 1) {
                s = 6;
                e = 8;
            }
            for (int d = s; d < e; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (board[nx][ny] == cur[2] && vis[nx][ny][cur[2]] > cur[3]) {
                        vis[nx][ny][cur[2]] = cur[3];
                        q.offerFirst(new int[]{nx, ny, cur[2], cur[3]});
                    } else if (board[nx][ny] != cur[2] && vis[nx][ny][cur[2]] > cur[3] + 1) {
                        vis[nx][ny][cur[2]] = cur[3] + 1;
                        q.offerLast(new int[]{nx, ny, cur[2], cur[3] + 1});
                    }
                }
            }
        }
        System.out.println(cnt == Integer.MAX_VALUE ? "NO SOLUTION" : cnt);
    }
}
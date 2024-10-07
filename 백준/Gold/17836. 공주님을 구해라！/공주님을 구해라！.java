import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];
        int[][][] vis = new int[N][M][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 0});
        vis[0][0][0] = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || vis[nx][ny][cur[2]] != 0) continue;
                if (board[nx][ny] == 2 && vis[nx][ny][1] == 0) {
                    vis[nx][ny][1] = vis[cur[0]][cur[1]][cur[2]] + 1;
                    q.offer(new int[]{nx, ny, 1});
                } else {
                    if (cur[2] == 1) {
                        vis[nx][ny][cur[2]] = vis[cur[0]][cur[1]][cur[2]] + 1;
                        q.offer(new int[]{nx, ny, cur[2]});
                    } else if (board[nx][ny] != 1) {
                        vis[nx][ny][cur[2]] = vis[cur[0]][cur[1]][cur[2]] + 1;
                        q.offer(new int[]{nx, ny, cur[2]});
                    }
                }
            }
        }
        vis[N - 1][M - 1][0] = vis[N - 1][M - 1][0] == 0 ? Integer.MAX_VALUE : vis[N - 1][M - 1][0] - 1;
        vis[N - 1][M - 1][1] = vis[N - 1][M - 1][1] == 0 ? Integer.MAX_VALUE : vis[N - 1][M - 1][1] - 1;
        int time = Math.min(vis[N - 1][M - 1][0], vis[N - 1][M - 1][1]);
        if (time > T) {
            System.out.println("Fail");
        } else {
            System.out.println(time);
        }
    }
}
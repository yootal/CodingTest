import java.util.*;
import java.io.*;

public class Main {
    static int N, start, end;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        start = board[0][0];
        end = board[N - 1][N - 1];
        int s = 0, e = 200;
        while (s < e) {
            int mid = (s + e) / 2;
            if (bfs(mid)) {
                e = mid;
            } else
                s = mid + 1;
        }
        System.out.println(s);
    }

    static boolean bfs(int diff) {
        for (int i = 0; i <= 200 - diff; i++) {
            if (start >= i && start <= i + diff && end >= i && end <= i + diff) {
                boolean[][] vis = new boolean[N][N];
                vis[0][0] = true;
                ArrayDeque<int[]> q = new ArrayDeque<>();
                q.offer(new int[]{0, 0});
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    if (cur[0] == N - 1 && cur[1] == N - 1) {
                        return true;
                    }
                    for (int d = 0; d < 4; d++) {
                        int nx = cur[0] + dx[d];
                        int ny = cur[1] + dy[d];
                        if (nx >= 0 && nx < N && ny >= 0 && ny < N && !vis[nx][ny]) {
                            int nxt = board[nx][ny];
                            if (nxt >= i && nxt <= i + diff) {
                                vis[nx][ny] = true;
                                q.offer(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
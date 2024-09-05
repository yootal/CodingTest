import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        char[][] board = new char[N][M];
        int[][][] vis = new int[N][M][4];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(vis[i][j], 10001);
            }
        }
        int[] s = {-1, -1};
        int[] e = {-1, -1};
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = row.charAt(j);
                if (board[i][j] == 'C') {
                    if (s[0] == -1) {
                        s[0] = i;
                        s[1] = j;
                    } else {
                        e[0] = i;
                        e[1] = j;
                    }
                }
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[3]));
        for (int d = 0; d < 4; d++) {
            vis[s[0]][s[1]][d] = 0;
            pq.offer(new int[]{s[0], s[1], d, 0});
        }
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cx = cur[0];
            int cy = cur[1];
            int pd = cur[2];
            int cnt = cur[3];
            if (vis[cx][cy][pd] < cur[3]) continue;
            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] != '*') {
                    int newCnt = (d == pd) ? cnt : cnt + 1;
                    if (vis[nx][ny][d] > newCnt) {
                        vis[nx][ny][d] = newCnt;
                        pq.offer(new int[]{nx, ny, d, newCnt});
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            ans = Math.min(ans, vis[e[0]][e[1]][i]);
        }
        System.out.println(ans);
    }
}
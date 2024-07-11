import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int room[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < N; j++) {
                int temp = row.charAt(j) - '0';
                if (temp == 1) {
                    room[i][j] = 0;
                } else room[i][j] = 1;
            }
        }
        boolean[][] vis = new boolean[N][N];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        vis[0][0] = true;
        q.offer(new int[]{0, 0, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == N - 1 && cur[1] == N - 1) {
                System.out.println(cur[2]);
                break;
            }
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !vis[nx][ny]) {
                    vis[nx][ny] = true;
                    if (room[nx][ny] == 0) {
                        q.offerFirst(new int[]{nx, ny, cur[2]});
                    } else {
                        q.offer(new int[]{nx, ny, cur[2] + 1});
                    }
                }
            }
        }
    }
}
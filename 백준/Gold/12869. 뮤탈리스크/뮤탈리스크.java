import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {9, 9, 3, 3, 1, 1};
    static int[] dy = {3, 1, 9, 1, 9, 3};
    static int[] dz = {1, 3, 1, 9, 3, 9};
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] hp = new int[3];
        for (int i = 0; i < N; i++) {
            hp[i] = Integer.parseInt(st.nextToken());
        }
        int[][][] time = new int[hp[0] + 1][hp[1] + 1][hp[2] + 1];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        time[hp[0]][hp[1]][hp[2]] = 0;
        q.offer(hp);
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] <= 0 && cur[1] <= 0 && cur[2] <= 0) {
                break;
            }
            for (int i = 0; i < 6; i++) {
                int nx = Math.max(cur[0] - dx[i], 0);
                int ny = Math.max(cur[1] - dy[i], 0);
                int nz = Math.max(cur[2] - dz[i], 0);
                if (time[nx][ny][nz] == 0) {
                    time[nx][ny][nz] = time[cur[0]][cur[1]][cur[2]] + 1;
                    q.offer(new int[]{nx, ny, nz});
                }
            }
        }
        System.out.println(time[0][0][0]);
    }
}
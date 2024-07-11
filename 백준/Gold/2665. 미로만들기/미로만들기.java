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
        int[][] sdt = new int[N][N];
        for (int[] row : sdt) {
            Arrays.fill(row, N * N);
        }
        sdt[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        pq.offer(new int[]{sdt[0][0], 0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[0] != sdt[cur[1]][cur[2]]) continue;
            for (int d = 0; d < 4; d++) {
                int nx = cur[1] + dx[d];
                int ny = cur[2] + dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (sdt[nx][ny] > sdt[cur[1]][cur[2]] + room[nx][ny]) {
                        sdt[nx][ny] = sdt[cur[1]][cur[2]] + room[nx][ny];
                        pq.offer(new int[]{sdt[nx][ny], nx, ny});
                    }
                }
            }
        }
        System.out.println(sdt[N - 1][N - 1]);
    }
}
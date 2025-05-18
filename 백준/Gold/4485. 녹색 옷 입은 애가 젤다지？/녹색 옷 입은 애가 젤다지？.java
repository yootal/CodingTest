import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx = { -1, 0, 1, 0 };
    static final int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tc = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0)
                break;
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] dist = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }
            dist[0][0] = arr[0][0];
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
            pq.offer(new int[] { 0, 0, dist[0][0] });
            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                int x = cur[0];
                int y = cur[1];
                int min = cur[2];
                if (dist[x][y] != cur[2])
                    continue;
                if (x == N - 1 && y == N - 1)
                    break;
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && dist[nx][ny] > min + arr[nx][ny]) {
                        dist[nx][ny] = min + arr[nx][ny];
                        pq.offer(new int[] { nx, ny, dist[nx][ny] });
                    }
                }
            }
            sb.append("Problem ").append(tc).append(": ").append(dist[N - 1][N - 1]).append("\n");
            tc++;
        }
        System.out.print(sb);
    }
}
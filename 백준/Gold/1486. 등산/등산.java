import java.io.*;
import java.util.*;

public class Main {

    static int N, M, T, D;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] mountain, dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        mountain = new int[N][M];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                mountain[i][j] = row.charAt(j);
                if (mountain[i][j] > 'Z') {
                    mountain[i][j] -= 'a';
                    mountain[i][j] += 26;
                } else {
                    mountain[i][j] -= 'A';
                }
            }
        }
        dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        pq.offer(new int[]{0, 0, 0});
        dist[0][0] = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int t = cur[2];
            if (dist[x][y] != t) continue;
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (limit(nx, ny) && Math.abs(mountain[x][y] - mountain[nx][ny]) <= T) {
                    int diff = calc(mountain[x][y], mountain[nx][ny]);
                    if (dist[nx][ny] > t + diff) {
                        dist[nx][ny] = t + diff;
                        pq.offer(new int[]{nx, ny, dist[nx][ny]});
                    }
                }
            }
        }
        int top = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dist[i][j] != Integer.MAX_VALUE && dijkstra(i, j)) {
                    top = Math.max(top, mountain[i][j]);
                }
            }
        }
        System.out.println(top);
    }

    static boolean limit(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    static int calc(int from, int to) {
        if (from >= to) {
            return 1;
        } else {
            return (int) Math.pow(from - to, 2);
        }
    }

    static boolean dijkstra(int i, int j) {
        int[][] dist2 = new int[N][M];
        for (int k = 0; k < N; k++) {
            Arrays.fill(dist2[k], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq2 = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        pq2.offer(new int[]{i, j, 0});
        dist2[i][j] = 0;
        while (!pq2.isEmpty()) {
            int[] cur = pq2.poll();
            int x = cur[0];
            int y = cur[1];
            int t = cur[2];
            if (dist2[x][y] != t) continue;
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (limit(nx, ny) && Math.abs(mountain[x][y] - mountain[nx][ny]) <= T) {
                    int diff = calc(mountain[x][y], mountain[nx][ny]);
                    if (dist2[nx][ny] > t + diff) {
                        dist2[nx][ny] = t + diff;
                        pq2.offer(new int[]{nx, ny, dist2[nx][ny]});
                    }
                }
            }
        }
        return dist2[0][0] != Integer.MAX_VALUE && dist[i][j] + dist2[0][0] <= D;
    }
}

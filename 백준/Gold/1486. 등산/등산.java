import java.io.*;
import java.util.*;

public class Main {

    static int N, M, T, D;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] mountain;
    static int[][][] dist;

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
        dist = new int[N][M][52];
        dijkstra();
        for (int i = 51; i >= 0; i--) {
            if (dist[0][0][i] <= D) {
                System.out.println(i);
                System.exit(0);
            }
        }
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

    static void dijkstra() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        dist[0][0][mountain[0][0]] = 0;
        pq.offer(new int[]{0, 0, 0, mountain[0][0]});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int t = cur[2];
            int top = cur[3];
            if (dist[x][y][top] != t) continue;
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (limit(nx, ny) && Math.abs(mountain[x][y] - mountain[nx][ny]) <= T) {
                    int diff = calc(mountain[x][y], mountain[nx][ny]);
                    int nt = Math.max(top, mountain[nx][ny]);
                    if (dist[nx][ny][nt] > t + diff) {
                        dist[nx][ny][nt] = t + diff;
                        pq.offer(new int[]{nx, ny, dist[nx][ny][nt], nt});
                    }
                }
            }
        }
    }
}

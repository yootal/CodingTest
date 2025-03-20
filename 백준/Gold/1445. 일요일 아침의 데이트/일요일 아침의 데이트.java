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
        char[][] board = new char[N][M];
        int[][] value = new int[N][M];
        int sx = -1, sy = -1;
        int fx = -1, fy = -1;
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = row.charAt(j);
                if (board[i][j] == 'g') {
                    value[i][j] = 1;
                } else if (board[i][j] == 'S') {
                    sx = i;
                    sy = j;
                } else if (board[i][j] == 'F') {
                    fx = i;
                    fy = j;
                }
            }
        }
        int[][] record = new int[N][M];
        int[][] record2 = new int[N][M];
        for (int[] row : record) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for (int[] row : record2) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt((int[] o) -> o[2])
                        .thenComparingInt(o -> o[3])
        );
        pq.offer(new int[]{sx, sy, 0, 0});
        record[sx][sy] = 0;
        record2[sx][sy] = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int v = cur[2];
            if (v != record[x][y]) continue;
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    int flag = 0;
                    if (board[nx][ny] != 'F' && board[nx][ny] != 'g') {
                        for (int d2 = 0; d2 < 4; d2++) {
                            int nx2 = nx + dx[d2];
                            int ny2 = ny + dy[d2];
                            if (nx2 >= 0 && nx2 < N && ny2 >= 0 && ny2 < M && board[nx2][ny2] == 'g') {
                                flag = 1;
                                break;
                            }
                        }
                    }
                    if (record[nx][ny] > v + value[nx][ny]) {
                        record[nx][ny] = v + value[nx][ny];
                        record2[nx][ny] = cur[3] + flag;
                        pq.offer(new int[]{nx, ny, record[nx][ny], record2[nx][ny]});
                    } else if (record[nx][ny] == v + value[nx][ny] && record2[nx][ny] > cur[3] + flag) {
                        record2[nx][ny] = cur[3] + flag;
                        pq.offer(new int[]{nx, ny, record[nx][ny], record2[nx][ny]});
                    }
                }
            }
        }
        System.out.println(record[fx][fy] + " " + record2[fx][fy]);
    }
}

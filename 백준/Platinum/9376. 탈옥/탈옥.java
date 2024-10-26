import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            char[][] board = new char[N + 2][M + 2];
            int[][][] open = new int[N + 2][M + 2][3];
            int[][] temp = new int[2][3];
            int idx = 0;
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
            for (int i = 0; i < N + 2; i++) {
                for (int j = 0; j < M + 2; j++) {
                    Arrays.fill(open[i][j], 10000000);
                    board[i][j] = '.';
                }
            }
            for (int i = 1; i <= N; i++) {
                String row = br.readLine();
                for (int j = 1; j <= M; j++) {
                    board[i][j] = row.charAt(j - 1);
                    if (board[i][j] == '$') {
                        board[i][j] = '.';
                        temp[idx][0] = i;
                        temp[idx][1] = j;
                        temp[idx][2] = 0;
                        open[i][j][++idx] = 0;
                    }
                }
            }
            open[0][0][0] = 0;
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    pq.offer(new int[]{0, 0, 0});
                } else {
                    pq.offer(temp[i - 1]);
                }
                while (!pq.isEmpty()) {
                    int[] cur = pq.poll();
                    if (cur[2] != open[cur[0]][cur[1]][i]) continue;
                    for (int d = 0; d < 4; d++) {
                        int nx = cur[0] + dx[d];
                        int ny = cur[1] + dy[d];
                        if (nx >= 0 && nx < N + 2 && ny >= 0 && ny < M + 2) {
                            if (board[nx][ny] == '.' && open[nx][ny][i] > cur[2]) {
                                open[nx][ny][i] = cur[2];
                                pq.offer(new int[]{nx, ny, open[nx][ny][i]});
                            } else if (board[nx][ny] == '#' && open[nx][ny][i] > cur[2] + 1) {
                                open[nx][ny][i] = cur[2] + 1;
                                pq.offer(new int[]{nx, ny, open[nx][ny][i]});
                            }
                        }
                    }
                }
            }
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < N + 2; i++) {
                for (int j = 0; j < M + 2; j++) {
                    if (board[i][j] == '#')
                        ans = Math.min(ans, open[i][j][0] + open[i][j][1] + open[i][j][2] - 2);
                    else
                        ans = Math.min(ans, open[i][j][0] + open[i][j][1] + open[i][j][2]);
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
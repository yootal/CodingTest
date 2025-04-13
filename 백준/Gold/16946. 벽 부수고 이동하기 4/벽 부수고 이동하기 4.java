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
        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = row.charAt(j) - '0';
            }
        }
        int[][] count = new int[N][M];
        ArrayDeque<int[]> q;
        ArrayList<int[]> al;
        int idx = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] != 1 && count[i][j] == 0) {
                    int cnt = 1;
                    board[i][j] = -idx;
                    q = new ArrayDeque<>();
                    al = new ArrayList<>();
                    q.offer(new int[]{i, j});
                    al.add(new int[]{i, j});
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        for (int d = 0; d < 4; d++) {
                            int nx = cur[0] + dx[d];
                            int ny = cur[1] + dy[d];
                            if (nx >= 0 && ny >= 0 && nx < N && ny < M && board[nx][ny] == 0) {
                                board[nx][ny] = -idx;
                                cnt++;
                                al.add(new int[]{nx, ny});
                                q.offer(new int[]{nx, ny});
                            }
                        }
                    }
                    for (int[] cur : al) {
                        count[cur[0]][cur[1]] = cnt;
                    }
                    idx++;
                }
            }
        }
        HashSet<Integer> set;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1) {
                    set = new HashSet<>();
                    int cnt = 1;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx >= 0 && ny >= 0 && nx < N && ny < M && board[nx][ny] != 1 && !set.contains(-board[nx][ny])) {
                            cnt += count[nx][ny];
                            set.add(-board[nx][ny]);
                        }
                    }
                    count[i][j] = cnt % 10;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1) {
                    sb.append(count[i][j]);
                } else {
                    sb.append(0);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

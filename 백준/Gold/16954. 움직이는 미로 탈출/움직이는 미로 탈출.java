import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[8][8];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{7, 0, 0});
        int wallCnt = 0;
        for (int i = 0; i < 8; i++) {
            String row = br.readLine();
            for (int j = 0; j < 8; j++) {
                if (row.charAt(j) == '#') {
                    board[i][j] = 1;
                    q.offer(new int[]{i, j, 1});
                    wallCnt++;
                } else {
                    board[i][j] = 0;
                }
            }
        }
        boolean check = false;
        ArrayDeque<int[]> q2 = new ArrayDeque<>();
        int tempCnt = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[2] == 0) {
                if (cur[0] == 0) {
                    check = true;
                    break;
                }
                if (board[cur[0]][cur[1]] == 1) continue;
                for (int d = 0; d < 8; d++) {
                    int nx = cur[0] + dx[d];
                    int ny = cur[1] + dy[d];
                    if (nx < 0 || ny < 0 || nx >= 8 || ny >= 8) continue;
                    if (board[nx][ny] == 0) {
                        q.offer(new int[]{nx, ny, cur[2]});
                    }
                }
                q.offer(new int[]{cur[0], cur[1], cur[2]});
            } else {
                board[cur[0]][cur[1]] = 0;
                int nx = cur[0] + 1;
                if (nx >= 8) {
                    wallCnt--;
                } else {
                    q.offer(new int[]{nx, cur[1], cur[2]});
                    q2.offer(new int[]{nx, cur[1]});
                    tempCnt++;
                }
            }
            if (tempCnt == wallCnt) {
                while (!q2.isEmpty()) {
                    int[] cur2 = q2.poll();
                    board[cur2[0]][cur2[1]] = 1;
                }
                tempCnt = 0;
            }
        }
        System.out.println(check ? 1 : 0);
    }
}
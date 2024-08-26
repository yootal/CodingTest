import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] mirror;
    static int[] ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        mirror = new int[N + 2][M + 2];
        int num = 0;
        for (int i = 1; i <= N; i++) mirror[i][0] = --num;
        for (int i = 1; i <= M; i++) mirror[N + 1][i] = --num;
        for (int i = N; i >= 1; i--) mirror[i][M + 1] = --num;
        for (int i = M; i >= 1; i--) mirror[0][i] = --num;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                mirror[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = new int[-num];
        for (int i = 1; i <= N; i++) {
            if (mirror[i][0] != 0) {
                solve(i, 0, 1);
            }
        }
        for (int i = 1; i <= M; i++) {
            if (mirror[N + 1][i] != 0) {
                solve(N + 1, i, 0);
            }
        }
        for (int i = N; i >= 1; i--) {
            if (mirror[i][M + 1] != 0) {
                solve(i, M + 1, 3);
            }
        }
        for (int i = M; i >= 1; i--) {
            if (mirror[0][i] != 0) {
                solve(0, i, 2);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int v : ans) sb.append(v).append(" ");
        System.out.println(sb);
    }

    static void solve(int x, int y, int d) {
        int idx = -mirror[x][y];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (mirror[cur[0]][cur[1]] < 0 && mirror[cur[0]][cur[1]] != -idx) {
                ans[idx - 1] = -mirror[cur[0]][cur[1]];
                break;
            }
            int nx = cur[0] + dx[d];
            int ny = cur[1] + dy[d];
            if (mirror[nx][ny] == 1) {
                d = (d + (d % 2 == 0 ? 1 : -1) + 4) % 4;
            }
            q.offer(new int[]{nx, ny});
        }
    }
}
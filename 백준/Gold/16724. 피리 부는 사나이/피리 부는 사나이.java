import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static int[][] vis;
    static int idx;
    static int ans;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = row.charAt(j);
            }
        }
        vis = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (vis[i][j] != 0) continue;
                idx++;
                dfs(i, j);
            }
        }
        System.out.println(ans);
    }

    static void dfs(int x, int y) {
        vis[x][y] = idx;
        if (map[x][y] == 'U') {
            int nx = x + dx[0];
            int ny = y + dy[0];
            if (vis[nx][ny] == idx) {
                ans++;
                return;
            } else if (vis[nx][ny] != 0)
                return;
            dfs(nx, ny);
        } else if (map[x][y] == 'R') {
            int nx = x + dx[1];
            int ny = y + dy[1];
            if (vis[nx][ny] == idx) {
                ans++;
                return;
            } else if (vis[nx][ny] != 0)
                return;
            dfs(nx, ny);
        } else if (map[x][y] == 'D') {
            int nx = x + dx[2];
            int ny = y + dy[2];
            if (vis[nx][ny] == idx) {
                ans++;
                return;
            } else if (vis[nx][ny] != 0)
                return;
            dfs(nx, ny);
        } else if (map[x][y] == 'L') {
            int nx = x + dx[3];
            int ny = y + dy[3];
            if (vis[nx][ny] == idx) {
                ans++;
                return;
            } else if (vis[nx][ny] != 0)
                return;
            dfs(nx, ny);
        }
    }
}
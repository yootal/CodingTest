import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M, num, ans;
    static int[][] home, distance;
    static boolean[][][] vis;

    static class Info {
        int x, y, dist, from;

        public Info(int x, int y, int dist, int from) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.from = from;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        home = new int[N][M];
        int sx = -1, sy = -1;
        int ex = -1, ey = -1;
        num = 1;
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                char temp = row.charAt(j);
                if (temp == 'S') {
                    home[i][j] = 0;
                    sx = i;
                    sy = j;
                } else if (temp == 'E') {
                    ex = i;
                    ey = j;
                } else if (temp == 'X') {
                    home[i][j] = num++;
                } else if (temp == '.') {
                    home[i][j] = 0;
                } else {
                    home[i][j] = -1;
                }
            }
        }
        home[ex][ey] = num++;
        distance = new int[num][num];
        vis = new boolean[N][M][num];
        vis[sx][sy][0] = true;
        ArrayDeque<Info> q = new ArrayDeque<>();
        q.offer(new Info(sx, sy, 0, 0));
        while (!q.isEmpty()) {
            Info cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && home[nx][ny] != -1 && !vis[nx][ny][cur.from]) {
                    vis[nx][ny][cur.from] = true;
                    if (home[nx][ny] > 0) {
                        vis[nx][ny][home[nx][ny]] = true;
                        distance[cur.from][home[nx][ny]] = cur.dist + 1;
                        q.offer(new Info(nx, ny, 0, home[nx][ny]));
                    }
                    q.offer(new Info(nx, ny, cur.dist + 1, cur.from));
                }
            }
        }
        num--;
        ans = Integer.MAX_VALUE;
        solve(1, 0, 0);
        System.out.println(ans);
    }

    static void solve(int flag, int dist, int pre) {
        if (flag == ((1 << num) - 1)) {
            ans = Math.min(ans, dist + distance[pre][num]);
            return;
        }
        for (int i = 1; i < num; i++) {
            if ((flag & (1 << i)) == 0) {
                solve(flag | (1 << i), dist + distance[pre][i], i);
            }
        }
    }
}
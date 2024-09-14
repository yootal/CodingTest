import java.io.*;
import java.util.*;

public class Main {

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Point[] pos;
    static int[][] dp;
    // dp[i][j] : i,j = 각 경찰차 마지막 방문 번호, 이후 마지막 방문까지 최단 거리
    static int[][] route;
    static int W;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        W = Integer.parseInt(br.readLine());
        StringTokenizer st;
        pos = new Point[W + 2];
        dp = new int[W + 2][W + 2];
        route = new int[W + 2][W + 2];
        pos[0] = new Point(1, 1);
        pos[1] = new Point(N, N);
        for (int i = 0; i < W; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pos[i + 2] = new Point(x, y);
        }
        solve(0, 1);
        StringBuilder sb = new StringBuilder();
        sb.append(dp[0][1]).append("\n");
        int a = 0;
        int b = 1;
        for (int i = 2; i < W + 2; i++) {
            sb.append(route[a][b]).append("\n");
            if (route[a][b] == 1) {
                a = i;
            } else {
                b = i;
            }
        }
        System.out.println(sb);
    }

    static int solve(int a, int b) {
        if (dp[a][b] != 0)
            return dp[a][b];

        int nxt = Math.max(a, b) + 1;
        if (nxt == W + 2)
            return 0;

        int distA = solve(nxt, b) + calcDist(a, nxt);
        int distB = solve(a, nxt) + calcDist(b, nxt);
        if (distA < distB) {
            route[a][b] = 1;
            dp[a][b] = distA;
        } else {
            route[a][b] = 2;
            dp[a][b] = distB;
        }

        return dp[a][b];
    }

    static int calcDist(int from, int to) {
        Point A = pos[from];
        Point B = pos[to];
        return Math.abs(A.x - B.x) + Math.abs(A.y - B.y);
    }
}
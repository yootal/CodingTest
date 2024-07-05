import java.io.*;
import java.util.*;

class Main {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int N, M;
    static int[][] block, water;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()) + 2;
            M = Integer.parseInt(st.nextToken()) + 2;
            block = new int[N][M];
            water = new int[N][M];
            for (int i = 1; i < N - 1; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j < M - 1; j++) {
                    block[i][j] = Integer.parseInt(st.nextToken());
                    water[i][j] = Integer.MAX_VALUE;
                }
            }
            fill();
            int ans = 0;
            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < M - 1; j++) {
                    ans += water[i][j] - block[i][j];
                }
            }
            sb.append("Case #").append(tc).append(": ").append(ans).append("\n");
        }
        System.out.print(sb);
    }

    static void fill() {
        while (true) {
            boolean check = true;
            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < M - 1; j++) {
                    if (block[i][j] == water[i][j])
                        continue;
                    int minH = Integer.MAX_VALUE;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        minH = Math.min(minH, water[nx][ny]);
                    }
                    if (water[i][j] > minH) {
                        water[i][j] = Math.max(block[i][j], minH);
                        check = false;
                    }
                }
            }
            if (check)
                break;
        }
    }
}
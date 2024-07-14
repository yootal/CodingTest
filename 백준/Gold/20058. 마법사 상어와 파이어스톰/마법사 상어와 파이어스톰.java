import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] ice;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = 1 << (Integer.parseInt(st.nextToken()));
        int Q = Integer.parseInt(st.nextToken());
        ice = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                ice[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int L = Integer.parseInt(st.nextToken());
            magic(L);
            melt();
        }
        int totalCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                totalCnt += ice[i][j];
            }
        }
        int biggestSize = count();
        System.out.println(totalCnt);
        System.out.println(biggestSize);
    }

    static int count() {
        int biggestSize = 0;
        boolean[][] vis = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!vis[i][j] && ice[i][j] > 0) {
                    int tempCnt = 1;
                    vis[i][j] = true;
                    ArrayDeque<int[]> q = new ArrayDeque<>();
                    q.offer(new int[]{i, j});
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        for (int d = 0; d < 4; d++) {
                            int nx = cur[0] + dx[d];
                            int ny = cur[1] + dy[d];
                            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !vis[nx][ny] && ice[nx][ny] > 0) {
                                vis[nx][ny] = true;
                                tempCnt++;
                                q.offer(new int[]{nx, ny});
                            }
                        }
                    }
                    biggestSize = Math.max(biggestSize, tempCnt);
                }
            }
        }
        return biggestSize;
    }

    static void magic(int l) {
        int w = 1 << l;
        int[][] temp;
        for (int i = 0; i < N; i += w) {
            for (int j = 0; j < N; j += w) {
                temp = new int[w][w];
                for (int i2 = 0; i2 < w; i2++) {
                    for (int j2 = 0; j2 < w; j2++) {
                        temp[j2][w - i2 - 1] = ice[i2 + i][j2 + j];
                    }
                }
                for (int i2 = 0; i2 < w; i2++) {
                    System.arraycopy(temp[i2], 0, ice[i2 + i], j, w);
                }
            }
        }
    }

    static void melt() {
        int[][] tempIce = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (ice[i][j] > 0) {
                    int cnt = 0;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx >= 0 && nx < N && ny >= 0 && ny < N && ice[nx][ny] > 0) {
                            cnt++;
                        }
                        if (cnt < 3) {
                            tempIce[i][j] = ice[i][j] - 1;
                        } else
                            tempIce[i][j] = ice[i][j];
                    }
                }
            }
        }
        ice = tempIce;
    }
}
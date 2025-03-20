import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[] height = new int[N * M];
        Arrays.fill(height, H);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int[][] col = new int[N + 1][M];
        for (int i = 0; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                col[i][j] = Integer.parseInt(st.nextToken());
                if ((i == 0 || i == N) && col[i][j] != -1) {
                    if (i == 0 && height[j] > col[i][j]) {
                        height[j] = col[i][j];
                        pq.offer(new int[]{j, col[i][j]}); // 몇 번째 블록의 높이 몇
                    } else if (i == N && height[M * (i - 1) + j] > col[i][j]) {
                        height[M * (i - 1) + j] = col[i][j];
                        pq.offer(new int[]{M * (i - 1) + j, col[i][j]});
                    }
                    col[i][j] = -1;
                }
            }
        }
        int[][] row = new int[N][M + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M + 1; j++) {
                row[i][j] = Integer.parseInt(st.nextToken());
                if ((j == 0 || j == M) && row[i][j] != -1) {
                    if (j == 0 && height[M * i] > row[i][j]) {
                        height[M * i] = row[i][j];
                        pq.offer(new int[]{M * i, row[i][j]});
                    } else if (j == M && height[M * (i + 1) - 1] > row[i][j]) {
                        height[M * (i + 1) - 1] = row[i][j];
                        pq.offer(new int[]{M * (i + 1) - 1, row[i][j]});
                    }
                    row[i][j] = -1;
                }
            }
        }
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int idx = cur[0];
            int h = cur[1];
            if (h != height[idx]) continue;
            int colX = idx / M;
            int colY = idx % M;
            int rowX = idx / M;
            int rowY = idx % M;
            // 상
            if (col[colX][colY] != -1) {
                int curH = Math.max(col[colX][colY], h);
                if (height[idx - M] > curH) {
                    height[idx - M] = curH;
                    pq.offer(new int[]{idx - M, height[idx - M]});
                }
            }
            // 하
            if (col[colX + 1][colY] != -1) {
                int curH = Math.max(col[colX + 1][colY], h);
                if (height[idx + M] > curH) {
                    height[idx + M] = curH;
                    pq.offer(new int[]{idx + M, height[idx + M]});
                }
            }
            // 좌
            if (row[rowX][rowY] != -1) {
                int curH = Math.max(row[rowX][rowY], h);
                if (height[idx - 1] > curH) {
                    height[idx - 1] = curH;
                    pq.offer(new int[]{idx - 1, height[idx - 1]});
                }
            }
            // 우
            if (row[rowX][rowY + 1] != -1) {
                int curH = Math.max(row[rowX][rowY + 1], h);
                if (height[idx + 1] > curH) {
                    height[idx + 1] = curH;
                    pq.offer(new int[]{idx + 1, height[idx + 1]});
                }
            }
        }
        int total = 0;
        for (int i = 0; i < N * M; i++) {
            total += height[i];
        }
        System.out.println(total);
    }
}

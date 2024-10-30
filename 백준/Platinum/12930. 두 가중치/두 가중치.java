import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] weight1 = new int[N][N];
        int[][] weight2 = new int[N][N];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < N; j++) {
                char w = row.charAt(j);
                if (w == '.') continue;
                weight1[i][j] = w - '0';
            }
        }
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < N; j++) {
                char w = row.charAt(j);
                if (w == '.') continue;
                weight2[i][j] = w - '0';
            }
        }
        int[][] dist = new int[9 * N + 1][N];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (int i = 0; i <= N * 9; i++) {
            Arrays.fill(dist[i], 100000);
        }
        dist[0][0] = 0;
        pq.offer(new int[]{0, dist[0][0], 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (dist[cur[2]][cur[0]] != cur[1]) continue;
            for (int i = 0; i < N; i++) {
                int w1 = weight1[cur[0]][i];
                int w2 = weight2[cur[0]][i];
                if (w1 == 0 || w2 == 0) continue;
                int nxtW2 = cur[2] + w2;
                if (dist[nxtW2][i] > cur[1] + w1) {
                    for (int j = nxtW2 + 1; j <= N * 9; j++) {
                        if (dist[j][i] <= cur[1] + w1) break;
                        dist[j][i] = cur[1] + w1;
                    }
                    dist[nxtW2][i] = cur[1] + w1;
                    pq.offer(new int[]{i, dist[nxtW2][i], nxtW2});
                }
            }
        }
        int temp = (9 * N) * (9 * N) + 1;
        int ans = temp;
        for (int i = 1; i <= 9 * N; i++) {
            ans = Math.min(ans, dist[i][1] * i);
        }
        System.out.println(ans == temp ? -1 : ans);
    }
}
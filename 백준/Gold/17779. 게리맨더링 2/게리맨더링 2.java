import java.io.*;
import java.util.*;

public class Main {

    static int N, ans = Integer.MAX_VALUE, total;
    static int[][] score;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        score = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
                total += score[i][j];
            }
        }
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                for (int d1 = 1; d1 < N; d1++) {
                    for (int d2 = 1; d2 < N; d2++) {
                        if (x + d1 + d2 >= N) continue;
                        if (y - d1 < 0 || y + d2 >= N) continue;
                        count(x, y, d1, d2);
                    }
                }
            }
        }
        System.out.println(ans);
    }

    static void count(int x, int y, int d1, int d2) {
        boolean[][] check = new boolean[N][N];
        for (int i = 0; i <= d1; i++) {
            check[x + i][y - i] = true;
            check[x + d2 + i][y + d2 - i] = true;
        }
        for (int j = 0; j <= d2; j++) {
            check[x + j][y + j] = true;
            check[x + d1 + j][y - d1 + j] = true;
        }
        int[] cnt = new int[5];
        // 1
        for (int i = 0; i < x + d1; i++) {
            for (int j = 0; j <= y; j++) {
                if (check[i][j]) break;
                cnt[0] += score[i][j];
            }
        }
        // 2
        for (int i = 0; i <= x + d2; i++) {
            for (int j = N - 1; j > y; j--) {
                if (check[i][j]) break;
                cnt[1] += score[i][j];
            }
        }
        //3
        for (int i = x + d1; i < N; i++) {
            for (int j = 0; j < y - d1 + d2; j++) {
                if (check[i][j]) break;
                cnt[2] += score[i][j];
            }
        }
        //4
        for (int i = x + d2 + 1; i < N; i++) {
            for (int j = N - 1; j >= y - d1 + d2; j--) {
                if (check[i][j]) break;
                cnt[3] += score[i][j];
            }
        }
        cnt[4] = total - cnt[0] - cnt[1] - cnt[2] - cnt[3];
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < 5; i++) {
            min = Math.min(cnt[i], min);
            max = Math.max(cnt[i], max);
        }
        ans = Math.min(ans, max - min);
    }
}

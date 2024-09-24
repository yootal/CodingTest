import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] paper = new int[N][M];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                paper[i][j] = row.charAt(j) - '0';
            }
        }
        int ans = 0;
        for (int k = 0; k < (1 << (N * M)); k++) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                int cur = 0;
                for (int j = 0; j < M; j++) {
                    int temp = i * M + j;
                    if ((k & (1 << temp)) == 0) {
                        cur *= 10;
                        cur += paper[i][j];
                    } else {
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }
            for (int j = 0; j < M; j++) {
                int cur = 0;
                for (int i = 0; i < N; i++) {
                    int temp = i * M + j;
                    if ((k & (1 << temp)) != 0) {
                        cur *= 10;
                        cur += paper[i][j];
                    } else {
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);
    }
}
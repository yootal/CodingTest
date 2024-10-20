import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] num = new int[N];
        int[][] sum = new int[N][N]; // a ~ b 구간의 합
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            sum[i][i] = num[i]; // 한 칸 초기화
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                sum[j][i] = sum[j][i - 1] + num[i]; // 구간 합 초기화
            }
        }
        int[][] dp = new int[N][M + 1]; // a가 마지막인 b개의 그룹 최대 값
        for (int[] row : dp) {
            Arrays.fill(row, -100000000);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][1] = Math.max(dp[i][1], sum[j][i]); // 그룹 하나에 대한 최대 값
            }
        }
        for (int k = 2; k <= M; k++) { // 그룹 개수
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < i; j++) {
                    for (int r = j + 1; r <= i; r++) {
                        // 하나 적은 그룹 수의 최대 값 + 이후 가장 큰 그룹 값
                        dp[i][k] = Math.max(dp[i][k], dp[j][k - 1] + sum[r][i]);
                    }
                }
            }
        }
        int ans = -Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, dp[i][M]); // M개 그룹의 최대 값
        }
        System.out.println(ans);
    }
}
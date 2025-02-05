import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < 3; tc++) {
            int N = Integer.parseInt(br.readLine());
            int M = 0;
            int[][] info = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int coin = Integer.parseInt(st.nextToken());
                int amount = Integer.parseInt(st.nextToken());
                M += coin * amount;
                info[i] = new int[]{coin, amount};
            }
            if (M % 2 != 0) {
                sb.append(0).append("\n");
            } else {
                boolean[][] dp = new boolean[N + 1][M / 2 + 1];
                dp[0][0] = true;
                for (int i = 1; i <= N; i++) {
                    int[] cur = info[i - 1];
                    for (int j = 0; j <= M / 2; j++) {
                        if (dp[i - 1][j]) {
                            for (int k = 0; k <= cur[1]; k++) {
                                int temp = j + cur[0] * k;
                                if (temp <= M / 2) {
                                    dp[i][temp] = true;
                                }
                            }
                        }
                    }
                }
                sb.append(dp[N][M / 2] ? 1 : 0).append("\n");
            }
        }
        System.out.print(sb);
    }
}
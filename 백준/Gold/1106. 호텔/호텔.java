import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] dp = new int[C + 100];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = cnt; j < C + 100; j++) {
                if (dp[j - cnt] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - cnt] + cost);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = C; i < C + 100; i++) {
            ans = Math.min(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
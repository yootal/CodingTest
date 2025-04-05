import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int[] height;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        height = new int[N];
        for (int i = 0; i < N; i++) {
            height[i] = Integer.parseInt(br.readLine());
        }
        dp = new long[N][1 << N];
        long ans = 0;
        for (int i = 0; i < N; i++) {
            long value = solve(1 << i, i);
            ans += value;
        }
        System.out.println(ans);
    }

    static long solve(int flag, int cur) {
        if (flag == (1 << N) - 1) return 1;
        if (dp[cur][flag] != 0) return dp[cur][flag];
        long cnt = 0;
        for (int j = 0; j < N; j++) {
            if ((flag & (1 << j)) == 0) {
                if (Math.abs(height[cur] - height[j]) > K) {
                    cnt += solve(flag | (1 << j), j);
                }
            }
        }
        dp[cur][flag] = cnt;
        return dp[cur][flag];
    }
}

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cost = new int[N];
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        BigInteger[] dp = new BigInteger[M + 1];
        Arrays.fill(dp, new BigInteger("-1"));
        for (int i = N - 1; i >= 0; i--) {
            int c = cost[i];
            for (int j = c; j <= M; j++) {
                dp[j] = max(dp[j], new BigInteger(String.valueOf(i)));
                dp[j] = max(dp[j], dp[j - c].multiply(BigInteger.TEN).add(BigInteger.valueOf(i)));
            }
        }
        System.out.println(dp[M].toString());
    }

    static BigInteger max(BigInteger a, BigInteger b) {
        return a.compareTo(b) >= 0 ? a : b;
    }

}
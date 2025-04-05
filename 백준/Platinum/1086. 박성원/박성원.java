import java.io.*;
import java.util.Arrays;

public class Main {

    static int N, K;
    static String[] num;
    static int[] modArr, tenPow;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new String[N];
        for (int i = 0; i < N; i++) {
            num[i] = br.readLine();
        }
        K = Integer.parseInt(br.readLine());
        modArr = new int[N];
        tenPow = new int[51];
        for (int i = 0; i < N; i++) {
            modArr[i] = mod(num[i]);
        }
        tenPow[0] = 1 % K;
        for (int i = 1; i < 51; i++) {
            tenPow[i] = (tenPow[i - 1] * 10) % K;
        }
        dp = new long[K][1 << N];
        for (int i = 0; i < K; i++) {
            Arrays.fill(dp[i], -1);
        }
        long cnt = solve(0, 0);
        long total = factorial(N);
        if (cnt == 0) {
            System.out.println("0/1");
        } else {
            long gcd = gcd(cnt, total);
            System.out.println((cnt / gcd) + "/" + (total / gcd));
        }
    }

    static long solve(int mod, int flag) {
        if (flag == (1 << N) - 1) return mod == 0 ? 1 : 0;
        if (dp[mod][flag] != -1) return dp[mod][flag];
        long res = 0;
        for (int i = 0; i < N; i++) {
            if ((flag & (1 << i)) != 0) continue;
            int len = num[i].length();
            int newMod = (mod * tenPow[len] + modArr[i]) % K;
            res += solve(newMod, flag | (1 << i));
        }
        return dp[mod][flag] = res;
    }

    static int mod(String s) {
        int res = 0;
        for (char c : s.toCharArray()) {
            res = (res * 10 + (c - '0')) % K;
        }
        return res;
    }

    static long factorial(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++) res *= i;
        return res;
    }

    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}

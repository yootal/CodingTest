import java.io.*;

public class Main {

    static int N;
    static String[] word;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        word = new String[N + 1];
        for (int i = 1; i <= N; i++) {
            word[i] = br.readLine();
        }
        dp = new int[N + 1][1 << (N + 1)];
        System.out.println(solve(1, 0));
    }

    static int solve(int flag, int cur) {
        if (dp[cur][flag] != 0) return dp[cur][flag];
        for (int j = 1; j <= N; j++) {
            if ((flag & (1 << j)) == 0) {
                char s = word[j].charAt(0);
                if (cur == 0 || s == word[cur].charAt(word[cur].length() - 1)) {
                    dp[cur][flag] = Math.max(dp[cur][flag], solve(flag | (1 << j), j) + word[j].length());
                }
            }
        }
        return dp[cur][flag];
    }
}

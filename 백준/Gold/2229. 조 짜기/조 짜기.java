import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int max = num[i - 1];
            int min = num[i - 1];
            for (int j = i; j > 0; j--) {
                max = Math.max(max, num[j - 1]);
                min = Math.min(min, num[j - 1]);
                dp[i] = Math.max(dp[i], dp[j - 1] + (max - min));
            }
        }
        System.out.println(dp[N]);
    }
}
import java.util.*;
import java.io.*;

public class Main {
    static class Info {
        int t, p;

        public Info(int t, int p) {
            this.t = t;
            this.p = p;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Info[] infos = new Info[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            infos[i] = new Info(t, p);
        }
        int[] dp = new int[N + 1];
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }
            Info info = infos[i];
            int nxt = i + info.t;
            if (nxt <= N)
                dp[nxt] = Math.max(dp[nxt], max + info.p);
        }
        int ans = 0;
        for (int i = 0; i <= N; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
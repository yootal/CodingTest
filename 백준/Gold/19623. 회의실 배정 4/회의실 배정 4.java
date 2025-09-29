import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Info[] infos;
    static int[] dp;

    static class Info {
        int x, y, z;

        public Info(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        infos = new Info[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            infos[i] = new Info(x, y, z);
        }
        Arrays.sort(infos, Comparator.<Info>comparingInt(info -> info.y).thenComparingInt(info -> info.x));
        dp = new int[N + 1];
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            int idx = lowerBound(i - 1);
            dp[i] = Math.max(dp[idx] + infos[i - 1].z, dp[i - 1]);
        }
        System.out.println(dp[N]);
    }

    static int lowerBound(int i) {
        int s = -1, e = N - 1;
        while (s + 1 < e) {
            int mid = (s + e) / 2;
            if (check(mid, i)) {
                s = mid;
            } else {
                e = mid;
            }
        }
        return e;
    }

    static boolean check(int mid, int i) {
        return infos[mid].y < infos[i].x;
    }
}
import java.io.*;
import java.util.*;

public class Main {
    static class Thing {
        int v, c;

        public Thing(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Thing> things = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            for (int j = K; j > 0; j >>= 1) {
                int cnt = j - (j >> 1);
                things.add(new Thing(V * cnt, C * cnt));
            }
        }
        int[][] dp = new int[things.size() + 1][M + 1];
        for (int i = 1; i <= things.size(); i++) {
            Thing cur = things.get(i - 1);
            int weight = cur.v;
            int score = cur.c;
            for (int j = 1; j <= M; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= weight) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - weight] + score);
                }
            }
        }
        System.out.println(dp[things.size()][M]);
    }
}
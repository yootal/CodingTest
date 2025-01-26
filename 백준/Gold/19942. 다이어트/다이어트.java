import java.io.*;
import java.util.*;

public class Main {
    static String ans;
    static boolean[] vis;
    static int[][] info;
    static int N, cost, mp, mf, ms, mv;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());
        info = new int[N][5];
        vis = new boolean[N];
        cost = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(0, 0, 0, 0, 0, 0);
        System.out.println(cost == Integer.MAX_VALUE ? -1 : cost);
        System.out.print(ans != null ? ans : "");
    }

    static void solve(int idx, int p, int f, int s, int v, int c) {
        if (p >= mp && f >= mf && s >= ms && v >= mv) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < N; i++) {
                if (vis[i]) {
                    temp.append(i + 1).append(" ");
                }
            }
            if (cost == c) {
                String tempString = temp.toString();
                int check = tempString.compareTo(ans);
                if (check < 0) {
                    ans = tempString;
                }
            } else if (cost > c) {
                cost = c;
                ans = temp.toString();
            }
            return;
        }
        if (idx == N) return;
        int[] cur = info[idx];
        vis[idx] = true;
        solve(idx + 1, p + cur[0], f + cur[1], s + cur[2], v + cur[3], c + cur[4]);
        vis[idx] = false;
        solve(idx + 1, p, f, s, v, c);
    }
}
import java.util.*;
import java.io.*;

public class Main {
    static int cnt;
    static int[] select;
    static boolean[] vis, cycle;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            select = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                select[i] = Integer.parseInt(st.nextToken());
            }
            vis = new boolean[n + 1];
            cycle = new boolean[n + 1];
            cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (!cycle[i]) {
                    solve(i);
                }
            }
            sb.append(n - cnt).append("\n");
        }
        System.out.print(sb);
    }

    static void solve(int idx) {
        if(cycle[idx]) return;
        if (vis[idx]) {
            cycle[idx] = true;
            cnt++;
        }
        vis[idx] = true;
        solve(select[idx]);
        cycle[idx] =true;
        vis[idx] = false;
    }
}
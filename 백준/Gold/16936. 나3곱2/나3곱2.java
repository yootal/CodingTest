import java.io.*;
import java.util.*;

public class Main {
    static ArrayDeque<Long> q;
    static boolean[] vis;
    static long[] num;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        num = new long[N];
        vis = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Long.parseLong(st.nextToken());
        }
        q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                vis[i] = true;
                q.add(num[i]);
                dfs(num[i]);
                vis[i] = false;
                q.pop();
            }
        }
    }

    static void dfs(long x) {
        if (q.size() == N) {
            StringBuilder sb = new StringBuilder();
            for (long v : q) {
                sb.append(v).append(" ");
            }
            System.out.print(sb);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!vis[i] && (x * 2L == num[i] || (x % 3 == 0 && x / 3 == num[i]))) {
                vis[i] = true;
                q.add(num[i]);
                dfs(num[i]);
                vis[i] = false;
                q.pop();
            }
        }
    }
}
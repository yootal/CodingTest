import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static Shark[] sharks;
    static int[] match;
    static boolean[] vis;

    static class Shark {
        int a, b, c;

        public Shark(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        sharks = new Shark[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            sharks[i] = new Shark(a, b, c);
        }
        match = new int[N];
        Arrays.fill(match, -1);
        System.out.println(N - solve());
    }

    static int solve() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                vis = new boolean[N];
                if (dfs(i)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static boolean dfs(int idx) {
        for (int i = 0; i < N; i++) {
            if (vis[i] || !limit(idx, i)) continue;
            vis[i] = true;
            if (match[i] == -1 || dfs(match[i])) {
                match[i] = idx;
                return true;
            }
        }
        return false;
    }

    static boolean limit(int a, int b) {
        if (a == b) return false;
        Shark s1 = sharks[a];
        Shark s2 = sharks[b];
        if (s1.a == s2.a && s1.b == s2.b && s1.c == s2.c) {
            return a < b;
        }
        return s1.a >= s2.a && s1.b >= s2.b && s1.c >= s2.c;
    }
}
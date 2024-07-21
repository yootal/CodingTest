import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph1;
    static ArrayList<Integer>[] graph2;
    static boolean[] vis;
    static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        graph1 = new ArrayList[N + 1];
        graph2 = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph1[i] = new ArrayList<>();
            graph2[i] = new ArrayList<>();
        }
        vis = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph1[a].add(b);
            graph2[b].add(a);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            vis = new boolean[N + 1];
            cnt = 1;
            dfs1(i);
            dfs2(i);
            sb.append(N - cnt).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs1(int x) {
        vis[x] = true;
        for (int nxt : graph1[x]) {
            if (!vis[nxt]) {
                dfs1(nxt);
                cnt++;
            }
        }
    }

    static void dfs2(int x) {
        vis[x] = true;
        for (int nxt : graph2[x]) {
            if (!vis[nxt]) {
                dfs2(nxt);
                cnt++;
            }
        }
    }
}
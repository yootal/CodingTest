import java.io.*;
import java.util.*;

public class Main {
    static int N, X, cnt;
    static ArrayList<Integer>[] graph;
    static boolean[] check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        int s = -1;
        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(st.nextToken());
            if (p == -1) {
                s = i;
                continue;
            }
            graph[p].add(i);
        }
        check = new boolean[N];
        X = Integer.parseInt(br.readLine());
        check[X] = true;
        dfs(s);
        System.out.println(cnt);
    }

    static void dfs(int idx) {
        boolean flag = false;
        if (!check[idx]) {
            for (int nxt : graph[idx]) {
                if (!check[nxt]) {
                    flag = true;
                    dfs(nxt);
                }
            }
            if (!flag) {
                cnt++;
            }
        }
    }
}
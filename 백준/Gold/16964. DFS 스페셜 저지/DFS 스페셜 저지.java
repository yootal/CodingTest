import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] num, idx, cnt;
    static ArrayList<Integer>[] graph;
    static boolean[] vis;
    static boolean flag;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        st = new StringTokenizer(br.readLine());
        num = new int[N];
        idx = new int[N + 1];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            idx[num[i]] = i;
        }
        cnt = new int[N + 1];
        vis = new boolean[N + 1];
        Arrays.fill(cnt, 1);
        count(1);
        vis = new boolean[N + 1];
        flag = false;
        dfs(1, 0);
        System.out.println(flag ? 0 : 1);
    }

    static int count(int x) {
        vis[x] = true;
        for (int nxt : graph[x]) {
            if (!vis[nxt]) {
                cnt[x] += count(nxt);
            }
        }
        return cnt[x];
    }

    static void dfs(int x, int st) {
        if (flag) return;
        vis[x] = true;
        for (int nxt : graph[x]) {
            if (!vis[nxt]) {
                if (st < idx[nxt] && idx[nxt] < st + cnt[x]) {
                    dfs(nxt, idx[nxt]);
                } else flag = true;
            }
        }
    }
}

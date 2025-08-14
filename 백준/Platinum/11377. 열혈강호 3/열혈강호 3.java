import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K;
    static int[] match;
    static boolean[] vis;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        match = new int[M + 1];
        Arrays.fill(match, -1);
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                graph[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        System.out.println(solve());
    }

    static int solve() {
        int cnt = 0;
        // 1 순환
        for (int i = 1; i <= N; i++) {
            vis = new boolean[M + 1];
            if (dfs(i)) cnt++;
        }
        // 2 순환
        int addCnt = 0;
        for (int i = 1; i <= N; i++) {
            vis = new boolean[M + 1];
            if (dfs(i)) {
                cnt++;
                addCnt++;
                if(addCnt == K) break;
            }
        }
        return cnt;
    }

    static boolean dfs(int idx) {
        for (int link : graph[idx]) {
            if (vis[link]) continue;
            vis[link] = true;
            if (match[link] == -1 || dfs(match[link])) {
                match[link] = idx;
                return true;
            }
        }
        return false;
    }
}
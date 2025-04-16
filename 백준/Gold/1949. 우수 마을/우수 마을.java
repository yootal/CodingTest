import java.io.*;
import java.util.*;

public class Main {

    static int[] info;
    static int[][] dp;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        info = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            info[i] = Integer.parseInt(st.nextToken());
        }
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
        dp = new int[N + 1][2];
        System.out.println(Math.max(solve(1, 0, 0), solve(1, 1, 0) + info[0]));
    }

    static int solve(int x, int flag, int pre) {
        if (dp[x][flag] != 0) return dp[x][flag];
        int value = 0;
        for (int nxt : graph[x]) {
            if (nxt != pre) {
                if (flag == 0) {
                    value += Math.max(solve(nxt, 0, x), solve(nxt, 1, x) + info[nxt - 1]);
                } else {
                    value += solve(nxt, 0, x);
                }
            }
        }
        dp[x][flag] = value;
        return dp[x][flag];
    }
}

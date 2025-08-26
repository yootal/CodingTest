import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] info;
    static int[][] dp;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        info = new int[N + 1];
        for (int i = 1; i <= N; i++) {
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
        System.out.println(Math.max(solve(1, 0, 1), solve(1, 1, 1) + info[1]));
    }

    static int solve(int idx, int flag, int pre) {
        if (dp[idx][flag] != 0) return dp[idx][flag];
        int value = 0;
        for (int nxt : graph[idx]) {
            if (nxt != pre) {
                if (flag == 1) {
                    value += solve(nxt, 0, idx);
                } else {
                    value += Math.max(solve(nxt, 0, idx), solve(nxt, 1, idx) + info[nxt]);
                }
            }
        }
        return dp[idx][flag] = value;
    }
}
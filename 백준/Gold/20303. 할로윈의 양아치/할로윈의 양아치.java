import java.io.*;
import java.util.*;

public class Main {
    static int[] parent, childCount, candyCount;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        parent = new int[N + 1];
        childCount = new int[N + 1];
        candyCount = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            childCount[i] = 1;
            candyCount[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }
        HashSet<Integer> set = new HashSet<>();
        ArrayList<int[]> al = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            int p = find(parent[i]);
            if (!set.contains(p)) {
                set.add(p);
                al.add(new int[]{childCount[p], candyCount[p]});
            }
        }
        int[][] dp = new int[al.size() + 1][K + 1];
        for (int i = 0; i <= al.size(); i++) {
            for (int j = 0; j < K; j++) {
                if (i == 0 || j == 0) continue;
                int[] cur = al.get(i - 1);
                if (j >= cur[0]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cur[0]] + cur[1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[al.size()][K - 1]);
    }

    static int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x < y) {
            parent[y] = x;
            childCount[x] += childCount[y];
            candyCount[x] += candyCount[y];
        } else if (x > y) {
            parent[x] = y;
            childCount[y] += childCount[x];
            candyCount[y] += candyCount[x];
        }
    }
}
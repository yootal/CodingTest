import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] tree;
    static ArrayList<Integer>[] pCheck;
    static int N, maxDepth, depth[], parent[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            tree = new ArrayList[N + 1];
            pCheck = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                tree[i] = new ArrayList<>();
                pCheck[i] = new ArrayList<>();
            }
            for (int i = 0; i < N - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                tree[a].add(b);
                pCheck[b].add(a);
            }
            int root = -1;
            for (int i = 1; i <= N; i++) {
                if (pCheck[i].isEmpty()) {
                    root = i;
                }
            }
            depth = new int[N + 1];
            maxDepth = (int) (Math.log(N) / Math.log(2));
            parent = new int[maxDepth + 1][N + 1];
            bfs(root);

            for (int i = 1; i <= maxDepth; i++) {
                for (int j = 1; j <= N; j++) {
                    parent[i][j] = parent[i - 1][parent[i - 1][j]];
                }
            }
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(lca(a, b)).append("\n");
        }
        System.out.print(sb);
    }

    static int lca(int a, int b) {
        if (depth[a] > depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        for (int i = maxDepth; i >= 0; i--) {
            if (Math.pow(2, i) <= depth[b] - depth[a]) {
                if (depth[a] <= depth[parent[i][b]]) {
                    b = parent[i][b];
                }
            }
        }
        for (int i = maxDepth; i >= 0; i--) {
            if (parent[i][a] != parent[i][b]) {
                a = parent[i][a];
                b = parent[i][b];
            }
        }
        int result = a;
        if (a != b) {
            result = parent[0][result];
        }
        return result;
    }

    static void bfs(int root) {
        boolean vis[] = new boolean[N + 1];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(root);
        vis[root] = true;
        int level = 1;
        int size = 1;
        int count = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nxt : tree[cur]) {
                if (!vis[nxt]) {
                    vis[nxt] = true;
                    q.offer(nxt);
                    parent[0][nxt] = cur;
                    depth[nxt] = level;
                }
            }
            count++;
            if (count == size) {
                count = 0;
                size = q.size();
                level++;
            }
        }
    }
}
import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;

    static class Edge implements Comparable<Edge> {
        int a, b, c;

        public Edge(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.c, o.c);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        Edge[] edge = new Edge[M];
        for (int i = 1; i <= N; i++) parent[i] = i;
        long total = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edge[i] = new Edge(a, b, c);
            total += c;
        }
        Arrays.sort(edge);
        int cnt = 0;
        long dist = 0;
        for (int i = 0; i < M; i++) {
            if (union(edge[i].a, edge[i].b)) {
                cnt++;
                dist += edge[i].c;
            }
        }
        System.out.println(cnt == N - 1 ? total - dist : -1);
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) {
            return false;
        } else {
            parent[y] = x;
            return true;
        }
    }

    static int find(int x) {
        if (x == parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }
}
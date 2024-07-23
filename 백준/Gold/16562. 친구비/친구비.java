import java.io.*;
import java.util.*;

public class Main {
    static int[] cost, parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        cost = new int[N + 1];
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        for (int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            union(v, w);
        }
        int price = 0;
        for (int i = 1; i <= N; i++) {
            if (i == parent[i]) price += cost[i];
        }
        System.out.println(price > K ? "Oh no" : price);
    }

    static void union(int x1, int x2) {
        x1 = find(x1);
        x2 = find(x2);
        if (cost[x1] > cost[x2]) {
            parent[x1] = x2;
        } else if (cost[x1] < cost[x2]) {
            parent[x2] = x1;
        } else {
            parent[x1] = x2;
        }
    }

    static int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
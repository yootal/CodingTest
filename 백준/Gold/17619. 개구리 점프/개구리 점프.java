import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    static class Info {
        int s, e, h, idx;

        public Info(int s, int e, int h, int idx) {
            this.s = s;
            this.e = e;
            this.h = h;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        Info[] infos = new Info[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            infos[i] = new Info(x1, x2, y, i + 1);
        }
        parent = new int[N + 1];
        Arrays.fill(parent, -1);
        Arrays.sort(infos, Comparator.comparingInt(o -> o.s));
        int end = -1;
        int par = -1;
        for (int i = 0; i < N; i++) {
            Info cur = infos[i];
            if (end == -1 || end < cur.s) {
                end = cur.e;
                par = cur.idx;
            } else {
                end = Math.max(end, cur.e);
                union(par, cur.idx);
            }
        }
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(find(a) == find(b) ? 1 : 0).append("\n");
        }
        System.out.print(sb);
    }

    static int find(int x) {
        if (parent[x] < 0) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return false;
        if (parent[py] < parent[px]) {
            int temp = px;
            px = py;
            py = temp;
        }
        if (parent[px] == parent[py]) {
            parent[px]--;
        }
        parent[py] = px;
        return true;
    }
}
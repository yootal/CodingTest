import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int a, b, c;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        Arrays.fill(parent, -1);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if (a == 0) {
                union(b, c);
            } else {
                if (find(b) == find(c)) {
                    sb.append("YES").append("\n");
                } else
                    sb.append("NO").append("\n");
            }
        }
        System.out.print(sb);
    }

    static int find(int x) {
        if (parent[x] < 0) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return false;
        if (parent[py] < parent[px]) {
            int temp = py;
            py = px;
            px = temp;
        }
        if (parent[px] == parent[py]) {
            parent[px]--;
        }
        parent[py] = px;
        return true;
    }
}
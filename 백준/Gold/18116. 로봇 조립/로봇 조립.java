import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] parent, size;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        parent = new int[1000001];
        size = new int[1000001];
        Arrays.fill(parent, -1);
        Arrays.fill(size, 1);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            int b = Integer.parseInt(st.nextToken());
            if (a == 'I') {
                int c = Integer.parseInt(st.nextToken());
                union(b, c);
            } else {
                sb.append(size[find(b)]).append("\n");
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
        size[px] += size[py];
        return true;
    }
}
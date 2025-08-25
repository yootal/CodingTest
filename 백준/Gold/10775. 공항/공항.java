import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        parent = new int[G + 1];
        Arrays.fill(parent, -1);
        int cnt = 0;
        for (int i = 0; i < P; i++) {
            int g = Integer.parseInt(br.readLine());
            if (find(g) == 0) break;
            if (union(find(g), find(g) - 1)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    static int find(int x) {
        if (parent[x] < 0) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return false;
        if (py < px) {
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
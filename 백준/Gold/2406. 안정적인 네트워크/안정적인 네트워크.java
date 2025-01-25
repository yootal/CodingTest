import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        ArrayList<int[]> al = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            al.add(new int[]{x, y, 0});
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int c = Integer.parseInt(st.nextToken());
                if (i == j || i == 1 || j == 1) continue;
                al.add(new int[]{i, j, c});
            }
        }
        al.sort(Comparator.comparingInt(o -> o[2]));
        int ans = 0;
        int link = 0;
        int newLink = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < al.size(); i++) {
            int[] cur = al.get(i);
            if (union(cur[0], cur[1])) {
                if (cur[2] != 0) {
                    ans += cur[2];
                    newLink++;
                    sb.append(Math.max(cur[0], cur[1])).append(" ").append(Math.min(cur[0], cur[1])).append("\n");
                }
                link++;
            }
            if (link == n - 2) break;
        }
        System.out.println(ans + " " + newLink);
        System.out.print(sb);
    }

    static int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) {
            return false;
        } else if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
        return true;
    }
}
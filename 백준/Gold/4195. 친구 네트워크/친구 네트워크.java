import java.io.*;
import java.util.*;

public class Main {
    static int[] parent, child;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            int F = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            parent = new int[F * 2];
            for (int i = 0; i < F * 2; i++) {
                parent[i] = i;
            }
            child = new int[F * 2];
            int idx = 0;
            for (int i = 0; i < F; i++) {
                st = new StringTokenizer(br.readLine());
                String A = st.nextToken();
                int idxA = 0;
                if (!map.containsKey(A)) {
                    idxA = idx++;
                    child[idxA] = 1;
                    map.put(A, idxA);
                } else {
                    idxA = map.get(A);
                }
                String B = st.nextToken();
                int idxB = 0;
                if (!map.containsKey(B)) {
                    idxB = idx++;
                    child[idxB] = 1;
                    map.put(B, idxB);
                } else {
                    idxB = map.get(B);
                }
                union(idxA, idxB);
            }
        }
        System.out.print(sb);
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
        if (x != y) {
            int px = Math.min(x, y);
            int py = Math.max(x, y);
            parent[py] = px;
            child[px] = child[px] + child[py];
            sb.append(child[px]).append("\n");
        } else {
            sb.append(child[x]).append("\n");
        }
    }
}
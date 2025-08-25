import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        int[][] cut = new int[M][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cut[i] = new int[]{x, y};
        }
        parent = new int[N + 1];
        Arrays.fill(parent, -1);
        Arrays.sort(cut, Comparator.comparingInt(o -> o[0]));
        int end = -1;
        int par = -1;
        int last = -1;
        for (int i = 0; i < M; i++) {
            int[] cur = cut[i];
            if (end < cur[0]) { // 다음 덩어리
                end = cur[1];
                par = cur[0];
                last = cur[0];
            }
            end = Math.max(end, cur[1]);
            if (last < end) {
                for (int j = last + 1; j <= end; j++) {
                    union(par, j);
                }
                last = end;
            }
        }
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (parent[i] < 0) cnt++;
        }
        System.out.print(cnt);
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
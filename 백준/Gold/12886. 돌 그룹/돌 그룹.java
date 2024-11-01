import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        System.out.println(check(A, B, C) ? 1 : 0);
    }

    static boolean check(int A, int B, int C) {
        if ((A + B + C) % 3 != 0) return false;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{A, B, C});
        boolean[][] vis = new boolean[1501][1501];
        vis[A][B] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == cur[1] && cur[1] == cur[2]) {
                return true;
            }
            int a = cur[0];
            int b = cur[1];
            int c = cur[2];
            if (a != b) {
                int na = a > b ? a - b : a + a;
                int nb = a > b ? b + b : b - a;
                if (!vis[na][nb]) {
                    q.offer(new int[]{na, nb, c});
                    vis[na][nb] = true;
                }
            }
            if (b != c) {
                int nb = b > c ? b - c : b + b;
                int nc = b > c ? c + c : c - b;
                if (!vis[nb][nc]) {
                    q.offer(new int[]{a, nb, nc});
                    vis[nb][nc] = true;
                }
            }
            if (a != c) {
                int na = a > c ? a - c : a + a;
                int nc = a > c ? c + c : c - a;
                if (!vis[na][nc]) {
                    q.add(new int[]{na, b, nc});
                    vis[na][nc] = true;
                }
            }
        }
        return false;
    }
}
import java.io.*;
import java.util.*;

public class Main {
    static long[] tree;

    public static void main(String[] args) throws Exception {
        int N = read();
        int M = read();
        int[][] edge = new int[M][2];
        for (int i = 0; i < M; i++) {
            edge[i][0] = read();
            edge[i][1] = read();
        }
        Arrays.sort(edge, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        int h = (int) Math.ceil(Math.log(N) / Math.log(2));
        int treeSize = 1 << (h + 1);
        tree = new long[treeSize];
        long ans = 0;
        for (int i = 0; i < M; i++) {
            change(1, 1, N, edge[i][1]);
            ans += query(1, 1, N, edge[i][1] + 1, N);
        }
        System.out.println(ans);
    }

    static void change(int node, int s, int e, int idx) {
        if (idx < s || idx > e) return;
        if (s == e) {
            tree[node] += 1;
            return;
        }
        change(node * 2, s, (s + e) / 2, idx);
        change(node * 2 + 1, (s + e) / 2 + 1, e, idx);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    static long query(int node, int s, int e, int l, int r) {
        if (l > e || r < s) {
            return 0;
        }
        if (l <= s && e <= r) {
            return tree[node];
        }
        long ls = query(node * 2, s, (s + e) / 2, l, r);
        long rs = query(node * 2 + 1, (s + e) / 2 + 1, e, l, r);
        return ls + rs;
    }

    private static int read() throws IOException {
        int n = 0;
        int i;
        while ((i = System.in.read()) <= ' ') {
            if (i == -1) return -1;
        }
        do {
            n = n * 10 + (i - '0');
        } while ((i = System.in.read()) > ' ');
        return n;
    }
}
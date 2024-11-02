import java.util.*;
import java.io.*;

public class Main {
    static int[] num, tree;
    static int range = 65535;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        int h = (int) Math.ceil(Math.log(range + 1) / Math.log(2));
        int treeSize = 1 << (h + 1);
        tree = new int[treeSize];
        for (int i = 0; i < K - 1; i++) {
            update(1, 0, range, num[i], 1);
        }
        int idx = 0;
        int midIdx = (K + 1) / 2;
        long total = 0;
        for (int i = K - 1; i < N; i++) {
            update(1, 0, range, num[i], 1);
            total += find(1, 0, range, midIdx);
            update(1, 0, range, num[idx++], -1);
        }
        System.out.println(total);
    }

    private static long find(int node, int start, int end, int target) {
        if (start == end) {
            return start;
        }
        int mid = (start + end) / 2;
        if (tree[node * 2] >= target) {
            return find(node * 2, start, mid, target);
        } else
            return find(node * 2 + 1, mid + 1, end, target - tree[node * 2]);
    }

    static void update(int node, int start, int end, int idx, int diff) {
        if (idx < start || idx > end) return;
        if (start == end) {
            tree[node] += diff;
            return;
        }
        int mid = (start + end) / 2;
        update(node * 2, start, mid, idx, diff);
        update(node * 2 + 1, mid + 1, end, idx, diff);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }
}
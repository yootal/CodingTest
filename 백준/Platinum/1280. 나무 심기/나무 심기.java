import java.io.*;

public class Main {
    static int[] num;
    static long[] cntTree, sumTree;
    static int range = 200000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        int h = (int) Math.ceil(Math.log(range) / Math.log(2));
        int treeSize = 1 << (h + 1);
        cntTree = new long[treeSize];
        sumTree = new long[treeSize];
        long total = 1;
        update(cntTree, 1, 0, range, num[0], 1);
        update(sumTree, 1, 0, range, num[0], num[0]);
        for (int i = 1; i < N; i++) {
            update(cntTree, 1, 0, range, num[i], 1);
            update(sumTree, 1, 0, range, num[i], num[i]);
            long lCnt = query(cntTree, 1, 0, range, 0, num[i] - 1);
            long rCnt = query(cntTree, 1, 0, range, num[i] + 1, range - 1);
            long lSum = query(sumTree, 1, 0, range, 0, num[i] - 1);
            long rSum = query(sumTree, 1, 0, range, num[i] + 1, range - 1);
            long lDist = lCnt * num[i] - lSum;
            long rDist = rSum - rCnt * num[i];
            total *= (lDist + rDist) % 1000000007;
            total %= 1000000007;
        }
        System.out.println(total);
    }

    static void update(long[] tree, int node, int start, int end, int idx, int diff) {
        if (idx < start || idx > end) return;
        if (start == end) {
            tree[node] += diff;
            return;
        }
        int mid = (start + end) / 2;
        update(tree, node * 2, start, mid, idx, diff);
        update(tree, node * 2 + 1, mid + 1, end, idx, diff);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    static long query(long[] tree, int node, int start, int end, int left, int right) {
        if (left > end || right < start)
            return 0;
        if (left <= start && right >= end) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        long lSum = query(tree, node * 2, start, mid, left, right);
        long rSum = query(tree, node * 2 + 1, mid + 1, end, left, right);
        return lSum + rSum;
    }
}
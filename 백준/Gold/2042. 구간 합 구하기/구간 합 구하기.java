import java.util.*;
import java.io.*;

public class Main {
    static long[] num, tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        M += K;
        num = new long[N];
        for (int i = 0; i < N; i++) {
            num[i] = Long.parseLong(br.readLine());
        }
        int h = (int) Math.ceil(Math.log(N) / Math.log(2));
        int tree_size = (1 << (h + 1));
        tree = new long[tree_size];
        init(1, 0, N - 1);
        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                int index = Integer.parseInt(st.nextToken());
                long val = Long.parseLong(st.nextToken());
                update(1, 0, N - 1, index - 1, val);
            } else {
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                sb.append(query(1, 0, N - 1, left - 1, right - 1)).append("\n");
            }
        }
        System.out.println(sb);
    }

    static void init(int node, int start, int end) {
        if (start == end) {
            tree[node] = num[start];
        } else {
            init(node * 2, start, (start + end) / 2);
            init(node * 2 + 1, (start + end) / 2 + 1, end);
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }
    }

    static long query(int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        long leftSum = query(node * 2, start, (start + end) / 2, left, right);
        long rightSum = query(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        return leftSum + rightSum;
    }

    static void update(int node, int start, int end, int index, long val) {
        if (index < start || index > end) {
            return;
        }
        if (start == end) {
            num[index] = val;
            tree[node] = val;
            return;
        }
        update(node * 2, start, (start + end) / 2, index, val);
        update(node * 2 + 1, (start + end) / 2 + 1, end, index, val);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }
}
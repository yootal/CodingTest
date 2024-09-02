import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] num;
    static int[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input == null || input.isEmpty()) break;
            StringTokenizer st = new StringTokenizer(input);
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            num = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int value = Integer.parseInt(st.nextToken());
                num[i] = Integer.compare(value, 0);
            }
            int h = (int) Math.ceil(Math.log(N) / Math.log(2));
            int treeSize = 1 << (h + 1);
            tree = new int[treeSize];
            init(1, 0, N - 1);
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                char cmd = st.nextToken().charAt(0);
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if (cmd == 'C') {
                    y = Integer.compare(y, 0);
                    update(1, 0, N - 1, x - 1, y);
                } else {
                    long value = query(1, 0, N - 1, x - 1, y - 1);
                    sb.append((value == 0) ? 0 : (value > 0) ? "+" : "-");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void init(int node, int start, int end) {
        if (start == end) {
            tree[node] = num[start];
        } else {
            init(node * 2, start, (start + end) / 2);
            init(node * 2 + 1, (start + end) / 2 + 1, end);
            tree[node] = tree[node * 2] * tree[node * 2 + 1];
        }
    }

    static long query(int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return 1;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        long lMul = query(node * 2, start, (start + end) / 2, left, right);
        long rMul = query(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        return lMul * rMul;
    }

    static void update(int node, int start, int end, int index, int val) {
        if (index < start || index > end) {
            return;
        }
        if (start == end) {
            if (val > 0) {
                val = 1;
            } else if (val < 0) {
                val = -1;
            }
            num[index] = val;
            tree[node] = val;
            return;
        }
        update(node * 2, start, (start + end) / 2, index, val);
        update(node * 2 + 1, (start + end) / 2 + 1, end, index, val);
        tree[node] = tree[node * 2] * tree[node * 2 + 1];
    }
}
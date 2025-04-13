import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] inorder, postorder, idx;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        inorder = new int[N];
        postorder = new int[N];
        idx = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
            idx[inorder[i]] = i;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }
        sb = new StringBuilder();
        dc(0, N - 1, 0, N - 1);
        System.out.print(sb);
    }

    static void dc(int is, int ie, int ps, int pe) {
        if (is > ie || ps > pe) return;
        int root = postorder[pe];
        sb.append(root).append(" ");
        int midIdx = idx[root];
        int len = midIdx - is - 1;
        dc(is, midIdx - 1, ps, ps + len);
        dc(midIdx + 1, ie, ps + len + 1, pe - 1);
    }
}

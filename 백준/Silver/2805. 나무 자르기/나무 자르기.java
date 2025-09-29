import java.io.*;
import java.util.*;

public class Main {
    static int[] trees;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        trees = new int[N];
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        int s = 0, e = 10_0000_0000;
        while (s + 1 < e) {
            int mid = (s + e) / 2;
            if (check(mid, M)) {
                s = mid;
            } else {
                e = mid;
            }
        }
        System.out.println(s);
    }

    static boolean check(int mid, int M) {
        long sum = 0;
        for (int tree : trees) {
            if (tree > mid) {
                sum += tree - mid;
            }
        }
        return sum >= M;
    }
}
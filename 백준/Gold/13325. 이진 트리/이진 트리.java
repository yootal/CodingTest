import java.util.*;
import java.io.*;

public class Main {
    static int K;
    static int[] weights, diff;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int temp = 2;
        int size = 0;
        for (int i = 0; i < K; i++) {
            size += temp;
            temp *= 2;
        }
        weights = new int[size + 1];
        int sum = 0;
        for (int i = 1; i <= size; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
            sum += weights[i];
        }
        diff = new int[1 << (K + 1)];
        solve(1, 0);
        int ans = sum;
        for (int i = 1; i < 1 << (K + 1); i++) {
            ans += diff[i];
        }
        System.out.println(ans);
    }

    static int solve(int idx, int floor) {
        if (floor == K) return 0;
        int v1 = solve(idx * 2, floor + 1) + weights[idx * 2 - 1];
        int v2 = solve(idx * 2 + 1, floor + 1) + weights[idx * 2];
        int max = Math.max(v1, v2);
        diff[idx] = max * 2 - v1 - v2;
        return max;
    }
}
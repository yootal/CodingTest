import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int[] cost;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        cost = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(binarySearch());
    }

    static int binarySearch() {
        int s = 1, e = 1000000000;
        while (s < e) {
            int mid = (s + e) / 2;
            int cnt = 0;
            boolean flag = false;
            for (int i = 0; i < N; i++) {
                if (cost[i] <= mid) {
                    cnt = 0;
                } else {
                    cnt++;
                    if (cnt == K) {
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag) {
                e = mid;
            } else
                s = mid + 1;
        }
        return s;
    }
}
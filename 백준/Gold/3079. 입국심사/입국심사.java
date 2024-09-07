import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] time;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        time = new int[N];
        for (int i = 0; i < N; i++) time[i] = Integer.parseInt(br.readLine());
        Arrays.sort(time);
        System.out.println(binarySearch());
    }

    static long binarySearch() {
        long s = 0, e = (long) time[N - 1] * M;
        long ans = e;
        while (s <= e) {
            long mid = (s + e) / 2;
            long cnt = 0;
            for (int i = 0; i < N; i++) {
                if (cnt >= M) break;
                cnt += mid / time[i];
            }
            if (cnt >= M) {
                e = mid - 1;
                ans = Math.min(mid, ans);
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }
}
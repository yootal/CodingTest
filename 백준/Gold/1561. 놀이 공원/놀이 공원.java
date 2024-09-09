import java.util.*;
import java.io.*;

public class Main {
    static int N, M, ans;
    static long temp;
    static int[] time;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        time = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }
        if (N > M) {
            binarySearch();
        } else {
            ans = N;
        }
        System.out.println(ans);
    }

    static void binarySearch() {
        long s = 0, e = N * 30L;
        while (s < e) {
            long mid = (s + e) / 2;
            long cnt = count(mid);
            if (cnt + temp >= N) {
                for (int idx = 0; idx < M; idx++) {
                    if (mid % time[idx] == 0) {
                        cnt++;
                        if (cnt == N) {
                            ans = idx + 1;
                            break;
                        }
                    }
                }
                e = mid;
            } else {
                s = mid + 1;
            }
        }
    }

    static long count(long mid) {
        temp = 0;
        long total = 0;
        for (int i = 0; i < M; i++) {
            long value = mid / time[i];
            if (mid % time[i] == 0) {
                temp++;
            } else {
                value++;
            }
            total += value;
        }
        return total;
    }
}
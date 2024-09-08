import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        System.out.println(binarySearch());
    }

    static long binarySearch() {
        int s = 0, e = 10000;
        while (s < e) {
            int mid = (s + e) / 2;
            if (count(mid) <= M) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }

    static int count(int mid) {
        int cnt = 1;
        int min = arr[0], max = arr[0];
        for (int i = 0; i < N; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            if (max - min > mid) {
                cnt++;
                min = arr[i];
                max = arr[i];
            }
        }
        return cnt;
    }
}
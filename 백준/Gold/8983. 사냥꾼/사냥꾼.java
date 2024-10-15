import java.util.*;
import java.io.*;

public class Main {
    static int N, M, L;
    static int[] num;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) num[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(num);
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (binarySearch(x, y)) cnt++;
        }
        System.out.println(cnt);
    }

    static boolean binarySearch(int x, int y) {
        int s = 0, e = N - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            int idx = num[mid];
            int dist = Math.abs(idx - x) + y;
            if (dist <= L) {
                return true;
            }
            else {
                int diff = idx - x;
                if (diff > 0) {
                    e = mid - 1;
                } else if (diff < 0) {
                    s = mid + 1;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
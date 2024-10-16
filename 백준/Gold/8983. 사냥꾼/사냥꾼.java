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
        num = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) num[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(num);
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int idx = upperIdx(x);
            if (L >= Math.min(Math.abs(num[idx - 1 < 0 ? idx : idx - 1] - x), Math.abs(num[idx % M] - x)) + y) cnt++;
        }
        System.out.println(cnt);
    }

    static int upperIdx(int target) {
        int s = 0, e = M;
        while (s < e) {
            int mid = (s + e) / 2;
            int pos = num[mid];
            if (pos > target) e = mid;
            else s = mid + 1;
        }
        return s;
    }
}
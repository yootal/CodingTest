import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] num = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            sum += num[i];
        }
        int s = 0, e = sum;
        int ans = 0;
        while (s <= e) {
            int mid = (s + e) / 2;
            int cnt = 0;
            int temp = 0;
            for (int i = 0; i < N; i++) {
                temp += num[i];
                if (temp >= mid) {
                    temp = 0;
                    cnt++;
                }
            }
            if (cnt == K) {
                ans = Math.max(ans, mid);
            }
            if (cnt < K) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        System.out.println(ans);
    }
}
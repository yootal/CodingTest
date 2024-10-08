import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[N];
        int[] num2 = new int[N];
        int[] prefix1 = new int[N + 1];
        int[] prefix2 = new int[N + 1];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            num2[N - i - 1] = num[i];
            prefix1[i + 1] = prefix1[i] + num[i];
        }
        for (int i = 0; i < N; i++) {
            prefix2[i + 1] = prefix2[i] + num2[i];
        }
        int ans = 0;
        if (N == 3) {
            for (int i = 0; i < N; i++) {
                ans = Math.max(ans, num[i] * 2);
            }
        } else {
            for (int i = 1; i < N; i++) {
                ans = Math.max(ans, prefix1[N] - num[0] - num[i] + (prefix1[N] - prefix1[i + 1]));
                ans = Math.max(ans, prefix2[N] - num2[0] - num2[i] + (prefix2[N] - prefix2[i + 1]));
            }
        }
        System.out.println(ans);
    }
}
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static long S, ans;
    static long[] num;
    static HashMap<Long, Long> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Long.parseLong(st.nextToken());
        num = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        record1(0, 0);
        record2(N / 2, 0);
        System.out.println((S == 0) ? ans - 1 : ans);
    }

    static void record1(int idx, long sum) {
        if (idx == N / 2) {
            map.compute(sum, (k, v) -> (v == null) ? 1 : v + 1);
            return;
        }
        record1(idx + 1, sum);
        record1(idx + 1, sum + num[idx]);
    }

    static void record2(int idx, long sum) {
        if (idx == N) {
            if (map.containsKey(S - sum)) {
                ans += map.get(S - sum);
            }
            return;
        }
        record2(idx + 1, sum);
        record2(idx + 1, sum + num[idx]);
    }
}

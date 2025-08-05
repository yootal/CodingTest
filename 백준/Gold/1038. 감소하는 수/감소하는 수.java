import java.io.*;
import java.util.*;

public class Main {
    static int N, cnt;
    static long ans = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i <= 10; i++) {
            bt(0, i);
        }
        System.out.println(ans);
    }

    static void bt(long num, int idx) {
        if (idx == 0) {
            if (cnt == N) {
                ans = num;
            }
            cnt++;
            return;
        }
        int last = (int) num % 10;
        if (num == 0) last = 10;
        for (int i = 0; i < last; i++) {
            long next = (num * 10) + i;
            if (num == 0 && i == 0) continue;
            bt(next, idx - 1);
        }
    }
}
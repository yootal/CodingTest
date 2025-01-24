import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long atk = Long.parseLong(st.nextToken());
        long[][] val = new long[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            val[i][0] = Long.parseLong(st.nextToken());
            val[i][1] = Long.parseLong(st.nextToken());
            val[i][2] = Long.parseLong(st.nextToken());
        }
        long s = 1;
        long e = 100000000000000000L;
        while (s < e) {
            long mid = (s + e) / 2;
            long cMid = mid;
            long cAtk = atk;
            boolean flag = false;
            for (int i = 0; i < N; i++) {
                long ca = val[i][1];
                long ch = val[i][2];

                if (val[i][0] == 1) {
                    long requiredHits = (ch + cAtk - 1) / cAtk;
                    long remainingHits = (cMid + ca - 1) / ca;
                    if (remainingHits >= requiredHits) {
                        cMid -= ca * (requiredHits - 1);
                    } else {
                        flag = true;
                    }
                } else {
                    cAtk += ca;
                    cMid += ch;
                    if (cMid > mid)
                        cMid = mid;
                }
                if (flag) break;
            }
            if (flag) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        System.out.println(s);
    }
}
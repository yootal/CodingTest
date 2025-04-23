import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int g = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        String W = br.readLine();
        int[] gCnt = new int[52];
        for (int i = 0; i < g; i++) {
            int idx = idx(W.charAt(i));
            gCnt[idx]++;
        }
        String S = br.readLine();
        int[] cnt = new int[52];
        int end = 0;
        int ans = 0;
        for (int start = 0; start < s; start++) {
            while (end - start < g && end != s) {
                int idx = idx(S.charAt(end));
                cnt[idx]++;
                end++;
            }
            boolean flag = true;
            for (int i = 0; i < g; i++) {
                int idx = idx(S.charAt(start + i));
                if (cnt[idx] != gCnt[idx]) {
                    flag = false;
                    break;
                }
            }
            if (flag) ans++;
            if (end == s) break;
            int idx = idx(S.charAt(start));
            cnt[idx]--;
        }
        System.out.println(ans);
    }

    static int idx(char c) {
        if (c >= 'a') {
            return c - 'a' + 26;
        } else {
            return c - 'A';
        }
    }
}

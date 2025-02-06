import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int[][][][] dp = new int[3][3][3][3];
        int t = 0, g = 0, f = 0, p = 0, cnt = 0;
        dp[0][0][0][0] = 1; 
        for (int i = 0; i < N; i++) {
            char c = str.charAt(i);
            if (c == 'T') {
                t = (t + 1) % 3;
            } else if (c == 'G') {
                g = (g + 1) % 3;
            } else if (c == 'F') {
                f = (f + 1) % 3;
            } else {
                p = (p + 1) % 3;
            }
            // 이전 idx 돌아왔을 때 이전에 생긴 구간 수 만큼 추가
            cnt += dp[t][g][f][p];
            dp[t][g][f][p] += 1;
        }
        System.out.println(cnt);
    }
}
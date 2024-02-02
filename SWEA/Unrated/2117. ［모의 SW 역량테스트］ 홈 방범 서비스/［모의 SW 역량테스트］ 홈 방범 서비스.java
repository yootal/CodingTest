import java.io.*;
import java.util.*;
 
public class Solution {
    static int n, m;
    static boolean board[][];
 
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer stt;
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= t; tc++) {
            stt = new StringTokenizer(br.readLine());
            n = Integer.parseInt(stt.nextToken());
            m = Integer.parseInt(stt.nextToken());
            board = new boolean[n][n];
            int total = 0;
 
            // 보드에 집 표시
            for (int i = 0; i < n; i++) {
                stt = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    int inp = Integer.parseInt(stt.nextToken());
                    if (inp == 1) {
                        board[i][j] = true;
                        total++;
                    }
                }
            }
 
            // 중앙 좌표 기준으로 움직인다 + 무조건 집 하나라 1은 스킵
            int k = 2;
            int ans = 1;
            while (k <= 21) {
                int max = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        int cnt = counting(i, j, k);
                        if (cnt * m - calc_minus(k) >= 0) {
                            max = Math.max(max, cnt);
                        }
                    }
                }
                ans = Math.max(ans, max);
                // total 보다 못커짐
                if (ans == total)
                    break;
                k++;
            }
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
 
    static int counting(int x, int y, int k) {
        int range = 2 * k - 1; // 마름모 범위
        int center = k - 1; // 중앙 인덱스
        int sum = 0;
        int st = range / 2, en = range / 2;
        for (int i = 0; i < range; i++) {
            for (int j = st; j < en + 1; j++) {
                int bx = i - (center - x);
                int by = j - (center - y);
                if (bx >= 0 && bx < n && by >= 0 && by < n && board[bx][by]) // 범위안 좌표만 계산
                    sum++;
            }
            if (i < range / 2) {
                st--;
                en++;
            } else {
                st++;
                en--;
            }
        }
        return sum;
    }
 
    static int calc_minus(int k) {
        return k * k + (k - 1) * (k - 1);
    }
 
}
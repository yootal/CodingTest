import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] num;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        int s = 1, e = 30000;
        while (s < e) {
            int mid = (s + e) / 2;
            if (check(mid)) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        int needGroup = M;
        int cnt = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += num[i];
            if (sum > s) {
                sb.append(cnt).append(" ");
                cnt = 1;
                needGroup--;
                sum = num[i];
            } else {
                cnt++;
            }
            if (needGroup == N - i) {
                sb.append(cnt).append(" ");
                for (int j = N - (i + 1); j > 0; j--) {
                    sb.append(1).append(" ");
                }
                break;
            }
        }
        System.out.println(s);
        System.out.print(sb);
    }

    static boolean check(int limit) {
        for (int i = 0; i < N; i++) {
            if (num[i] > limit) {
                return false;
            }
        }
        int groupCnt = 0;
        int groupSum = 0;
        for (int i = 0; i < N; i++) {
            groupSum += num[i];
            if (groupSum > limit) {
                groupSum = num[i];
                groupCnt++;
            }
        }
        if (groupSum > 0) {
            groupCnt++;
        }
        return groupCnt <= M;
    }
}
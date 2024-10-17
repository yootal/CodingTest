import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] num = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(num);
            int diff = Integer.MAX_VALUE;
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                int cur = num[i];
                int s = i + 1, e = N - 1;
                while (s <= e) {
                    int mid = (s + e) / 2;
                    int temp = cur + num[mid];
                    if (temp > K) {
                        e = mid - 1;
                    } else {
                        s = mid + 1;
                    }
                    int curDiff = Math.abs(K - temp);
                    if (diff > curDiff) {
                        cnt = 1;
                        diff = curDiff;
                    } else if (curDiff == diff) {
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
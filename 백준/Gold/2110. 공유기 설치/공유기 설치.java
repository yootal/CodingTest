import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] pos = new int[N];
        for (int i = 0; i < N; i++) {
            pos[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(pos);
        int s = 1;
        int e = pos[N - 1] - pos[0];
        int ans = 0;
        while (s <= e) {
            int mid = (s + e) / 2;
            int cur = pos[0];
            int cnt = 1;
            for (int i = 1; i < N; i++) {
                if (pos[i] >= cur + mid) {
                    cnt++;
                    cur = pos[i];
                }
            }
            if (cnt >= C) {
                ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
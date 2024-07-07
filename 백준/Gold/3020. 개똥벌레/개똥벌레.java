import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[] imos = new int[H + 1];
        for (int i = 1; i <= N; i++) {
            int h = Integer.parseInt(br.readLine());
            if (i % 2 == 1) {
                imos[1] += 1;
                if (h < H)
                    imos[h + 1] -= 1;
            } else {
                imos[H - h + 1] += 1;
            }
        }
        int minH = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 1; i <= H; i++) {
            imos[i] += imos[i - 1];
            if (imos[i] < minH) {
                minH = imos[i];
                cnt = 1;
            } else if (imos[i] == minH) {
                cnt++;
            }
        }
        System.out.println(minH + " " + cnt);
    }
}
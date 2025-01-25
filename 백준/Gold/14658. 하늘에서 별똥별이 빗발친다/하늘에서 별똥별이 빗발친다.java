import java.io.*;
import java.util.*;

public class Main {
    static int N, M, L, K;
    static int[][] pos;
    static int maxCount = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        pos = new int[K][2];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pos[i][0] = x;
            pos[i][1] = y;
        }
        for (int i = 0; i < K; i++) {
            int x = pos[i][0];
            for (int j = 0; j < K; j++) {
                int cnt = 0;
                int y = pos[j][1];
                int rx = x + L;
                int ry = y + L;
                for (int k = 0; k < K; k++) {
                    int cx = pos[k][0];
                    int cy = pos[k][1];
                    if (cx >= x && cx <= rx && cy >= y && cy <= ry) {
                        cnt++;
                    }
                }
                maxCount = Math.max(maxCount, cnt);
            }
        }
        System.out.println(K - maxCount);
    }
}
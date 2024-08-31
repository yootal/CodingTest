import java.io.*;
import java.util.*;

public class Main {
    static int N, M, L;
    static int[] pos;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        pos = new int[M + 1];
        for (int i = 0; i < M; i++) {
            int S = Integer.parseInt(br.readLine());
            pos[i] = S;
        }
        pos[M] = L;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int Q = Integer.parseInt(br.readLine());
            sb.append(binarySearch(Q)).append("\n");
        }
        System.out.print(sb);
    }

    static int binarySearch(int Q) {
        int s = 1, e = L;
        int min = 0;
        while (s <= e) {
            int m = (s + e) / 2;
            int cnt = 0;
            int pre = 0;
            for (int i = 0; i <= M; i++) {
                if (pos[i] - pre >= m) {
                    cnt++;
                    pre = pos[i];
                }
            }
            if (cnt > Q) {
                s = m + 1;
                min = Math.max(min, m);
            } else {
                e = m - 1;
            }
        }
        return min;
    }
}
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[][] score = new long[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            score[i][0] = Long.parseLong(st.nextToken());
            score[i][1] = Long.parseLong(st.nextToken());
        }
        long ans = 0;
        Arrays.sort(score, Comparator.comparingLong(o -> -o[1]));
        for (int i = 0; i < K; i++) {
            ans += score[i][0];
            score[i][0] = -1;
        }
        Arrays.sort(score, Comparator.comparingLong(o -> -o[0]));
        for (int i = 0; i < M; i++) {
            ans += score[i][0];
        }
        System.out.println(ans);
    }
}
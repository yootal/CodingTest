import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] inp = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            inp[i][0] = d;
            inp[i][1] = t;
        }
        Arrays.sort(inp, Comparator.comparingInt(o -> -o[1]));
        int last = inp[0][1];
        for (int i = 0; i < N; i++) {
            if (inp[i][1] <= last) {
                last = inp[i][1] - inp[i][0];
            } else {
                last -= inp[i][0];
            }
        }
        System.out.println(last);
    }
}
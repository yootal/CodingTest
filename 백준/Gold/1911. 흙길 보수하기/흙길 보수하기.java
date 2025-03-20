import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[][] info = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            info[i] = new int[]{s, e};
        }
        Arrays.sort(info, Comparator.comparingInt(o -> o[0]));
        int cnt = 0;
        int nxtIdx = 0;
        for (int i = 0; i < N; i++) {
            int cs = info[i][0];
            int ce = info[i][1];
            if (nxtIdx < cs) {
                nxtIdx = cs;
            }
            while (nxtIdx < ce) {
                nxtIdx += L;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}

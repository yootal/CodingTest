import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int move = 1;
            int sCnt = 0;
            int eCnt = 0;
            boolean check = true;
            while (s < e) {
                if (check) {
                    s += move;
                    sCnt++;
                    check = false;
                } else {
                    e -= move;
                    eCnt++;
                    move++;
                    check = true;
                }
            }
            sb.append(sCnt + eCnt).append("\n");
        }
        System.out.print(sb);
    }
}
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int flag = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int x;
            switch (command) {
                case "add":
                    x = Integer.parseInt(st.nextToken());
                    flag |= (1 << x);
                    break;
                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    flag &= ~(1 << x);
                    break;
                case "check":
                    x = Integer.parseInt(st.nextToken());
                    if ((flag & (1 << x)) != 0) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "toggle":
                    x = Integer.parseInt(st.nextToken());
                    flag ^= (1 << x);
                    break;
                case "all":
                    for (int j = 1; j <= 20; j++) {
                        flag |= (1 << j);
                    }
                    break;
                case "empty":
                    for (int j = 1; j <= 20; j++) {
                        flag &= ~(1 << j);
                    }
                    break;
            }
        }
        System.out.print(sb);
    }
}

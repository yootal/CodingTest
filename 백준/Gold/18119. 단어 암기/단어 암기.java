import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] num = new int[N];
        int numCheck = (1 << 26) - 1;
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                int pos = 1 << (c - 'a');
                if ((num[i] & pos) == 0) {
                    num[i] |= pos;
                }
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(st.nextToken());
            int x = st.nextToken().charAt(0) - 'a';
            if (o == 1) {
                numCheck ^= (1 << x);
            } else {
                numCheck |= (1 << x);
            }
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if ((numCheck & num[j]) == num[j]) {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }
}
import java.io.*;
import java.util.*;

public class Main {

    static int R, C;
    static char[][] words;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        words = new char[R][C];
        for (int i = 0; i < R; i++) {
            String row = br.readLine();
            for (int j = 0; j < C; j++) {
                words[i][j] = row.charAt(j);
            }
        }
        System.out.println(bs());
    }

    static int bs() {
        int s = 0;
        int e = R - 1;
        while (s < e) {
            int mid = (s + e) / 2;
            if (check(mid)) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        return s;
    }

    static boolean check(int mid) {
        HashSet<String> set = new HashSet<>();
        for (int j = 0; j < C; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = mid + 1; i < R; i++) {
                sb.append(words[i][j]);
            }
            String word = sb.toString();
            if (set.contains(word)) {
                return false;
            }
            set.add(word);
        }
        return true;
    }
}

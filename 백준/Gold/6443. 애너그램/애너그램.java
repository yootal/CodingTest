import java.io.*;

public class Main {
    static int N;
    static StringBuilder sb;
    static char[] temp;
    static int[] count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            char[] arr = row.toCharArray();
            temp = new char[row.length()];
            count = new int[26];
            for (char c : arr) {
                count[c - 'a']++;
            }
            comb(0, row.length());
        }
        System.out.println(sb);
    }

    static void comb(int cnt, int len) {
        if (cnt == len) {
            String word = new String(temp);
            sb.append(word).append("\n");
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                count[i]--;
                temp[cnt] = (char) (i + 'a');
                comb(cnt + 1, len);
                count[i]++;
            }
        }
    }
}
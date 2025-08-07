import java.io.*;
import java.util.*;

public class Main {

    static class Info implements Comparable<Info> {
        long value;
        boolean flag;

        @Override
        public int compareTo(Info info) {
            return Long.compare(value, info.value);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] num = new String[N];
        Info[] alpha = new Info[10];
        for (int i = 0; i < 10; i++) {
            alpha[i] = new Info();
        }
        for (int i = 0; i < N; i++) {
            num[i] = br.readLine();
            for (int j = 0; j < num[i].length(); j++) {
                Info info = alpha[num[i].charAt(j) - 'A'];
                if (j == 0)
                    info.flag = true;
                info.value += (long) Math.pow(10, num[i].length() - j - 1);
            }
        }
        Arrays.sort(alpha);
        boolean[] check = new boolean[10];
        long sum = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = (!alpha[i].flag) ? 0 : 1; j <= 9; j++) {
                if (!check[j]) {
                    check[j] = true;
                    sum += alpha[i].value * j;
                    break;
                }
            }
        }
        System.out.println(sum);
    }
}
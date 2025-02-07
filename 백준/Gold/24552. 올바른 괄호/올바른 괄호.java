import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int cnt1 = 0, cnt2 = 0, total = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                cnt1++;
                total += 1;
            } else {
                cnt2++;
                total -= 1;
            }
            if (total < 0) {
                cnt1 = cnt2;
                break;
            } else if (total == 0) {
                cnt1 = 0;
            }
        }
        System.out.println(cnt1);
    }
}
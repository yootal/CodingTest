import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int s = 0, e = N - 1;
            while (s < e) {
                if (num[s] + num[e] < num[i]) {
                    s++;
                } else if (num[s] + num[e] > num[i]) {
                    e--;
                } else {
                    if (s != i && e != i) {
                        cnt++;
                        break;
                    } else if (s == i) {
                        s++;
                    } else {
                        e--;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
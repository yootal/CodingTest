import java.io.*;
import java.util.*;

public class Main {

    static int[] num;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        int S = Integer.parseInt(br.readLine());
        for (int i = 0; i < N && S > 0; i++) {
            int max = i;
            for (int j = i + 1; j < N && j <= i + S; j++) {
                if (num[j] > num[max]) {
                    max = j;
                }
            }
            S -= (max - i);
            for (int k = max; k > i; k--) {
                swap(k, k - 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int x : num) {
            sb.append(x).append(" ");
        }
        System.out.println(sb);
    }

    static void swap(int a, int b) {
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }
}

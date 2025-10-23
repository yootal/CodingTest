import java.io.*;
import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = br.readLine();
            if (s == null) break;
            int x = Integer.parseInt(s) * 10000000;
            n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                int l = Integer.parseInt(br.readLine());
                arr[i] = l;
            }
            Arrays.sort(arr);
            int[] answer = new int[2];
            int max = -1;
            for (int i = 0; i < n - 1; i++) {
                int idx = bs(x - arr[i], i + 1, arr);
                if (idx == -1) continue;
                int diff = Math.abs(arr[i] - arr[idx]);
                if (max < diff) {
                    max = diff;
                    answer[0] = arr[i];
                    answer[1] = arr[idx];
                }
            }
            if (answer[0] != 0 || answer[1] != 0) {
                sb.append("yes").append(" ").append(answer[0]).append(" ").append(answer[1]).append("\n");
            } else sb.append("danger").append("\n");
        }
        System.out.print(sb);
    }

    static int bs(int target, int lo, int[] arr) {
        int hi = n - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }
}
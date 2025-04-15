import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (al.isEmpty() || al.get(al.size() - 1) < num[i]) {
                al.add(num[i]);
            } else {
                int idx = lowerBound(num[i], al);
                al.set(idx, num[i]);
            }
        }
        System.out.println(al.size());
    }

    static int lowerBound(int x, ArrayList<Integer> al) {
        int s = 0, e = al.size();
        while (s < e) {
            int mid = (s + e) / 2;
            if (al.get(mid) >= x) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }
}

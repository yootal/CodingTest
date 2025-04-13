import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> al = new ArrayList<>();
        al.add(-1000000001);
        for (int i = 0; i < N; i++) {
            if (num[i] > al.get(al.size() - 1)) {
                al.add(num[i]);
            } else {
                int idx = lowerBound(num[i], al);
                al.set(idx, num[i]);
            }
        }
        System.out.println(al.size() - 1);
    }

    static int lowerBound(int x, ArrayList<Integer> al) {
        int s = 0;
        int e = al.size();
        while (s < e) {
            int mid = (s + e) / 2;
            if (al.get(mid) < x) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        return s;
    }
}

import java.util.*;
import java.io.*;

public class Main {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> al = new ArrayList<>();
        al.add(num[0]);
        for (int i = 1; i < N; i++) {
            if (num[i] > al.get(al.size() - 1)) {
                al.add(num[i]);
            } else {
                al.set(lowerBound(num[i], al), num[i]);
            }
        }
        System.out.println(al.size());
    }

    static int lowerBound(int target, ArrayList<Integer> al) {
        int s = 0, e = al.size();
        while (s < e) {
            int mid = (s + e) / 2;
            int x = al.get(mid);
            if (x >= target) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }
}
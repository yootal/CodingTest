import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> al = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(st.nextToken());
            if (al.isEmpty() || al.get(al.size() - 1) < M) {
                al.add(M);
            } else {
                int idx = lowerBound(M, al);
                al.set(idx, M);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    static int lowerBound(int x, ArrayList<Integer> al) {
        int s = 0, e = al.size();
        while (s < e) {
            int mid = (s + e) / 2;
            if (x <= al.get(mid)) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }
}

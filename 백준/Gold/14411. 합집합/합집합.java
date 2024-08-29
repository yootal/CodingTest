import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<long[]> al = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken()) / 2;
            long b = Long.parseLong(st.nextToken()) / 2;
            al.add(new long[]{a, b});
        }
        al.sort(Comparator.comparingLong(a -> a[0]));
        ArrayDeque<long[]> s = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            long[] cur = al.get(i);
            while (!s.isEmpty() && s.peek()[1] <= cur[1]) s.pop();
            s.push(cur);
        }
        long ans = 0;
        long pre = 0;
        for (long[] v : s) {
            ans += v[0] * (v[1] - pre);
            pre = v[1];
        }
        System.out.println(ans * 4);
    }
}
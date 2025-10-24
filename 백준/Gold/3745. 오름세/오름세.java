import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        while (true) {
            String s = br.readLine();
            if (s == null) break;            // EOF
            s = s.trim();
            if (s.isEmpty()) continue;       // 빈 줄 스킵

            int n = Integer.parseInt(s);

            int[] arr = new int[n];
            int filled = 0;
            while (filled < n) {              // n개 채울 때까지 토큰 보충
                if (st == null || !st.hasMoreTokens()) {
                    String line = br.readLine();
                    if (line == null) break;  // 방어
                    line = line.trim();
                    if (line.isEmpty()) continue;
                    st = new StringTokenizer(line);
                    continue;
                }
                arr[filled++] = Integer.parseInt(st.nextToken());
            }

            ArrayList<Integer> al = new ArrayList<>();
            for (int x : arr) {
                int idx = lowerBound(x, al);
                if (idx == al.size()) al.add(x);
                else al.set(idx, x);
            }
            sb.append(al.size()).append('\n');
        }
        System.out.print(sb);
    }

    static int lowerBound(int target, ArrayList<Integer> al) {
        int lo = -1, hi = al.size();
        while (lo + 1 < hi) {
            int mid = (lo + hi) >>> 1;
            if (al.get(mid) < target) lo = mid;
            else hi = mid;
        }
        return hi;
    }
}

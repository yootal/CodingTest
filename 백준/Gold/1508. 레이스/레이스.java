import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> pos = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            pos.add(Integer.parseInt(st.nextToken()));
        }
        int ans = 0;
        int s = 1, e = N;
        while (s <= e) {
            int mid = (s + e) / 2;
            int sum = 0;
            int cnt = 1;
            for (int i = 1; i < pos.size(); i++) {
                int gap = pos.get(i) - pos.get(i - 1);
                sum += gap;
                if (sum >= mid) {
                    cnt++;
                    sum = 0;
                }
            }
            if (cnt < M) {
                e = mid - 1;
            } else {
                ans = Math.max(ans, mid);
                s = mid + 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        int sum = 0;
        int cnt = 1;
        for (int i = 1; i < pos.size(); i++) {
            sum += pos.get(i) - pos.get(i - 1);
            if (sum >= ans && cnt != M) {
                sb.append("1");
                sum = 0;
                cnt++;
            } else {
                sb.append("0");
            }
        }
        System.out.println(sb);
    }
}
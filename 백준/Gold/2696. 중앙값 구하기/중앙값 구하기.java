import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());
            sb.append(M / 2 + 1).append("\n");
            PriorityQueue<Integer> pq1 = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> pq2 = new PriorityQueue<>();
            int idx = 1;
            int cnt = 0;
            while (M > 0) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < (Math.min(M, 10)); j++) {
                    int num = Integer.parseInt(st.nextToken());
                    if (pq1.isEmpty()) {
                        pq1.offer(num);
                    } else if (pq1.peek() >= num) {
                        pq1.offer(num);
                    } else if (pq1.peek() < num) {
                        pq2.offer(num);
                    }
                    while (pq1.size() < pq2.size()) {
                        pq1.offer(pq2.poll());
                    }
                    while (pq1.size() > pq2.size() + 1) {
                        pq2.offer(pq1.poll());
                    }
                    if (idx % 2 == 1) {
                        sb.append(pq1.peek()).append(" ");
                        cnt++;
                        if (cnt % 10 == 0) {
                            sb.append("\n");
                        }
                    }
                    idx++;
                }
                M -= 10;
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

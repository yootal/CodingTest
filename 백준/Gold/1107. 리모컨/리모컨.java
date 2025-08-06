import java.io.*;
import java.util.*;

public class Main {
    static class Info {
        int p, d;
        boolean f;

        public Info(int p, int d, boolean f) {
            this.p = p;
            this.d = d;
            this.f = f;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[10];
        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                check[Integer.parseInt(st.nextToken())] = true;
            }
        }
        int[] dist1 = new int[1000000];
        int[] dist2 = new int[1000000];
        Arrays.fill(dist1, 10000000);
        Arrays.fill(dist2, 10000000);
        dist1[100] = 0;
        ArrayDeque<Info> q = new ArrayDeque<>();
        q.offer(new Info(100, dist1[100], false));
        for (int i = 0; i < 10; i++) {
            if (!check[i]) {
                dist2[i] = 1;
                q.offer(new Info(i, dist2[i], true));
            }
        }
        while (!q.isEmpty()) {
            Info cur = q.poll();
            if (cur.p == N) {
                System.out.println(cur.d);
                break;
            }
            if (cur.f && cur.p != 0) {
                for (int i = 0; i < 10; i++) {
                    int nxt = cur.p * 10 + i;
                    if (!check[i] && nxt < 1000000 && dist2[nxt] > cur.d + 1) {
                        dist2[nxt] = cur.d + 1;
                        q.offer(new Info(nxt, dist2[nxt], cur.f));
                    }
                }
            }
            if (cur.p + 1 < 1000000 && dist1[cur.p + 1] > cur.d + 1) {
                dist1[cur.p + 1] = cur.d + 1;
                q.offer(new Info(cur.p + 1, dist1[cur.p + 1], false));
            }
            if (cur.p > 0 && dist1[cur.p - 1] > cur.d + 1) {
                dist1[cur.p - 1] = cur.d + 1;
                q.offer(new Info(cur.p - 1, dist1[cur.p - 1], false));
            }
        }
    }
}
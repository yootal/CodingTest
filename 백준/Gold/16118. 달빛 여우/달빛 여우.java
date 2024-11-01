import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<int[]>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, d * 2});
            graph[b].add(new int[]{a, d * 2});
        }
        long[] dist1 = new long[N + 1];
        long[][] dist2 = new long[N + 1][2];
        Arrays.fill(dist1, 4000 * 200000 + 1);
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist2[i], 4000 * 200000 + 1);
        }
        dist1[1] = 0;
        dist2[1][0] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o[1]));
        pq.offer(new long[]{1, 0});
        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            if (dist1[(int) cur[0]] != cur[1]) continue;
            for (int[] nxt : graph[(int) cur[0]]) {
                if (dist1[nxt[0]] > cur[1] + nxt[1]) {
                    dist1[nxt[0]] = cur[1] + nxt[1];
                    pq.offer(new long[]{nxt[0], dist1[nxt[0]]});
                }
            }
        }
        pq.offer(new long[]{1, 0, 0});
        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int mode = (int) cur[2] % 2;
            if (dist2[(int) cur[0]][mode] != cur[1]) continue;
            for (int[] nxt : graph[(int) cur[0]]) {
                int nxtDist = nxt[1];
                if (cur[2] % 2 == 0) {
                    nxtDist /= 2;
                } else {
                    nxtDist *= 2;
                }
                if (dist2[nxt[0]][(mode + 1) % 2] > cur[1] + nxtDist) {
                    dist2[nxt[0]][(mode + 1) % 2] = cur[1] + nxtDist;
                    pq.offer(new long[]{nxt[0], dist2[nxt[0]][(mode + 1) % 2], cur[2] + 1});
                }
            }
        }
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (dist1[i] < Math.min(dist2[i][0], dist2[i][1])) cnt++;
        }
        System.out.println(cnt);
    }
}
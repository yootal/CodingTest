import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> map;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] indegree = new int[N + 1];
            map = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            int[] rank = new int[N];
            ArrayList<Integer>[] graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < N; i++) {
                rank[i] = Integer.parseInt(st.nextToken());
                indegree[rank[i]] = i;
                map.put(rank[i], i);
            }
            int M = Integer.parseInt(br.readLine());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (map.get(a) < map.get(b)) {
                    graph[b].add(a);
                    indegree[a]++;
                    indegree[b]--;
                } else {
                    graph[a].add(b);
                    indegree[b]++;
                    indegree[a]--;
                }
            }
            int cnt = 0;
            StringBuilder tb = new StringBuilder();
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
            for (int i = 1; i <= N; i++) {
                pq.offer(new int[]{i, indegree[i]});
            }
            int idx = 0;
            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                if (cur[1] == idx) {
                    idx++;
                    cnt++;
                    tb.append(cur[0]).append(" ");
                } else break;
            }
            tb.append("\n");
            if (cnt != N) {
                sb.append("IMPOSSIBLE").append("\n");
            } else
                sb.append(tb);
        }
        System.out.print(sb);
    }
}
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] map = new int[101];
//        HashMap<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        Arrays.fill(map,-1);
        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(br.readLine());
            map[num] = idx++;
//            map.put(Integer.parseInt(br.readLine()), idx++);
        }
        ArrayList<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c});
        }
        boolean[][] jewel = new boolean[n + 1][1 << k];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{1, 0, 0});
        jewel[1][0] = true;
        int ans = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int island = cur[0];
            int vis = cur[1];
            int cnt = cur[2];
            boolean check = false;
            if (island == 1) {
                ans = Math.max(ans, cnt);
            }
            int islandIdx = 0;
            if (map[island] != -1) {
                islandIdx = map[island];
            }
            int nxtVis = 0;
            if (((vis & (1 << (islandIdx))) == 0) && map[island] != -1) {
                nxtVis = vis | (1 << (islandIdx));
                jewel[island][nxtVis] = true;
                check = true;
                if (island == 1) ans = Math.max(ans, cnt + 1);
            }
            for (int[] nxt : graph[island]) {
                int limit = nxt[1];
                if (limit >= cnt && !jewel[nxt[0]][vis]) {
                    jewel[nxt[0]][vis] = true;
                    q.offer(new int[]{nxt[0], vis, cnt});
                }
                if (check) {
                    if (limit >= cnt + 1 && !jewel[nxt[0]][nxtVis]) {
                        jewel[nxt[0]][nxtVis] = true;
                        q.offer(new int[]{nxt[0], nxtVis, cnt + 1});
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());
        int[][] vis = new int[1001][1001];
        for (int[] row : vis) Arrays.fill(row, -1);
        vis[1][0] = 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{1, 0, 0});
        int ans = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cnt = cur[0];
            int clip = cur[1];
            int time = cur[2];
            if (vis[cnt][clip] == -1) {
                vis[cnt][clip] = time;
            }
            if (cnt == S) {
                ans = time;
                break;
            }
            if (cnt + clip < 1001 && vis[cnt + clip][clip] == -1) {
                q.offer(new int[]{cnt + clip, clip, time + 1});
            }
            if (vis[cnt][cnt] == -1) {
                q.offer(new int[]{cnt, cnt, time + 1});
            }
            if (cnt > 1 && vis[cnt - 1][clip] == -1) {
                q.offer(new int[]{cnt - 1, clip, time + 1});
            }
        }
        System.out.println(ans);
    }
}
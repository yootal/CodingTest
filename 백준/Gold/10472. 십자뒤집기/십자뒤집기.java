import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, -1, 0, 1, 0};
    static int[] dy = {0, 0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int p = 0; p < P; p++) {
            int num = 0;
            for (int i = 0; i < 3; i++) {
                String row = br.readLine();
                for (int j = 0; j < 3; j++) {
                    if (row.charAt(j) == '*')
                        num |= 1 << (i * 3 + j);
                }
            }
            sb.append(bfs(num)).append("\n");
        }
        System.out.println(sb);
    }

    static int bfs(int start) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[] vis = new boolean[1 << 9];
        vis[start] = true;
        q.offer(new int[]{start, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == 0) {
                return cur[1];
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int nxt = cur[0];
                    for (int d = 0; d < 5; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
                            int pos = nx * 3 + ny;
                            if ((nxt & (1 << pos)) > 0) {
                                nxt &= ~(1 << pos);
                            } else {
                                nxt |= (1 << pos);
                            }
                        }
                    }
                    if (!vis[nxt]) {
                        vis[nxt] = true;
                        q.add(new int[]{nxt, cur[1] + 1});
                    }
                }
            }
        }
        return 0;
    }
}
import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int ans = Integer.MAX_VALUE;
    static ArrayList<int[]> piece, pos;
    static int[][][] vis;
    static boolean[][] vis2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        vis = new int[5][5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    vis[i][j][k] = -1;
                }
            }
        }
        piece = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String row = br.readLine();
            for (int j = 0; j < 5; j++) {
                if (row.charAt(j) == '*') {
                    vis[i][j][piece.size()] = 0;
                    piece.add(new int[]{i, j});
                }
            }
        }
        for (int i = 0; i < piece.size(); i++) {
            ArrayDeque<int[]> q = new ArrayDeque<>();
            q.offer(piece.get(i));
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = cur[0] + dx[d];
                    int ny = cur[1] + dy[d];
                    if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && vis[nx][ny][i] == -1) {
                        vis[nx][ny][i] = vis[cur[0]][cur[1]][i] + 1;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        vis2 = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                vis2[i][j] = true;
                make(i, j, 1);
                vis2[i][j] = false;
            }
        }
        System.out.println(ans);
    }

    static void make(int sx, int sy, int cnt) {
        if (cnt == piece.size()) {
            if (check()) {
                pos = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (vis2[i][j]) pos.add(new int[]{i, j});
                    }
                }
                int[] first = pos.get(0);
                for (int k = 0; k < piece.size(); k++) {
                    calc(1 << k, vis[first[0]][first[1]][k], 1);
                }
            }
            return;
        }
        for (int i = sx; i < 5; i++) {
            for (int j = sx == i ? sy : 0; j < 5; j++) {
                if (!vis2[i][j]) {
                    vis2[i][j] = true;
                    make(i, j, cnt + 1);
                    vis2[i][j] = false;
                }
            }
        }
    }

    static boolean check() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (vis2[i][j]) {
                    boolean[][] vis3 = new boolean[5][5];
                    vis3[i][j] = true;
                    ArrayDeque<int[]> q = new ArrayDeque<>();
                    q.offer(new int[]{i, j});
                    int cnt = 1;
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        for (int d = 0; d < 4; d++) {
                            int nx = cur[0] + dx[d];
                            int ny = cur[1] + dy[d];
                            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && vis2[nx][ny] && !vis3[nx][ny]) {
                                cnt++;
                                vis3[nx][ny] = true;
                                q.offer(new int[]{nx, ny});
                            }
                        }
                    }
                    return cnt == piece.size();
                }
            }
        }
        return false;
    }


    static void calc(int visit, int count, int idx) {
        if (visit == (1 << piece.size()) - 1) {
            ans = Math.min(ans, count);
            return;
        }
        for (int i = 0; i < piece.size(); i++) {
            if ((visit & (1 << i)) != 0) continue;
            int[] cur = pos.get(idx);
            calc(visit | (1 << i), count + vis[cur[0]][cur[1]][i], idx + 1);
        }
    }
}
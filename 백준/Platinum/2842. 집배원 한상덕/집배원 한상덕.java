import java.util.*;
import java.io.*;

public class Main {
    static int N, P, px, py, cnt;
    static char[][] board;
    static int[][] height;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        cnt = 0;
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = row.charAt(j);
                if (board[i][j] == 'P') {
                    px = i;
                    py = j;
                } else if (board[i][j] == 'K') {
                    cnt++;
                }
            }
        }
        height = new int[N][N];
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                height[i][j] = Integer.parseInt(st.nextToken());
                treeSet.add(height[i][j]);
                if (board[i][j] == 'P') {
                    P = height[i][j];
                }
            }
        }
        List<Integer> list = new ArrayList<>(treeSet);
        int s = 0, e = 0;
        int diff = 1000000;
        while (s <= e) {
            int l = list.get(s), r = list.get(e);
            if (check(l, r)) {
                diff = Math.min(diff, r - l);
                s++;
            } else {
                e++;
                if (e == list.size()) break;
            }
        }
        System.out.println(diff);
    }

    static boolean check(int s, int e) {
        if (P < s || P > e) return false;
        boolean[][] vis = new boolean[N][N];
        vis[px][py] = true;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{px, py});
        int kCnt = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (board[cur[0]][cur[1]] == 'K') {
                kCnt++;
                if (kCnt == cnt)
                    return true;
            }
            for (int d = 0; d < 8; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !vis[nx][ny]) {
                    if (height[nx][ny] >= s && height[nx][ny] <= e) {
                        vis[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return false;
    }
}
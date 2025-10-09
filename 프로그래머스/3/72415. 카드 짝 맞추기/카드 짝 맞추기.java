import java.util.*;

class Solution {
    static final int N = 4;
    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};
    static HashMap<Integer, ArrayList<int[]>> pos = new HashMap<>();
    static ArrayList<Integer> kinds;
    static boolean[] used;

    public int solution(int[][] board, int r, int c) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int v = board[i][j];
                if (v == 0) continue;
                pos.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[]{i, j});
            }
        }
        kinds = new ArrayList<>(pos.keySet());
        used = new boolean[kinds.size()];
        return dfsAllOrders(board, r, c, 0);
    }

    private int dfsAllOrders(int[][] board, int r, int c, int removed) {
        if (removed == kinds.size()) return 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < kinds.size(); i++) {
            if (used[i]) continue;
            
            used[i] = true;
            
            int card = kinds.get(i);
            ArrayList<int[]> ps = pos.get(card);
            int[] A = ps.get(0), B = ps.get(1);

            int[][] backup = copy(new int[N][N], board);

            int d1 = bfs(board, r, c, A[0], A[1]) + 1;
            int tmp = board[A[0]][A[1]];
            board[A[0]][A[1]] = 0;
            int d1b = bfs(board, A[0], A[1], B[0], B[1]) + 1; 
            int tmp2 = board[B[0]][B[1]];
            board[B[0]][B[1]] = 0;
            int cost1 = d1 + d1b + dfsAllOrders(board, B[0], B[1], removed + 1);
            ans = Math.min(ans, cost1);
            board = copy(board, backup);

            int d2 = bfs(board, r, c, B[0], B[1]) + 1; 
            tmp2 = board[B[0]][B[1]];
            board[B[0]][B[1]] = 0;
            int d2b = bfs(board, B[0], B[1], A[0], A[1]) + 1;
            tmp = board[A[0]][A[1]];
            board[A[0]][A[1]] = 0;
            int cost2 = d2 + d2b + dfsAllOrders(board, A[0], A[1], removed + 1);
            ans = Math.min(ans, cost2);
            board = copy(board, backup);

            used[i] = false;
        }
        return ans;
    }

    private int[][] copy(int[][] nb, int[][] b) {
        for (int i = 0; i < N; i++){
            for(int j = 0 ; j < N ; j++){
                nb[i][j] = b[i][j];
            }
        }
        return nb;
    }

    private int bfs(int[][] board, int sr, int sc, int tr, int tc) {
        boolean[][] vis = new boolean[N][N];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc, 0});
        vis[sr][sc] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], dist = cur[2];
            if (r == tr && c == tc) 
                return dist;
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (in(nr, nc) && !vis[nr][nc]) {
                    vis[nr][nc] = true;
                    q.offer(new int[]{nr, nc, dist + 1});
                }
            }
            for (int d = 0; d < 4; d++) {
                int[] nxt = ctrlMove(board, r, c, d);
                int nr = nxt[0], nc = nxt[1];
                if (!vis[nr][nc]) {
                    vis[nr][nc] = true;
                    q.offer(new int[]{nr, nc, dist + 1});
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    static boolean in(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }
    
    static int[] ctrlMove(int[][] board, int r, int c, int d) {
        int nr = r, nc = c;
        while (true) {
            int tr = nr + dr[d];
            int tc = nc + dc[d];
            if (!in(tr, tc)) break;
            nr = tr; 
            nc = tc;
            if (board[nr][nc] != 0) break; 
        }
        return new int[]{nr, nc};
    }
}

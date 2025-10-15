import java.util.*;

class Solution {
    static final int H = 0; 
    static final int V = 1; 
    static class Node {
        int r, c, dir, d;
        Node(int r, int c, int dir, int d) {
            this.r = r; 
            this.c = c; 
            this.dir = dir; 
            this.d = d; 
        }
    }
    
    public int solution(int[][] board) {
        int n = board.length;
        boolean[][][] vis = new boolean[n][n][2];
        ArrayDeque<Node> q = new ArrayDeque<>();
        vis[0][0][H] = true;
        q.offer(new Node(0, 0, H, 0));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (reach(cur.r, cur.c, cur.dir, n)) return cur.d;
            moveAll(board, vis, q, cur);
            rotateAll(board, vis, q, cur);
        }
        return -1; 
    }

    static boolean reach(int r, int c, int dir, int n) {
        if (dir == H) {
            return (r == n - 1 && c == n - 1) || (r == n - 1 && c + 1 == n - 1);
        } 
        else {
            return (r == n - 1 && c == n - 1) || (r + 1 == n - 1 && c == n - 1);
        }
    }

    static boolean in(int r, int c, int n) { 
        return 0 <= r && r < n && 0 <= c && c < n; 
    }
    
    static boolean free(int[][] b, int r, int c) { 
        return in(r, c, b.length) && b[r][c] == 0; 
    }

    static void push(boolean[][][] vis, ArrayDeque<Node> q, int r, int c, int dir, int d) {
        if (!in(r, c, vis.length)) return;
        if (vis[r][c][dir]) return;
        vis[r][c][dir] = true;
        q.offer(new Node(r, c, dir, d + 1));
    }

    static void moveAll(int[][] b, boolean[][][] vis, ArrayDeque<Node> q, Node cur) {
        int n = b.length;
        if (cur.dir == H) {
            if (cur.c - 1 >= 0 && free(b, cur.r, cur.c - 1))
                push(vis, q, cur.r, cur.c - 1, H, cur.d);
            if (cur.c + 2 < n && free(b, cur.r, cur.c + 2))
                push(vis, q, cur.r, cur.c + 1, H, cur.d);
            if (cur.r - 1 >= 0 && free(b, cur.r - 1, cur.c) && free(b, cur.r - 1, cur.c + 1))
                push(vis, q, cur.r - 1, cur.c, H, cur.d);
            if (cur.r + 1 < n && free(b, cur.r + 1, cur.c) && free(b, cur.r + 1, cur.c + 1))
                push(vis, q, cur.r + 1, cur.c, H, cur.d);
        } else { 
            if (cur.r - 1 >= 0 && free(b, cur.r - 1, cur.c))
                push(vis, q, cur.r - 1, cur.c, V, cur.d);
            if (cur.r + 2 < n && free(b, cur.r + 2, cur.c))
                push(vis, q, cur.r + 1, cur.c, V, cur.d);
            if (cur.c - 1 >= 0 && free(b, cur.r, cur.c - 1) && free(b, cur.r + 1, cur.c - 1))
                push(vis, q, cur.r, cur.c - 1, V, cur.d);
            if (cur.c + 1 < n && free(b, cur.r, cur.c + 1) && free(b, cur.r + 1, cur.c + 1))
                push(vis, q, cur.r, cur.c + 1, V, cur.d);
        }
    }

    static void rotateAll(int[][] b, boolean[][][] vis, ArrayDeque<Node> q, Node cur) {
        // 아니 시발 존나 어렵네
        int n = b.length;
        if (cur.dir == H) {
            // 현재 차지: (r,c), (r,c+1)
            // 위로 회전: (r-1,c), (r-1,c+1) 둘 다 비어야
            if (cur.r - 1 >= 0 && free(b, cur.r - 1, cur.c) && free(b, cur.r - 1, cur.c + 1)) {
                // 왼쪽끝 축: (r,c) 기준 -> 새 V 기준 (r-1,c)
                push(vis, q, cur.r - 1, cur.c, V, cur.d);
                // 오른쪽끝 축: (r,c+1) 기준 -> 새 V 기준 (r-1,c+1)
                push(vis, q, cur.r - 1, cur.c + 1, V, cur.d);
            }
            // 아래로 회전: (r+1,c), (r+1,c+1) 둘 다 비어야
            if (cur.r + 1 < n && free(b, cur.r + 1, cur.c) && free(b, cur.r + 1, cur.c + 1)) {
                // 왼쪽끝 축
                push(vis, q, cur.r, cur.c, V, cur.d);
                // 오른쪽끝 축
                push(vis, q, cur.r, cur.c + 1, V, cur.d);
            }
        } else { // V
            // 현재 차지: (r,c), (r+1,c)
            // 왼쪽으로 회전: (r,c-1), (r+1,c-1) 둘 다 비어야
            if (cur.c - 1 >= 0 && free(b, cur.r, cur.c - 1) && free(b, cur.r + 1, cur.c - 1)) {
                // 위쪽끝 축: (r,c) 기준 -> 새 H 기준 (r, c-1)
                push(vis, q, cur.r, cur.c - 1, H, cur.d);
                // 아래쪽끝 축: (r+1,c) 기준 -> 새 H 기준 (r+1, c-1)
                push(vis, q, cur.r + 1, cur.c - 1, H, cur.d);
            }
            // 오른쪽으로 회전: (r,c+1), (r+1,c+1) 둘 다 비어야
            if (cur.c + 1 < n && free(b, cur.r, cur.c + 1) && free(b, cur.r + 1, cur.c + 1)) {
                // 위쪽끝 축
                push(vis, q, cur.r, cur.c, H, cur.d);
                // 아래쪽끝 축
                push(vis, q, cur.r + 1, cur.c, H, cur.d);
            }
        }
    }
}

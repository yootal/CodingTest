import java.util.*;

class Solution {
    static int n,m;
    static char[][] b;
    static boolean[][][] v;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    
    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        b = new char[n][m];
        v = new boolean[n][m][4];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for(int i  = 0 ; i < n ; i++){
            String row = board[i];
            for(int j = 0 ; j < m ; j++){
                b[i][j] = row.charAt(j);  
                if(b[i][j] == 'R'){
                    for(int d = 0 ; d < 4 ; d++){
                        v[i][j][d] = true;
                        q.offer(new int[]{i,j,d,0});
                    }
                }
            }
        }
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cd = cur[2];
            int cnt = cur[3];
            if(b[cx][cy] == 'G'){
                return cnt;
            }
            int nx = cx + dx[cd];
            int ny = cy + dy[cd];
            boolean flag = false;
            while(limit(nx,ny) && b[nx][ny] != 'D'){
                nx += dx[cd];
                ny += dy[cd];
            }
            nx -= dx[cd];
            ny -= dy[cd];
            for(int d = 0 ; d < 4 ; d++){
                if(!v[nx][ny][d]){
                    v[nx][ny][d] = true;
                    q.offer(new int[]{nx,ny,d,cnt+1});
                }
            }
        }
        return -1;
    }
    
    static boolean limit(int nx, int ny){
        return nx >= 0 && ny >= 0 && nx < n && ny < m;
    }
}
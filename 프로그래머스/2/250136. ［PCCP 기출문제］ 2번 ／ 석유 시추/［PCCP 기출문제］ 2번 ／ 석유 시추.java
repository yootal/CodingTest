import java.util.*;

class Solution {
    static final int[] dx = {-1,0,1,0};
    static final int[] dy = {0,1,0,-1};
    static int N,M,record[][];
    
    public int solution(int[][] land) {
        N = land.length;
        M = land[0].length;
        record = new int[N][M];
        ArrayList<Integer> al = new ArrayList<>();
        int idx = 1;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(land[i][j] == 1 && record[i][j] == 0){
                    al.add(bfs(i,j,idx++,land));
                }
            }
        }
        int ans = 0;
        for(int j = 0 ; j < M ; j++){
            boolean vis[] = new boolean[al.size()];
            int sum = 0;
            for(int i = 0 ; i < N ; i++){
                if(record[i][j] != 0 && !vis[record[i][j]-1]){
                    vis[record[i][j]-1] = true;
                    sum += al.get(record[i][j]-1);
                }
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
    
    static int bfs(int x, int y, int idx, int[][] land){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x,y});
        record[x][y] = idx;
        int cnt = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            cnt++;
            for(int d = 0 ; d < 4 ; d++){
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if(nx >= 0 && nx < N && ny >=0 && ny < M && land[nx][ny]== 1 &&record[nx][ny] != idx){
                    record[nx][ny] = idx;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
        return cnt;
    }
}
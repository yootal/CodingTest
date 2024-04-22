import java.util.*;

class Solution {
    static final int dx[] = {-1,0,1,0};
    static final int dy[] = {0,1,0,-1};
    static int gb[][], t[][];
    static int gn,gm,tn,tm,ans;
    static boolean block_check[];
    static HashMap<Integer,int[][]>[] maps;
    
    public int solution(int[][] game_board, int[][] table) {
        gb = game_board;
        t = table;
        gn = gb.length;
        gm = gb[0].length;
        tn = t.length;
        tm = t[0].length;
        maps = new HashMap[4];
        for(int i = 0; i < 4 ; i++){
            maps[i] = new HashMap<>();
        }
        int block_idx = 1;
        int original[][] = new int[tn][tm];
        for(int i = 0 ; i < tn ; i++){
            for(int j = 0; j < tm ; j++){
                if(t[i][j] == 1 && original[i][j] == 0){
                    original[i][j] = block_idx;
                    Queue<int[]> q = new ArrayDeque<>();
                    q.offer(new int[]{i,j});
                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        for(int d = 0; d < 4 ; d++){
                            int nx = cur[0] + dx[d];
                            int ny = cur[1] + dy[d];
                            if(nx >= 0 && nx < tn && ny >= 0 && ny < tm && t[nx][ny] == 1 && original[nx][ny] == 0){
                                original[nx][ny] = block_idx;
                                q.offer(new int[]{nx,ny});
                            } 
                        }
                    }
                    block_idx++;
                }
            }
        }
        block_check = new boolean[block_idx];
        record(0,original,tn,tm);
    
        int[][] temp = new int[tm][tn];
        for(int i = 0 ; i < tn; i++){
            for(int j = 0 ; j < tm; j++){
                temp[tm-j-1][i] = original[i][j];
            }
        }
        record(1,temp,tm,tn);
        
        int[][] temp2 = new int[tn][tm];
        for(int i = 0 ; i < tm; i++){
            for(int j = 0 ; j < tn; j++){
                temp2[tn-j-1][i] = temp[i][j];
            }
        }
        record(2,temp2,tn,tm);
        
        int[][] temp3 = new int[tm][tn];
        for(int i = 0 ; i < tn; i++){
            for(int j = 0 ; j < tm; j++){
                temp3[tm-j-1][i] = temp2[i][j];
            }
        }
        record(3,temp3,tm,tn);
        
        boolean vis[][] = new boolean[gn][gm];
        for(int i = 0 ; i < gn ; i++){
            for(int j = 0; j < gm ; j++){
                if(gb[i][j] == 0 && !vis[i][j]){
                    vis[i][j] = true;
                    int minX = i, maxX = i, minY = j, maxY = j;
                    // original[i][j] = block_idx;
                    Queue<int[]> q = new ArrayDeque<>();
                    q.offer(new int[]{i,j});
                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        minX = Math.min(minX, cur[0]);
                        maxX = Math.max(maxX, cur[0]);
                        minY = Math.min(minY, cur[1]);
                        maxY = Math.max(maxY, cur[1]);
                        for(int d = 0; d < 4 ; d++){
                            int nx = cur[0] + dx[d];
                            int ny = cur[1] + dy[d];
                            if(nx >= 0 && nx < gn && ny >= 0 && ny < gm && !vis[nx][ny] && gb[nx][ny] == 0){
                                vis[nx][ny] = true;
                                q.offer(new int[]{nx,ny});
                            } 
                        }
                    }
                    int tempGb[][] = new int[maxX-minX+1][maxY-minY+1];
                    for(int r = minX; r <= maxX ; r++){
                        for(int c = minY; c <= maxY ; c++){
                            tempGb[r-minX][c-minY] = gb[r][c];
                        }
                    }
                    boolean flag = true;
                    for(int mi = 0 ; mi < 4 ; mi++){
                        for(int mk = 1; mk < block_idx ; mk++){
                            if(block_check[mk]) continue;
                            if(check_case(mi,mk,tempGb)){
                                flag = false;
                                break;
                            }
                        }
                        if(!flag) break;
                    }
                }
            }
        }
        return ans;
        // int answer = -1;
        // return answer;
    }
    
    static boolean check_case(int mi, int mk, int[][] temp){
        int[][] cur = maps[mi].get(mk);
        // System.out.println(Arrays.deepToString(cur));
        if(cur.length != temp.length || cur[0].length != temp[0].length) return false;
        int cnt = 0;
        // System.out.println("뭘까"+mi+" "+mk);
        
        for(int tx = 0; tx < cur.length; tx++){
            for(int ty = 0; ty < cur[0].length; ty++){
                if(cur[tx][ty] != temp[tx][ty])
                    return false;
                if(cur[tx][ty] == 0) cnt++;
            }
        }
        ans += cnt;
        block_check[mk] = true;
        return true;
    }
    
    static void record(int map_idx, int[][] original,int tn, int tm){
        boolean vis[][] = new boolean[tn][tm];
        for(int i = 0 ; i < tn ; i++){
            for(int j = 0; j < tm ; j++){
                if(original[i][j] != 0 && !vis[i][j]){
                    int minX = i, maxX = i, minY = j, maxY = j;
                    int flag = original[i][j];
                    vis[i][j] = true;
                    Queue<int[]> q = new ArrayDeque<>();
                    q.offer(new int[]{i,j});
                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        minX = Math.min(minX, cur[0]);
                        maxX = Math.max(maxX, cur[0]);
                        minY = Math.min(minY, cur[1]);
                        maxY = Math.max(maxY, cur[1]);
                        for(int d = 0; d < 4 ; d++){
                            int nx = cur[0] + dx[d];
                            int ny = cur[1] + dy[d];
                            if(nx >= 0 && nx < tn && ny >= 0 && ny < tm && !vis[nx][ny] && original[nx][ny] == flag){
                                vis[nx][ny] = true;
                                q.offer(new int[]{nx,ny});
                            } 
                        }
                    }
                    int temp[][] = new int[maxX-minX+1][maxY-minY+1];
                    for(int r = minX; r <= maxX ; r++){
                        for(int c = minY; c <= maxY ; c++){
                            temp[r-minX][c-minY] = original[r][c] == 0?1:0;
                        }
                    }
                    // for(int[] row : temp){
                    //     System.out.println(Arrays.toString(row));
                    // }
                    // System.out.println("키"+flag);
                    maps[map_idx].put(flag,temp);
                }
            }
        }
    }
}
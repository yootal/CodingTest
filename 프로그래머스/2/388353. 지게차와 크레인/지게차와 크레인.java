import java.util.*;

class Solution {
    static int[][] board;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static String[] storage;
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        this.storage = storage;
        board = new int[storage.length + 2][storage[0].length() + 2];
        for(int i = 0 ; i < storage.length ; i++){
            for(int j = 0 ; j < storage[i].length() ; j++){
                board[i + 1][j + 1] = storage[i].charAt(j) - 'A' + 1;
            }
        }
        for(int i = 0 ; i < requests.length ; i++){
            int cmd = requests[i].charAt(0) - 'A' + 1;
            if(requests[i].length() == 1){
                ArrayDeque<int[]> q = new ArrayDeque<>();
                boolean[][] vis = new boolean[storage.length + 2][storage[0].length() + 2];
                vis[0][0] = true;
                q.offer(new int[]{0,0});
                ArrayList<int[]> al = new ArrayList<>();
                while(!q.isEmpty()){
                    int[] cur = q.poll();
                    for(int d = 0 ; d < 4 ; d++){
                        int nx = cur[0] + dx[d];
                        int ny = cur[1] + dy[d];
                        if(limit(nx,ny) && !vis[nx][ny]){
                            if(board[nx][ny] == cmd){
                                vis[nx][ny] = true;
                                al.add(new int[]{nx,ny});
                            }
                            else if(board[nx][ny] == 0){
                                vis[nx][ny] = true;
                                q.offer(new int[]{nx,ny});
                            }
                        }
                    }
                }
                for(int[] pos : al){
                    board[pos[0]][pos[1]] = 0;
                }
            }
            else{
                for(int j = 1 ; j <= storage.length ; j++){
                    for(int k = 1 ; k <= storage[0].length() ; k++){
                        if(board[j][k] == cmd){
                            board[j][k] = 0;
                        }
                    }
                }
            }
        }
            for(int i = 1 ; i <= storage.length ; i++){
        for(int j = 1 ; j <= storage[0].length() ; j++){
            if(board[i][j] > 0){
                answer++;
            }
        }
    }
        return answer;
    }
    
    static boolean limit(int nx, int ny){
        return nx >= 0 && ny >= 0 && nx < storage.length + 2 && ny < storage[0].length() + 2;
    }
}
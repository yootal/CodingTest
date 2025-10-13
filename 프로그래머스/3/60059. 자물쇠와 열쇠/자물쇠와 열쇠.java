import java.util.*;

class Solution {
    static int n, m;
    public boolean solution(int[][] key, int[][] lock) {
        n = key.length;
        m = lock.length;
        int[][] board = new int[n*2+m][n*2+m];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0; j < m ; j++){
                board[i+n][j+n] = lock[i][j];
            }
        }
        if(solve(key,board)) return true;
        for(int r = 0 ; r < 3 ; r++){
            key = rotate(key);
            if(solve(key,board)) return true;
        }
        return false;
    }
    
    static int[][] rotate(int[][] key){
        int[][] newKey = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                newKey[j][n-1-i] = key[i][j];
            }
        }
        return newKey;
    }
    
    static boolean solve(int[][] key, int[][] board){
        for(int i = 0 ; i < n + m ; i++){
            for(int j = 0 ; j < n + m ; j++){
                
                for(int i2 = 0 ; i2 < n ; i2++){
                    for(int j2 = 0 ; j2 < n ; j2++){
                        board[i+i2][j+j2] += key[i2][j2];
                    }
                }
                if(check(board)) return true;
                for(int i2 = 0 ; i2 < n ; i2++){
                    for(int j2 = 0 ; j2 < n ; j2++){
                        board[i+i2][j+j2] -= key[i2][j2];
                    }
                }
            }
        }
        return false;
    }
    
    static boolean check(int[][] board){
        for(int i = n ; i < n + m ; i++){
            for(int j = n ; j < n + m ; j++){
                if(board[i][j] != 1) return false;
            }
        }
        return true;
    }
}
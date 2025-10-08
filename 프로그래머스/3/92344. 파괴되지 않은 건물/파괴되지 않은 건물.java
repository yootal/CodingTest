import java.util.*;

class Solution {
    static int n, m;
    public int solution(int[][] board, int[][] skill) {
        this.n = board.length;
        this.m = board[0].length;
        int[][] weight = new int[n][m];
        for(int[] s : skill){
            int type = s[0]; int r1 = s[1]; int c1 = s[2]; int r2 = s[3]; int c2 = s[4];
            int degree = s[5];
            if(type == 1){
                weight[r1][c1] -= degree;
                if(c2 + 1 < m)
                    weight[r1][c2 + 1] += degree;
                if(r2 + 1 < n)
                    weight[r2 + 1][c1] += degree;
                if(r2 + 1 < n && c2 + 1 < m)
                    weight[r2 + 1][c2 + 1] -= degree;
            }
            else{
                weight[r1][c1] += degree;
                if(c2 + 1 < m)
                    weight[r1][c2 + 1] -= degree;
                if(r2 + 1 < n)
                    weight[r2 + 1][c1] -= degree;
                if(r2 + 1 < n && c2 + 1 < m)
                    weight[r2 + 1][c2 + 1] += degree;
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 1 ; j < m ; j++){
                weight[i][j] += weight[i][j-1];
            }
        }
        for(int j = 0 ; j < m ; j++){
            for(int i = 1 ; i < n ; i++){
                weight[i][j] += weight[i-1][j];
            }
        }
        int answer = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(board[i][j] + weight[i][j] > 0) answer++;
            }
        }
        return answer;
    }
}
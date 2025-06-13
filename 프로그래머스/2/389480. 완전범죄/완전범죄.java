import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        
        int answer = -1;
        
        int[][] dp = new int[info.length + 1][m];
        int total = 0;
        
        for(int i = 1 ;  i <= info.length ; i++){
            int[] cur = info[i-1];
            total += cur[0];
            for(int j = 1 ; j < m ; j++){    
                dp[i][j] = dp[i-1][j];
                if(j >= cur[1]){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cur[1]] + cur[0]);
                }
            }
        }
        
        if(total - dp[info.length][m-1] < n){        
            answer = total - dp[info.length][m-1];
        }
        
        return answer;
    }
}
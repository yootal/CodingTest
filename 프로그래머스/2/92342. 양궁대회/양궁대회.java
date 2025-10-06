import java.util.*;

class Solution {
    static int[] info;
    static int[] answer;
    static int[] cur;
    static int max = 0;
    public int[] solution(int n, int[] info) {
        this.info = info;
        answer = new int[11];
        cur = new int[11];
        solve(0,n,0,0);
        return max == 0 ? new int[]{-1} : answer;
    }
    
    static void solve(int idx, int rest, int score1, int score2){
        if(idx == 11){
            cur[10] = rest;
            if(max < score1 - score2){
                max = score1 - score2;
                for(int i = 0 ; i < 11 ; i++){
                    answer[i] = cur[i];
                }
            }
            else if(max == score1 - score2){
                boolean flag = false;
                for(int i = 10 ; i >= 0 ; i--){
                    if(answer[i] < cur[i]){
                        flag = true;
                        break;
                    }
                    else if(answer[i] > cur[i]) break;
                }
                if(flag){
                    for(int i = 0 ; i < 11 ; i++){
                        answer[i] = cur[i];
                    }
                }
            }
            cur[10] = 0;
            return;
        }
        if(info[idx] < rest){
            cur[idx] = info[idx] + 1;
            solve(idx + 1, rest - (info[idx] + 1), score1 + (10 - idx), score2);
            cur[idx] = 0; 
        }
        solve(idx + 1, rest, score1, info[idx] > 0 ? score2 + (10 - idx) : score2);
    }
}
import java.util.*;

class Solution {
    static int N, answer = Integer.MAX_VALUE;
    static int[] picks;
    static String[] minerals;
    
    public int solution(int[] picks, String[] minerals) {
        N = minerals.length;
        this.picks = picks;
        this.minerals = minerals;
        int r = 0;
        for(int i = 0 ; i < 3 ; i++){
            r += picks[i];
        }
        solve(0, 0, r);
        return answer;
    }
    
    static void solve(int idx, int v, int r){
        if(idx == (N % 5 == 0 ? N / 5 : N / 5 + 1) || r == 0){
            answer = Math.min(answer, v);
            return;
        }
        
        for(int p = 0 ; p < 3 ; p++){
            if(picks[p] == 0) continue;
            int temp = v;
            for(int i = idx * 5 ; i < Math.min(N, idx * 5 + 5) ; i++){
                if(p == 0){
                    temp += 1;
                }
                else if(p == 1){
                    if(minerals[i].equals("diamond")) temp += 5;
                    else temp += 1;
                }
                else{
                    if(minerals[i].equals("diamond")) temp += 25;
                    else if(minerals[i].equals("iron")) temp += 5;
                    else temp += 1;
                }
            }
            picks[p]--;
            solve(idx + 1, temp, r - 1);
            picks[p]++;
        }
    }
}
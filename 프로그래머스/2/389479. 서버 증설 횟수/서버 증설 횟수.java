class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int[] server = new int[24];
        
        for(int i = 0 ; i < players.length ; i++){
            int cur = players[i];
            int need = cur / m;
            if(need > server[i]){
                int diff = need - server[i];
                for(int j = i ; j < (i + k < 24 ? i + k : 24) ; j++){
                    server[j] += diff;
                }
                answer += diff;
            }   
        }
        return answer;
    }
}
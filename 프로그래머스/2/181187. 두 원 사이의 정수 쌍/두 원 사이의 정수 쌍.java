class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        for(int i = 1; i <= r2 ; i++){
            if(i < r1){
                answer += (Math.floor(Math.sqrt((long)r2*r2-(long)i*i)) 
                           - Math.ceil(Math.sqrt((long)r1*r1-(long)i*i)) + 1);
            }
            else{
                answer += Math.floor(Math.sqrt((long)r2*r2-(long)i*i)) + 1;
            }
        }
        return answer * 4;
    }
}
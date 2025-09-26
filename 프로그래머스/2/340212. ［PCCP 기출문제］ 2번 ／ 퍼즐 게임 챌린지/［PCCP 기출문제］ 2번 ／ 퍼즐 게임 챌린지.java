class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int n = diffs.length;
        int s = 1, e = 100000;
        while(s < e){
            long value = 0;
            int level = (s+e)/2;
            for(int i = 0 ; i < n ; i++){
                int curDiff = diffs[i];
                int curTime = times[i];
                int preTime = i > 0 ? times[i-1] : 0;
                if(curDiff <= level){
                    value += curTime;
                }
                else{
                    value += (curTime + preTime)*(curDiff-level)+curTime;
                }
            }
            if(value <= limit){
                e = level;
            }
            else{
                s = level + 1;
            }
        }
        int answer = s;
        return answer;
    }
}
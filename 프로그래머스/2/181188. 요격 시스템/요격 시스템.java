import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        // Arrays.sort(targets,Comparator.comparingInt(o->o[1]));
        Arrays.sort(targets,(a,b) -> Integer.compare(a[1],b[1]));
        int end = -1;
        for(int[] target : targets){
            if(target[0] < end){
                continue;
            }
            if(end < target[1]){
                end = target[1];
                answer++;
            }
        }
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int ans = 0;
        for(int i = citations.length - 1 ; i >= 0 ; i--){
                ans = Math.max(ans, Math.min(citations.length - i, citations[i]));
        }
        return ans;
    }
}
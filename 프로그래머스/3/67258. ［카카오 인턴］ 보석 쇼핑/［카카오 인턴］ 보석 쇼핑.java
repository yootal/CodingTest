import java.util.*;

class Solution {
    public static int[] solution(String[] gems) {
        int n = gems.length;
        int vis[] = new int[n];
        HashMap<String, Integer> map = new HashMap<>();
        
        int idx = 0;
        for(int i = 0 ; i < n ; i++){
            if(!map.containsKey(gems[i])){
                map.put(gems[i],idx++);
            }
        }
        
        int range = Integer.MAX_VALUE;
        int ans[] = new int[2];
        int limit = map.size();
        int size = 0;
        int end = 0;
        for(int start = 0 ; start < n ; start++){
            while(end != n && size < limit){
                int curEd = map.get(gems[end]);
                if(vis[curEd] == 0){
                    size++;
                }
                vis[curEd]++;
                end++;
            }
            if(size == limit){
                int diff = end - start;
                if(range > diff){
                    range = diff;
                    ans[0] = start+1;
                    ans[1] = end;
                }
            }
            int curSt = map.get(gems[start]);
            if(vis[curSt] > 0){
                vis[curSt]--;
                if(vis[curSt] == 0) size--;
            }
            
        }
        return ans;
    }
}
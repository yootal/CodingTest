import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) { 
        HashMap<String,Integer> map = new HashMap<>();
        int idx = 0;
        for(String id : id_list) map.put(id,idx++);
        boolean[][] check = new boolean[id_list.length][id_list.length];
        int[] cnt = new int[id_list.length];
        for(String r : report){
            String[] t = r.split(" ");
            int idx1 = map.get(t[0]);
            int idx2 = map.get(t[1]);
            if(!check[idx1][idx2]){
                check[idx1][idx2] = true;
                cnt[idx2]++;
            }
        }
        int[] answer = new int[id_list.length];
        for(int i = 0 ; i < id_list.length ; i++){
            if(cnt[i] >= k){
                for(int j = 0 ; j < id_list.length ; j++){
                    if(check[j][i]) answer[j]++;
                }
            }
        }
        return answer;
    }
}
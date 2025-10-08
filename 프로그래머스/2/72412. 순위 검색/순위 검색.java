import java.util.*;

class Solution {
    static HashMap<String, ArrayList<Integer>> map;
    static String[] s;
    public int[] solution(String[] info, String[] query) {
        map = new HashMap<>();
        for(String i : info){
            s = i.split(" ");
            save(0, new StringBuilder());
        }
        for(String key : map.keySet()) Collections.sort(map.get(key));
        int[] answer = new int[query.length];
        for(int i = 0 ; i < query.length ; i++){
            String q = query[i];
            String key = q.replaceAll(" and ", "");   
            String[] temp = key.split(" ");
            if(map.containsKey(temp[0])){
                ArrayList<Integer> al = map.get(temp[0]);
                answer[i] = lowerBound(al, Integer.parseInt(temp[1]));
            }
            else{
                answer[i] = 0;
            }
        }
        return answer;
    }
    
    static void save(int idx, StringBuilder sb){
        if(idx == 4){
            String result = sb.toString();
            ArrayList<Integer> al = map.getOrDefault(result, new ArrayList<>());
            al.add(Integer.parseInt(s[4]));
            map.put(result, al);
            return;
        }
        save(idx + 1, new StringBuilder(sb).append(s[idx]));
        save(idx + 1, new StringBuilder(sb).append("-"));
    }
    
    static int lowerBound(ArrayList<Integer> al, int x){
        int lo = -1;
        int hi = al.size();
        while(lo + 1 < hi){
            int mid = (lo + hi) / 2;
            if(al.get(mid) < x){
                lo = mid;
            }
            else{
                hi = mid;
            }
        }
        return al.size() - hi;
    }
}
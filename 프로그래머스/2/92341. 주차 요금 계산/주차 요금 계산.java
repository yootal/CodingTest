import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String,Integer> map1 = new HashMap<>();
        TreeMap<String,Integer> map2 = new TreeMap<>();
        for(String record : records){
            String[] r = record.split(" ");
            String[] t = r[0].split(":");
            int h = Integer.parseInt(t[0]) * 60;
            int m = Integer.parseInt(t[1]);
            if(map1.containsKey(r[1])){
                map2.put(r[1], map2.getOrDefault(r[1], 0) + h + m - map1.get(r[1]));
                map1.remove(r[1]);
            }
            else{
                map1.put(r[1],h + m);
            }
        }
        for(Map.Entry<String, Integer> e : map1.entrySet()){
            map2.put(e.getKey(), map2.getOrDefault(e.getKey(), 0) + 23 * 60 + 59 - e.getValue());
        }
        int[] answer = new int[map2.size()];
        int idx = 0;
        for(Map.Entry<String, Integer> e : map2.entrySet()){
            int time = e.getValue();
            int cost = 0;
            if(time > fees[0]){
                cost += fees[1];
                cost += Math.ceil((double)(time - fees[0]) / fees[2]) * fees[3];
            }
            else{
                cost = fees[1];
            }
            answer[idx++] = cost;
            
        }
        return answer;
    }
}
import java.util.*;

class Solution {
    static String order = null;
    static HashMap<String, Integer> map;
    static int max;
    static StringBuilder sb;
    static int limit;
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> al = new ArrayList<>();
        for(int i = 0 ; i < orders.length ; i++){
            char[] ca = orders[i].toCharArray();
            Arrays.sort(ca);
            orders[i] = new String(ca);
        }
        for(int v : course){
            map = new HashMap<>();
            max = 0;
            limit = v;
            for(int i = 0 ; i < orders.length ; i++){
                if(v <= orders[i].length()){
                    sb = new StringBuilder();
                    order = orders[i];
                    dfs(0, 0);
                }
            }
            for(Map.Entry<String,Integer> entry : map.entrySet()){
                if(entry.getValue() > 1 && entry.getValue() == max){
                    al.add(entry.getKey());
                }
            }
        }
        Collections.sort(al);
        String[] answer = new String[al.size()];
        for(int i = 0 ; i < al.size() ; i++){
            answer[i] = al.get(i);
        }
        return answer;
    }
    
    static void dfs(int idx, int cnt){
        if(cnt == limit){
            String s = sb.toString();
            map.put(s, map.getOrDefault(s, 0) + 1);
            max = Math.max(max, map.get(s));
            return;
        }
        for(int i = idx ; i < order.length() ; i++){
            if(cnt < limit){
                sb.append(order.charAt(i));
                dfs(i + 1, cnt + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        String[] t1 = today.split("\\.");
        int day1 = Integer.parseInt(t1[0]) * 12 * 28 + Integer.parseInt(t1[1]) * 28 + Integer.parseInt(t1[2]);
        HashMap<String,Integer> map = new HashMap<>();
        for(String term : terms){
            String[] t2 = term.split(" ");
            map.put(t2[0],Integer.parseInt(t2[1]) * 28);
        }
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0 ; i < privacies.length ; i++){
            String p = privacies[i];
            StringTokenizer st = new StringTokenizer(p," ");
            String[] t3 = st.nextToken().split("\\.");
            int value = map.get(st.nextToken());
            int day2 = Integer.parseInt(t3[0]) * 12 * 28 + Integer.parseInt(t3[1]) * 28 + Integer.parseInt(t3[2]);
            if(day2 + value - 1 < day1) al.add(i+1);
        }
        int[] answer = new int[al.size()];
        for(int i = 0 ; i < al.size() ; i++){
            answer[i] = al.get(i);
        }
        return answer;
    }
}
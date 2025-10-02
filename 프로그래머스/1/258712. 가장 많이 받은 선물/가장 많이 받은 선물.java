import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int[][] info = new int[friends.length][friends.length];
        HashMap<String,Integer> map = new HashMap<>();
        HashMap<String,Integer> give = new HashMap<>();
        HashMap<String,Integer> get = new HashMap<>();
        for(int i = 0 ; i < friends.length ; i++){
            map.put(friends[i],i);
        }
        for(String gift : gifts){
            String[] temp = gift.split(" ");
            int a = map.get(temp[0]);
            int b = map.get(temp[1]);
            info[a][b]++;
            give.put(temp[0],give.getOrDefault(temp[0], 0) + 1);
            get.put(temp[1],get.getOrDefault(temp[1], 0) + 1);
        }
        int[] count = new int[friends.length];
        for(int i = 0 ; i < friends.length ; i++){
            for(int j = i + 1 ; j < friends.length ; j++){
                int v1 = info[i][j];
                int v2 = info[j][i];
                if(v1 == v2){
                    int g1 = give.getOrDefault(friends[i],0) - get.getOrDefault(friends[i],0);
                    int g2 = give.getOrDefault(friends[j],0) - get.getOrDefault(friends[j],0);
                    if(g1 > g2){
                        count[i]++;
                    }
                    else if(g1 < g2){
                        count[j]++;
                    }
                }
                else{
                    if(v1 > v2){
                        count[i]++;
                    }
                    else if(v1 < v2) {
                        count[j]++;
                    }
                }
            }
        }
        int answer = 0;
        for(int i = 0 ; i < friends.length ; i++){
            answer = Math.max(answer, count[i]);
        }
        return answer;
    }
}
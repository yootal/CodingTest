import java.util.*;

class Solution {
    static int c[];
    static boolean vis[];
    public int solution(int[] cards) {
        c = cards;
        vis = new boolean[cards.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0 ; i < cards.length ; i++){
            if(!vis[i]){
                pq.offer(select(i));
            }
        }
        int answer = 1;
        for(int i = 0 ; i < 2 ; i++){
            int o = pq.poll();
            if(o == cards.length){
                answer = 0;
                break;
            }
            answer *= o;
        }
        return answer;
    }
    
    static int select(int x){
        if(vis[x]) return 0;
        vis[x] = true;
        return 1 + select(c[x]-1);
    }
}
import java.util.*;

class Solution {
    static int needAlp, needCop;
    static int[][] ps;
    
    public int solution(int alp, int cop, int[][] problems) {
        ps = new int[problems.length + 2][5];
        for(int i = 0 ; i < problems.length ; i++){
            int[] cur = problems[i];
            ps[i] = cur;
            needAlp = Math.max(needAlp,cur[0]);
            needCop = Math.max(needCop,cur[1]);
        }
        ps[problems.length] = new int[]{0,0,1,0,1};
        ps[problems.length + 1] = new int[]{0,0,0,1,1};
        int[][] time = new int[500][500];
        for(int i = 0 ; i < 500 ; i++){
            Arrays.fill(time[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(i->i[2]));
        time[alp][cop] = 0;
        q.offer(new int[]{alp,cop,0});
        int answer = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(answer < cur[2] || time[cur[0]][cur[1]] != cur[2]) continue;
            if(cur[0] >= needAlp && cur[1] >= needCop) {
                answer = Math.min(answer,cur[2]);
                continue;
            }
            for(int i = 0 ; i < ps.length ; i++){
                int[] p =  ps[i];
                if(cur[0] >= p[0] && cur[1] >= p[1]){
                    if(time[cur[0] + p[2]][cur[1] + p[3]] > cur[2] + p[4]){
                        time[cur[0] + p[2]][cur[1] + p[3]] = cur[2] + p[4];
                        q.offer(new int[]{cur[0] + p[2], cur[1] + p[3], cur[2] + p[4]});
                    }
                }
            }
        }
        return answer;
    }
}
import java.util.*;

class Solution {
    static class Info{
        String subject;
        int time;
        int rest;
        public Info(String subject, int time, int rest){
            this.subject = subject;
            this.time = time;
            this.rest = rest;
        }
    }
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        Info[] infos = new Info[plans.length];
        for(int i = 0 ; i < plans.length; i++){
            String[] plan = plans[i];
            StringTokenizer st = new StringTokenizer(plan[1],":");
            int time = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
            int rest = Integer.parseInt(plan[2]);
            infos[i] = new Info(plan[0],time,rest);
        }
        Arrays.sort(infos,Comparator.comparingInt(o -> o.time));
        ArrayDeque<Info> stack = new ArrayDeque<>();
        int curTime = infos[0].time;
        stack.push(infos[0]);
        int idx = 0;
        for(int i = 1 ; i < plans.length ; i++){
            Info cur = infos[i];
            while(!stack.isEmpty() && curTime < cur.time){
                Info prev = stack.pop();
                curTime += prev.rest;
                if(curTime > cur.time){
                    prev.rest = (curTime - cur.time);
                    stack.push(prev);
                    curTime = cur.time;
                }
                else {
                    answer[idx++] = prev.subject;
                }
            }
            curTime = cur.time;
            stack.push(cur);
        }
        while(!stack.isEmpty()){
            Info prev = stack.pop();
            answer[idx++] = prev.subject;        
        }
        return answer;
    }
}
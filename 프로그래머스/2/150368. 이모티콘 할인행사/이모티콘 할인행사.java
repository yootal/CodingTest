import java.util.*;

class Solution {
    static int n,m;
    static int[] rate;
    static int[][] users;
    static int[] emoticons;
    static ArrayList<Info> al;
    static class Info{
        int cnt, total;
        public Info(int cnt , int total){
            this.cnt = cnt;
            this.total = total;
        }
    }
    
    public int[] solution(int[][] users, int[] emoticons) {
        al = new ArrayList<>();
        this.users = users;
        this.emoticons = emoticons;
        n = users.length;
        m = emoticons.length;
        rate = new int[m];
        solve(0);
        Collections.sort(al, Comparator.comparingInt((Info i) -> -i.cnt).thenComparingInt(i -> -i.total));
        int[] answer = new int[2];
        answer[0] = al.get(0).cnt;
        answer[1] = al.get(0).total;
        return answer;
    }
    
    static void solve(int idx){
        if(idx == m){
            int cnt = 0;
            int total = 0;
            for(int i = 0 ; i < n ; i++){
                int want = users[i][0];
                int limit = users[i][1];
                int sum = 0;
                boolean flag = false;
                for(int e = 0 ; e < m ; e++){
                    if(rate[e] >= want){
                        sum += emoticons[e] * (100-rate[e]) / 100;
                        if(sum >= limit){
                            cnt++;
                            flag = true;
                        }
                    }
                    if(flag) break;
                }
                if(!flag) total += sum;
            }
            al.add(new Info(cnt,total));
            return;
        }
        for(int r = 1 ; r <= 4 ; r++){
            rate[idx] = r * 10;
            solve(idx + 1);
        }
    }
}
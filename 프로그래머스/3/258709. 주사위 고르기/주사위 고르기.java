import java.util.*;

class Solution {
    static int n;
    static int full;
    static int[][] dice;
    static ArrayList<Integer> al1;
    static ArrayList<Integer> al2;
    static HashMap<Integer,Integer> map = new HashMap<>();
    
    public int[] solution(int[][] dice) {
        n = dice.length;
        this.dice = dice;
        full = (1 << n) - 1;
        solve(0,0,0);        
        int max = 0;
        int flag = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int value = entry.getValue();
            System.out.println(value);
            if(max < value){
                max =  value;
                flag = entry.getKey();
            }
        }
        int idx = 0;
        int[] answer = new int[n/2];
        for(int i = 0 ; i < n ; i++){
            if((flag & (1 << i)) > 0){
                answer[idx++] = i+1;
            }
        }
        return answer;
    }

    static void solve(int flag, int cnt, int idx){
        if(cnt == n/2){
            al1 = new ArrayList<>();
            al2 = new ArrayList<>();
            count(flag,0,0,al1);
            count(full ^ flag,0,0,al2);
            Collections.sort(al1);
            Collections.sort(al2);
            int sum = 0;
            for(int i = 0 ; i < al1.size() ; i++){
                int pos = lowerBound(al1.get(i));
                sum += pos;
            }
            map.put(flag, sum);
            return;
        }
        for(int i = idx ; i < n ; i++){
            if((flag & (1<<i)) == 0){
                solve(flag | (1<<i),cnt + 1,i+1);
            }
        }
    }
    
    static void count(int flag, int v, int cnt, ArrayList<Integer> al){
        if(cnt == n){
            al.add(v);
            return;
        }
        if((flag & (1 << cnt)) > 0){
            for(int j = 0 ; j < 6 ; j++){
                count(flag, v + dice[cnt][j], cnt+1, al);
            }
        }
        else{
            count(flag, v, cnt+1, al);
        }
    }
    
    static int lowerBound(int x){
        int lo = -1;
        int hi = al2.size();
        while(lo + 1 < hi){
            int mid = (lo + hi) / 2;
            int v = al2.get(mid);
            if(v < x){
                lo = mid;
            }
            else{
                hi = mid;
            }
        }
        return hi;
        // int lo = 0;
        // int hi = al2.size();
        // while(lo < hi){
        //     int mid = (lo + hi) / 2;
        //     int v = al2.get(mid);
        //     if(v < x){
        //         lo = mid + 1;
        //     }
        //     else{
        //         hi = mid;
        //     }
        // }
        // return lo;
    }
}

















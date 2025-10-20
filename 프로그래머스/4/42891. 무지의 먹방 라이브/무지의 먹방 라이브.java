import java.util.*;

class Solution {
    static int[] tf;
    public int solution(int[] food_times, long k) {
        int answer = -1;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); 
        int len = food_times.length;
        tf = new int[len];
        for(int i = 0 ; i < len ; i++) tf[i] = food_times[i];
        Arrays.sort(tf);
        long sum = 0;
        for(int i = 0 ; i < food_times.length ; i++){
            int cur = food_times[i];
            sum += cur;
            pq.offer(new int[]{i,cur});
        }
        if(sum <= k) return answer;
        int cycle = 0;
        while(!pq.isEmpty() && k - (long) len * (pq.peek()[1] - cycle) > 0){
            int out = pq.peek()[1];
            while(!pq.isEmpty() && pq.peek()[1] == out){
                int[] temp = pq.poll();
                food_times[temp[0]] = 0;
            }
            int cnt = count(out);
            k -= (long) len * (out - cycle);
            len -= cnt;
            cycle += (out - cycle);
        }
        long pos = k % len;
        for (int i = 0; i < food_times.length; i++) {
            if (food_times[i] == 0) continue;
            if (pos == 0) {
                answer = i + 1;
                break;
            }
            pos--;
        }
        return answer;
    }
    
    static int count(int x){
        int lo = -1, hi = tf.length;
        while(lo + 1 < hi){
            int mid = (lo + hi) / 2;
            if(tf[mid] <= x) lo = mid;
            else hi = mid;
        }
        int upper = hi;
        lo = -1; hi = tf.length;
        while(lo + 1 < hi){
            int mid = (lo + hi) / 2;
            if(tf[mid] < x) lo = mid;
            else hi = mid;
        }
        int lower = hi;
        return upper - lower;
    }
}
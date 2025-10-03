import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        ArrayList<Integer> al1 = new ArrayList<>();
        ArrayList<Integer> al2 = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if(deliveries[i] > 0) al1.add(i);
            if(pickups[i] > 0) al2.add(i);
        }
        int idx1 = al1.size() - 1;
        int idx2 = al2.size() - 1;
        int r1 = 0;
        int r2 = 0;
        for(int i = n - 1 ; i >= 0 ; i--){
            if(  (idx1 >= 0 && al1.get(idx1) == i) || (idx2 >= 0 && al2.get(idx2) == i) ){
                while(deliveries[i] > 0 || pickups[i] > 0){
                    r1 = cap;
                    r2 = cap;
                    if(idx1 >= 0){
                        for(int j = idx1 ; j >= 0 ; j--){
                            int i1 = al1.get(j);
                            if(deliveries[i1] > 0 && deliveries[i1] <= r1){
                                r1 -= deliveries[i1];
                                deliveries[i1] = 0;
                                idx1--;
                            }
                            else if(deliveries[i1] > 0 && r1 > 0){
                                deliveries[i1] -= r1;
                                r1 = 0;
                            }
                            if(r1 == 0) break;
                        }
                    }
                    if(idx2 >= 0){
                        for(int j = idx2 ; j >= 0 ; j--){
                            int i2 = al2.get(j);
                            if(pickups[i2] > 0 && pickups[i2] <= r2){
                                r2 -= pickups[i2];
                                pickups[i2] = 0;
                                idx2--;
                            }
                            else if(pickups[i2] > 0 && r2 > 0){
                                pickups[i2] -= r2;
                                r2 = 0;
                            }
                            if(r2 == 0) break;
                        }
                    }
                    answer += (long)(i+1) * 2;
                }
            }
        }
        return answer;
    }
}
import java.util.*;

class Solution {
    static int[] stages;
    public int[] solution(int N, int[] stages) {
        this.stages = stages;
        Arrays.sort(stages);
        Integer[] intAnswer = new Integer[N];
        for(int i = 1 ; i <= N ; i++){
            intAnswer[i-1] = i;
        }
        Arrays.sort(intAnswer, (a,b) -> compare(a,b));
        int[] answer = new int[N];
        for(int i = 0 ; i < N ; i++){
            answer[i] = intAnswer[i];
        }
        return answer;
    }
    
    static int lowerBound(int x){
        int lo = -1, hi = stages.length;
        while(lo + 1 < hi){
            int mid = (lo + hi) / 2;
            if(stages[mid] >= x){
                hi = mid;
            }
            else{
                lo = mid;
            }
        }
        return hi;
    }
    
    static int upperBound(int x){
        int lo = -1, hi = stages.length;
        while(lo + 1 < hi){
            int mid = (lo + hi) / 2;
            if(stages[mid] > x){
                hi = mid;
            }
            else{
                lo = mid;
            }
        }
        return hi;
    }
    
    static int compare(int x, int y){
        int li1 = lowerBound(x);
        int hi1 = upperBound(x);
        int li2 = lowerBound(y);
        int hi2 = upperBound(y);
        int total1 = stages.length - li1;
        int total2 = stages.length - li2;
        double tv1 = (total1 == 0) ? 0.0 : (double)(hi1 - li1) / total1;
        double tv2 = (total2 == 0) ? 0.0 : (double)(hi2 - li2) / total2;
        if(tv1 < tv2) return 1;
        else if(tv1 > tv2) return -1;
        else return Integer.compare(x,y);
    }
}
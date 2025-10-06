import java.util.*;

class Solution {
    static int[] p;
    public int solution(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            sb.append(n % k);
            n /= k;
        }
        String s = sb.reverse().toString();
        int answer = 0;
        String[] nums = s.split("0");
        for(int i = 0 ; i < nums.length ; i++){
            String num = nums[i];
            if(num.length() > 0){
                long x = Long.parseLong(num);
                if(check(x)){
                    answer++;
                }
            }
        }
        return answer;
    }
    
    static boolean check(Long x){
        if(x == 1) return false; 
        for(long i = 2 ; i * i <= x ; i++){
            if(x % i == 0) return false;
        }
        return true;
    }
}
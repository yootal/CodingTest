class Solution {
    
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for(int i = 0 ; i < numbers.length ; i++){
            long num = numbers[i];
            StringBuilder sb = new StringBuilder();
            while (num > 0) {
                sb.append(num % 2);
                num /= 2;
            }
            int len = sb.length();
            int target = 1;
            while ((target - 1) < len) target *= 2;
            for (int z = 0; z < target - 1 - len; z++) sb.append('0');
            String s = sb.reverse().toString();
            int mid = s.length() / 2;
            boolean flag;
            if(s.charAt(mid) == '1') flag = tree(s);
            else flag = false;
            answer[i] = flag ? 1 : 0; 
        }
        return answer;
    }
    
    static boolean tree(String s){
        int len = s.length();
        if(len == 1){
            return true; 
        }
        int mid = len / 2;
        String left = s.substring(0,mid);
        String right = s.substring(mid+1);
        if(s.charAt(mid) == '1'){
            return tree(left) && tree(right);
        }
        return zero(left) && zero(right);
    }
    
    static boolean zero(String s){
        int len = s.length();
        if(len == 1){
            return s.charAt(0) == '0' ? true : false; 
        }
        int mid = len / 2;
        if(s.charAt(mid) != '0') return false;
        String left = s.substring(0,mid);
        String right = s.substring(mid+1);
        return zero(left) && zero(right);
    }
}
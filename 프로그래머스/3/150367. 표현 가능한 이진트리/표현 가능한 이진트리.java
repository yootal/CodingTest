class Solution {
    static String bi;
    static boolean biCheck;
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for(int i = 0 ; i < numbers.length ; i++){
            long num = numbers[i];
            StringBuilder sb = new StringBuilder();
            if (num == 0) {
                sb.append('0');
            } else {
                while (num > 0) {
                    sb.append(num % 2);
                    num /= 2;
                }
                sb.reverse();
            }
            bi = sb.toString();
            int len = bi.length();
            int target = 1;
            while (target < len) 
                target = target * 2 + 1;
            if (target > len) {
                StringBuilder pad = new StringBuilder();
                for (int z = 0; z < target - len; z++) pad.append('0');
                pad.append(bi);
                bi = pad.toString();
            }
            biCheck = true;
            int mid = bi.length() / 2;
            if(bi.charAt(mid) == '1'){
                dfs(mid,0,bi.length()-1,true);
            }
            else{
                dfs(mid,0,bi.length()-1,false);
            }
            answer[i] = biCheck ? 1 : 0; 
        }
        return answer;
    }
    
    static void dfs(int x, int l, int r, boolean flag){
        if(!biCheck) return;
        int size = x - l;
        boolean check = bi.charAt(x) == '0' ? false : true;
        if(!flag && check) {
            biCheck = false;
            return;
        }
        if(l == r) return;
        dfs(l + (size/2), l, x - 1, check);
        dfs(x + 1 + (size/2), x + 1, r, check);
    }
}
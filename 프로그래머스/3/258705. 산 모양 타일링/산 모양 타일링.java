class Solution {
    public int solution(int n, int[] tops) {
        int[] dp1 = new int[n+1];
        int[] dp2 = new int[n+1];
        dp1[0] = 1;
        dp2[0] = tops[0] == 1 ? 3 : 2;
        for(int i = 1 ; i < n ; i++){
            if(tops[i] == 1){
                dp1[i] = dp1[i-1] + dp2[i-1];
                dp2[i] = dp1[i-1] * 2 + dp2[i-1] * 3;
            }
            else{
                dp1[i] = dp1[i-1] + dp2[i-1];
                dp2[i] = dp1[i-1] + dp2[i-1] * 2;   
            }
            dp1[i] %= 10007;
            dp2[i] %= 10007;
        }
        
        return (dp1[n-1] + dp2[n-1]) % 10007;
    }
}
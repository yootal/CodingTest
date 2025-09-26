class Solution {
    static boolean[] check;
    static int[][] q;
    static int n;
    static int[] ans;
    static int answer;
    public int solution(int n, int[][] q, int[] ans) {
        check = new boolean[n + 1];
        this.n = n;
        this.q = q;
        this.ans = ans;
        solve(0,0);
        return answer;
    }
    
    static void solve(int idx, int cnt){
        if(cnt == 5){
            for(int i = 0 ; i < q.length ; i++){
                int[] cur = q[i];
                int count = 0;
                for(int j = 0 ; j < cur.length ; j++){
                    if(check[cur[j]]) count++;
                }
                if(count != ans[i]) return;
            }
            answer++;
            return;
        }
        for(int i = idx + 1; i <= n ; i++){
            if(!check[i]){
                check[i] = true;
                solve(i,cnt+1);
                check[i] = false;
            }
        }
    }
}
import java.util.*;

class Solution {
    static int n,m;
    static String sa[], sb[];
    static boolean vis[];
    static HashSet<String> set;
    
    public static int solution(String[] user_id, String[] banned_id) {
        n = user_id.length;
        m = banned_id.length;
        sa = user_id;
        sb = banned_id;
        vis = new boolean[n];
        set = new HashSet<>();
        solve(0);
        return set.size();
    }
    
    static void solve(int cur){
        if(cur == m){
            String temp = "";
            for(int i = 0 ; i < n ; i++){
                if(vis[i]) temp+=i;
            }
            set.add(temp);
            return;
        }
        for(int idx = 0 ; idx < n ; idx++){
            if(vis[idx]) continue;
            if(check(sa[idx], sb[cur])){
                vis[idx] = true;
                solve(cur + 1);
                vis[idx] = false;
            }
        }
    }
    
    static boolean check(String a, String b){
        if(a.length() != b.length()) return false;
        for(int i = 0 ; i < a.length() ; i++){
            char curA = a.charAt(i);
            char curB = b.charAt(i);
            if(curB == '*') continue;
            else if(curA != curB) return false;
        }
        return true;
    }
}
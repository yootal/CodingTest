import java.util.*;

class Solution {
    static int n,m,vis;
    static String[][] relation;
    static HashSet<Integer> fSet = new HashSet<>();
    public int solution(String[][] relation) {
        this.relation = relation;
        n = relation.length;
        m = relation[0].length;
        solve(0,0);
        return fSet.size();
    }
    
    static void solve(int idx, int flag){
        if(idx == m){
            HashSet<String> set = new HashSet<>();
            for(int i = 0 ; i < n ; i++){
                StringBuilder sb =  new StringBuilder();
                for(int j = 0 ; j < m ;j++){
                    if( (flag & (1 << j)) != 0){
                        sb.append(relation[i][j]).append(" ");
                    }
                }
                set.add(sb.toString());
            }
            if(set.size() == n){
                for (int f : fSet) {
                    if ( (f & flag) == f ) return;
                }
                fSet.add(flag); 
            }
            return;
        }
        solve(idx + 1, flag);
        solve(idx + 1, flag | (1 << idx));
    }
}
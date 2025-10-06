import java.util.*;

class Solution {
    static int answer;
    static int[] info;
    static int[][] edges;
    static boolean[] vis;
    
    public int solution(int[] info, int[][] edges) {
        this.info = info;
        this.edges = edges;
        vis = new boolean[info.length];
        vis[0] = true;
        solve(1,0);        
        return answer;
    }

    public void solve(int sheep, int wolf){
        if(sheep > wolf) answer = Math.max(answer, sheep);
        else return;
        for(int[] edge : edges){
            if(vis[edge[0]] && !vis[edge[1]]){
                vis[edge[1]] = true;
                if(info[edge[1]] == 0){
                    solve(sheep + 1, wolf);
                }
                else{
                    solve(sheep, wolf + 1);
                }
                vis[edge[1]] = false;
            }
        }
    }
}
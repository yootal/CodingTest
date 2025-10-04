import java.util.*;

class Solution {
    static int[] dx = {1,0,0,-1};
    static int[] dy = {0,-1,1,0};
    static String[] nxt = {"d","l","r","u"};
    static int n,m,x,y,r,c,k;
    static String answer = null;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        this.n = n;
        this.m = m;
        this.x = x;
        this.y = y;
        this.r = r;
        this.c = c;
        this.k = k;
        if(calc(x,y,r,c) % 2 != k % 2) return "impossible";
        if(calc(x,y,r,c) > k) return "impossible";
        dfs(x,y,new StringBuilder());
        return answer;
    }
    
    static void dfs(int cx, int cy, StringBuilder sb){
        if(answer != null) return;
        
        if(sb.length() == k){
            if(cx == r && cy == c)
                answer = sb.toString();
            return;            
        }
        
        int dist = calc(cx,cy,r,c);
        if(k < dist + sb.length()) return;
        
        for(int d = 0 ; d < 4 ; d++){
            int nx = cx + dx[d], ny = cy + dy[d];
            if(nx>=1&&ny>=1&&nx<=n&&ny<=m){
                sb.append(nxt[d]);
                dfs(nx,ny,sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    
    static int calc(int x1, int y1, int x2, int y2){
        return Math.abs(x2-x1) + Math.abs(y2-y1);    
    }
}
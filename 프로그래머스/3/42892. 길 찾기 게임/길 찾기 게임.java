import java.util.*;

class Solution {
    public class Info {
        int x;
        int y;
        int v;
        Info left;
        Info right;
        public Info(int x, int y, int v, Info left, Info right) {
            this.x = x;
            this.y = y;
            this.v = v;
            this.left = left;
            this.right = right;
        }
        
    }
    static int[][] answer;
    static int idx;
    
    public int[][] solution(int[][] nodeinfo) {
        Info[] infos = new Info[nodeinfo.length];
        for(int i = 0 ; i < infos.length ; i++){
            int[] row = nodeinfo[i];
            infos[i] = new Info(row[0],row[1],i+1,null,null);
        }
        Arrays.sort(infos, Comparator.comparingInt((Info i) -> -i.y).thenComparingInt(i -> i.x));
        Info root = infos[0];
        for(int i = 1; i < infos.length ; i++){
            insert(root, infos[i]);
        }
        answer = new int[2][infos.length];
        preorder(root);
        idx = 0;
        postorder(root);
        return answer;
    }
    
    public void insert(Info p, Info c) {
        if(p.x > c.x) {
            if(p.left == null) p.left = c;
            else insert(p.left, c);
        } 
        else {
            if(p.right == null) p.right = c;
            else insert(p.right, c);
        }
    }
    
    static void preorder(Info root){
        if(root != null) {
            answer[0][idx++] = root.v;
            preorder(root.left);
            preorder(root.right);
        }
    }
    
    static void postorder(Info root){
        if(root != null) {
            postorder(root.left);
            postorder(root.right);
            answer[1][idx++] = root.v;
        }
    }
}


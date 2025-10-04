import java.util.*;

class Solution {
    static int[] parent = new int[2500];
    public String[] solution(String[] commands) {
        String[][] board =  new String[50][50];
        for(int i = 0 ; i < 50 ; i++){
            for(int j = 0 ; j < 50 ; j++){
                board[i][j] = "";
            }
        }
        for(int i = 0 ; i < 2500 ; i++) parent[i] = i;
        ArrayList<String> ans = new ArrayList<>();
        for(String command : commands){
            StringTokenizer st = new StringTokenizer(command);
            String cmd = st.nextToken();
            if (cmd.equals("UPDATE")) {
                if (st.countTokens() == 3) {
                    int r = Integer.parseInt(st.nextToken());
                    int c = Integer.parseInt(st.nextToken());
                    String value = st.nextToken();
                    int idx = getIdx(r,c);
                    int p = find(idx);
                    for(int i = 0 ; i < 2500 ; i++){
                        if(parent[i] == p){
                            int tr = i / 50;
                            int tc = i % 50;
                            board[tr][tc] = value;
                        }
                    }
                } 
                else {
                    String value1 = st.nextToken();
                    String value2 = st.nextToken();
                    for(int i = 0 ; i < 50 ; i++){
                        for(int j = 0 ; j < 50 ; j++){
                            if(board[i][j].equals(value1)) {
                                board[i][j] = value2;
                            }
                        }
                    }
                }
            } 
            else if (cmd.equals("MERGE")) {
                int r1 = Integer.parseInt(st.nextToken());
                int c1 = Integer.parseInt(st.nextToken());
                int r2 = Integer.parseInt(st.nextToken());
                int c2 = Integer.parseInt(st.nextToken());
                int idx1 = getIdx(r1,c1);
                int idx2 = getIdx(r2,c2);
                int p1 = find(idx1);
                int p2 = find(idx2);
                if(!union(idx1,idx2)) continue;
                int p = find(p1);
                String value = "";
                if(board[r1-1][c1-1].equals("") && !board[r2-1][c2-1].equals("")){
                    value = board[r2-1][c2-1];
                }
                else value = board[r1-1][c1-1];
                for(int i = 0 ; i < 2500 ; i++){
                    if(parent[i] == p1 || parent[i] == p2){
                        parent[i] = p;
                        int tr = i / 50;
                        int tc = i % 50;
                        board[tr][tc] = value;
                    }
                }
            } 
            else if (cmd.equals("UNMERGE")) {
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                String value = board[r-1][c-1];
                int idx = getIdx(r,c);
                int p = parent[idx];
                for(int i = 0 ; i < 2500 ; i++){
                    if(p == find(i)){
                        parent[i] = i;
                        int tr = i / 50;
                        int tc = i % 50;
                        board[tr][tc] = ""; 
                    }
                }  
                board[r-1][c-1] = value;
            } 
            else {
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                ans.add(board[r-1][c-1]);
            }
            // for(int i = 0 ; i < 50 ; i++){
            //     for(int j = 0 ; j < 50 ; j++){
            //         System.out.print(board[i][j] + " ");
            //     }
            //     System.out.println();
            // }
        }        
        String[] answer = new String[ans.size()];
        for(int i = 0 ; i < ans.size() ; i++){
            answer[i] = ans.get(i).equals("") ? "EMPTY" : ans.get(i);
        }
        return answer;
    }
    
    static int getIdx(int r, int c){
        return (r - 1) * 50 + (c - 1);
    }
    
    static int find(int x){
        if(parent[x] == x) return parent[x];
        return parent[x] = find(parent[x]);
    }
    
    static boolean union(int x, int y){
        x = find(x);
        y = find(y);
        if(x == y) return false;
        if(x < y) parent[y] = x;
        else parent[x] = y;
        return true;
    }
}
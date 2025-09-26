import java.util.*;

class Solution {
    static int[][] edges;
    static int[] in, out;
    static final int MAX = 1000000;
    
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        this.edges = edges;
        in = new int[MAX+1];
        out = new int[MAX+1];
        for(int i = 0 ; i < edges.length ; i++){
            in[edges[i][1]]++;
            out[edges[i][0]]++;
        }
        for(int i = 1 ; i <= MAX ; i++){
            if(in[i] == 0 && out[i] >= 2){ // 시작점
                answer[0] = i;
            }
            else if(in[i] > 0 && out[i] == 0){ // 막대
                answer[2]++;
            }
            else if(in[i] >= 0 && out[i] >= 2){ // 8자
                answer[3]++;
            }
        }
        answer[1] = out[answer[0]] - (answer[2] + answer[3]); // 도넛
        return answer;
    }
}
class Solution {
    public int solution(int[][] points, int[][] routes) {
        int n = points.length;
        int r = routes.length;
        int m = routes[0].length; // 경로 길이
        int[][] record = new int[r][3];
        for (int i = 0; i < r; i++) {
            record[i][0] = points[routes[i][0]-1][0];
            record[i][1] = points[routes[i][0]-1][1];
            record[i][2] = 1;
        }
        int finish = 0;
        int answer = 0;
        while(finish < r){
            int[][] vis = new int[101][101];
            for(int i = 0 ; i < r ; i++){
                if(record[i][2] < m){
                    vis[record[i][0]][record[i][1]]++;
                    if(vis[record[i][0]][record[i][1]] == 2){
                        answer++;
                    }
                }
            }
            for(int i = 0 ; i < r ; i++){
                if(record[i][2] < m){
                    int nxtR = points[routes[i][record[i][2]] - 1][0];
                    int nxtC = points[routes[i][record[i][2]] - 1][1];
                    if(record[i][0] == nxtR && record[i][1] == nxtC){
                        record[i][2]++;
                        if(record[i][2] == m){
                            finish++;
                            continue;
                        }
                        nxtR = points[routes[i][record[i][2]] - 1][0];
                        nxtC = points[routes[i][record[i][2]] - 1][1];
                    }
                    if(nxtR != record[i][0]){
                        record[i][0] += nxtR > record[i][0] ? 1 : -1;
                    }
                    else{
                        record[i][1] += nxtC > record[i][1] ? 1 : -1;
                    }
                }
            }
        }
        return answer;
    }
}
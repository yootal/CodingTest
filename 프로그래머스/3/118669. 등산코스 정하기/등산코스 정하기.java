import java.util.*;

class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<int[]>[] graph = new ArrayList[n+1];
        for(int i = 0;  i <= n ; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] path : paths){
            graph[path[0]].add(new int[]{path[1], path[2]});
            graph[path[1]].add(new int[]{path[0], path[2]});
        }
        for(int gate: gates){
            graph[0].add(new int[]{gate, 0});
        }
        for(int summit : summits){
            set.add(summit);
        }
        int[] record = new int[n+1];
        Arrays.fill(record, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i->i[1]));       
        record[0] = 0;
        pq.offer(new int[]{0, 0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(record[cur[0]] != cur[1]) continue;
            if(set.contains(cur[0])) continue;
            for(int[] nxt : graph[cur[0]]){
                int nv = Math.max(nxt[1], cur[1]);
                if(record[nxt[0]] > nv){
                    record[nxt[0]] = nv;
                    pq.offer(new int[]{nxt[0], nv});
                }
            }
        }
        int[] answer = new int[2];
        Arrays.fill(answer,Integer.MAX_VALUE);
        Arrays.sort(summits);
        for(int summit : summits){
            if(record[summit] < answer[1]){
                answer[0] = summit;
                answer[1] = record[summit];
            }
        }
        return answer;
    }
}
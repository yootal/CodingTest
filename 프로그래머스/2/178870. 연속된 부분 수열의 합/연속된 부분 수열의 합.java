class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int e = 0;
        int size = Integer.MAX_VALUE;
        int value = 0;
        for(int s = 0 ; s < sequence.length ; s++){
            while(e < sequence.length && value + sequence[e] <= k){
                value += sequence[e];
                if(value == k && size > e - s){
                    size = e - s;
                    answer[0] = s;
                    answer[1] = e;
                }
                e++;
            }
            value -= sequence[s];
        }
        return answer;
    }
}
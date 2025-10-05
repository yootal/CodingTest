import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb =  new StringBuilder();
        String[] temp = {"RT","CF","JM","AN"};
        int[] score = new int[26];
        for(int i = 0 ; i < survey.length ; i++){
            String s = survey[i];
            int c = choices[i];
            if(c > 4){
                score[s.charAt(1) - 'A'] += (c - 4);
            }
            else if(c < 4){
                score[s.charAt(0) - 'A'] += Math.abs(c - 4);
            }
        }
        for(int i = 0 ; i < 4 ; i++){
            String s = temp[i];
            if(score[s.charAt(0) - 'A'] < score[s.charAt(1) - 'A']){
                sb.append(s.charAt(1));
            }
            else sb.append(s.charAt(0));
        }
        return sb.toString();
    }
}
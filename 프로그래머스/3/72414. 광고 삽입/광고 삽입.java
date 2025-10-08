import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String[] p = play_time.split(":"); 
        int psize = Integer.parseInt(p[0]) * 60 * 60 + Integer.parseInt(p[1]) * 60 + Integer.parseInt(p[2]);
        int[] time = new int[psize + 1];
        for(String log : logs){
            String[] temp = log.split("-");
            String[] s = temp[0].split(":");
            int si = Integer.parseInt(s[0]) * 60 * 60 + Integer.parseInt(s[1]) * 60 + Integer.parseInt(s[2]);
            String[] e = temp[1].split(":");
            int ei = Integer.parseInt(e[0]) * 60 * 60 + Integer.parseInt(e[1]) * 60 + Integer.parseInt(e[2]);
            time[si]++;
            if(ei <= psize) time[ei]--;
        }
        for(int i = 1 ; i <= psize ; i++){
            time[i] += time[i-1];
        }
        String[] a = adv_time.split(":"); 
        int size = Integer.parseInt(a[0]) * 60 * 60 + Integer.parseInt(a[1]) * 60 + Integer.parseInt(a[2]);
        long max = 0;
        long value = 0;
        int at = 0;
        for(int i = 0 ; i <= psize ; i++){
            if(i >= size){
                if(max < value){
                    max = value;
                    at = i-size;
                }  
                value -= time[i - size];
            }
            value += time[i];
        }
        StringBuilder sb = new StringBuilder();
        if(at / 3600 < 10) sb.append("0");
        sb.append(at / 3600).append(":");
        at %= 3600;
        if(at / 60 < 10) sb.append("0");
        sb.append(at / 60).append(":");
        at %= 60;
        if(at < 10) sb.append("0");
        sb.append(at);
        return sb.toString();
    }
}
import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int[] arr1 = new int[queue1.length + queue2.length];
        int idx = 0;
        long size1 = 0;
        long size2 = 0;
        for(int v : queue1){
            arr1[idx++] = v;
            size1 += v;
        }   
        for(int v : queue2){
            arr1[idx++] = v;
            size2 += v;
        }   
        int e = queue1.length;
        int t1 = 0;
        int at1 = Integer.MAX_VALUE;
        for(int s = 0 ; s < arr1.length ; s++){
            while(size1 < size2 && e < arr1.length){
                size1 += arr1[e];
                size2 -= arr1[e];
                e++;
                t1++;
            }
            if(size1 == size2){
                at1 = t1;
                break;  
            } 
            size1 -= arr1[s];
            size2 += arr1[s];
            t1++;
        }
        int[] arr2 = new int[queue1.length + queue2.length];
        idx = 0;
        size1 = 0;
        size2 = 0;
        for(int v : queue2){
            arr2[idx++] = v;
            size1 += v;
        }   
        for(int v : queue1){
            arr2[idx++] = v;
            size2 += v;
        }   
        e = queue2.length;
        int t2 = 0;
        int at2 = Integer.MAX_VALUE;
        for(int s = 0 ; s < arr2.length ; s++){
            while(size1 < size2 && e < arr2.length){
                size1 += arr2[e];
                size2 -= arr2[e];
                e++;
                t2++;
            }
            if(size1 == size2) {
                at2 = t2;
                break;
            }
            size1 -= arr2[s];
            size2 += arr2[s];
            t2++;
        }
        int answer = Math.min(at1,at2);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
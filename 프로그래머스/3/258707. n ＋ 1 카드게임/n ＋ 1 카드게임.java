import java.util.*;

class Solution {
    static int[] cards;
    static int n;
    
    public int solution(int coin, int[] cards) {
        this.cards = cards;
        n = cards.length;
        boolean[] check = new boolean[n + 1];
        HashSet<Integer> set = new HashSet<>();
        int chance = 0;
        for(int i = 0 ; i < n/3 ; i++){
            if(set.contains(n+1-cards[i])){
                set.remove(n+1-cards[i]);
                chance++;
            }
            else{
                set.add(cards[i]);
            }
        }
        int coin1 = 0;
        int coin2 = 0;
        int answer = 1;
        for(int i = n/3 ; i < n ; i+=2 ){
            int sum = 0;
            for(int j = i ; j < i+2 ; j++){
                sum += cards[j];
            }            
            if(sum == n+1){
                coin2++;
            }
            else{
                for(int j = i ; j < i+2 ; j++){
                    if(set.contains(n+1-cards[j])){
                       set.remove(n+1-cards[j]);
                        if(check[n+1-cards[j]]){
                            coin2++;   
                        }
                        else{
                            coin1++;
                        }
                    }
                    else{
                        set.add(cards[j]);
                        check[cards[j]] = true;
                    }
                }
            }
            if(chance > 0){
                chance--;
                answer++;
            }
            else if(coin > 0){
                if(coin1 > 0 && coin >= 1){
                    coin1--;
                    coin--;
                    answer++;
                }
                else if(coin2 > 0 && coin >= 2){
                    coin2--;
                    coin-=2;
                    answer++;
                }
                else break;
            }
        }
        return answer;
    }
}
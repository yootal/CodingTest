class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        for(int i = 1 ; i <= s.length(); i++){
            StringBuilder sb = new StringBuilder();
            String flag = s.substring(0,i);
            int cnt = 0;
            for(int j = 0 ; j < s.length() ; j+=i){
                if(j+i <= s.length()){
                    String ts = s.substring(j,j+i);
                    if(flag.equals(ts)){
                        cnt++;
                    }
                    else{
                        if(cnt > 1) sb.append(cnt);
                        cnt = 1;
                        sb.append(flag);
                        flag = ts;
                    }
                }
                    
            }
            if(cnt > 1){
                sb.append(cnt);
            }
            sb.append(flag);
            if(s.length() % i > 0){
                for(int j = s.length() / i * i ; j < s.length() ; j++){
                    sb.append(s.charAt(j));
                }
            }
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}
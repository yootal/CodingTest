import java.util.*;

class Solution {
    public String solution(String p) {
        return solve(new StringBuilder(p)).toString();
    }
    
    static StringBuilder solve(StringBuilder sb){
        if(sb.length() == 0 || check(sb)) return sb;
        int c1 = 0,  c2 = 0;
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        for(int i = 0 ; i < sb.length() ; i++){
            if(sb.charAt(i) == '(') c1++;
            else c2++;
            if(c1 == c2) {
                String temp = sb.toString();
                u.append(temp.substring(0,i+1));
                if(i + 1 < sb.length())
                    v.append(temp.substring(i+1));
                break;
            }
        }
        StringBuilder nu = new StringBuilder();
        if(check(u)){
            nu.append(u);
            nu.append(solve(v));
        }
        else{
            nu.append('(');
            nu.append(solve(v));
            nu.append(")");
            u.deleteCharAt(u.length()-1);
            u.deleteCharAt(0);
            for(int i = 0 ; i < u.length() ; i++){
                if(u.charAt(i) == '(') nu.append(')');
                else nu.append('(');
            }
        }
        return nu;
    }
    
    static boolean check(StringBuilder sb){
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(int i = 0 ; i < sb.length() ; i++){
            char c = sb.charAt(i);
            if(c == '(') stack.push(c);
            else if(c == ')'){
                if(!stack.isEmpty())
                    stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }
}
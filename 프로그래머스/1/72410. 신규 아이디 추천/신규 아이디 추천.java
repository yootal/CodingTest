class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder(new_id);
        
        for(int i = 0 ; i < sb.length() ; i++){
            sb.setCharAt(i, Character.toLowerCase(sb.charAt(i)));
        }
        
        for(int i = sb.length() - 1 ; i >= 0 ; i--){
            char c = sb.charAt(i);
            if( !( c == '-' || c == '_' || c == '.' || ( c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) ){
                sb.deleteCharAt(i);
            }
        }
        
        sb = new StringBuilder(sb.toString().replaceAll("[.]{2,}","."));
        if(sb.length() > 0 && sb.charAt(0) == '.') sb.deleteCharAt(0);
        if(sb.length() > 0 && sb.charAt(sb.length()-1) == '.') sb.deleteCharAt(sb.length()-1);
        if(sb.length() == 0) sb.append('a');
        if(sb.length() >= 16) sb.delete(15, sb.length());
        if(sb.charAt(sb.length()-1) == '.') sb.deleteCharAt(sb.length()-1);
        while(sb.length() <= 2){
            sb.append(sb.charAt(sb.length()-1));
        }
        
        return sb.toString();
    }
}
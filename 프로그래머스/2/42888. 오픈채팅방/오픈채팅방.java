import java.util.*;

class Solution {
    static class Info{
        String id;
        boolean flag;
        public Info(String id, boolean flag){
            this.id = id;
            this.flag = flag;
        }
    }
    public String[] solution(String[] record) {
        HashMap<String,String> map = new HashMap<>();
        ArrayList<Info> infos = new ArrayList<>();
        for(String row : record){
            String[] s = row.split(" ");
            if(s[0].equals("Enter")){
                infos.add(new Info(s[1],true));
                map.put(s[1],s[2]);
            }
            else if(s[0].equals("Leave")){
                infos.add(new Info(s[1],false));
            }
            else {
                map.put(s[1],s[2]);
            }
        }
        String[] answer = new String[infos.size()];
        StringBuilder sb;
        for(int i = 0 ; i < infos.size() ; i++){
            Info info = infos.get(i);
            if(info.flag){
                sb = new StringBuilder();
                sb.append(map.get(info.id)).append("님이 들어왔습니다.");
                answer[i] = sb.toString();
            }
            else{
                sb = new StringBuilder();
                sb.append(map.get(info.id)).append("님이 나갔습니다.");
                answer[i] = sb.toString();
            }
        }
        return answer;
    }
}
import java.util.*;

class Solution {
    static String[] result;
    static Set<String> resultSet = new HashSet<>();
    static boolean [] visited;
    static boolean [] bannedVisited;
    static String[] user_id;
    static String[] banned_id;
    static Stack<Integer> stack = new Stack<>();
    
    public int solution(String[] user_id_input, String[] banned_id_input) {
        user_id = user_id_input.clone();
        banned_id = banned_id_input.clone();
        result = new String[banned_id.length];
        visited = new boolean[user_id.length];
        bannedVisited = new boolean[banned_id.length];
        
        permu(0);
        
        return resultSet.size();
    }
    public void permu(int index){
        if(index==result.length){
            String []resultBuffer = result.clone();
            Arrays.sort(resultBuffer);
            resultSet.add(Arrays.toString(resultBuffer));
        }
        for(int i=0; i<visited.length; i++){
            if(!visited[i]){
                String id = user_id[i];
                if(check(id)){
                    visited[i]=true;
                    result[index]=id;
                    permu(index+1);
                    visited[i]=false;
                    bannedVisited[stack.pop()]=false;
                }
                
            }
        }
    }// combi end
    public boolean check(String id){
        for(int j=0; j<banned_id.length; j++){
            if(!bannedVisited[j]){
                String ban = banned_id[j];
                if(compare(id, ban)){
                    bannedVisited[j]=true;
                    stack.push(j);
                    return true;
                }
                    
            }
        }
        return false;
    }// check end
    public boolean compare(String id, String ban){
        if(id.length()!=ban.length()){
            
            return false;
        }
        for(int i=0; i<id.length(); i++){
            if(ban.charAt(i)=='*')
                continue;
            if(id.charAt(i)!=ban.charAt(i))
                return false;
        }
        return true;
    }//compare end
}
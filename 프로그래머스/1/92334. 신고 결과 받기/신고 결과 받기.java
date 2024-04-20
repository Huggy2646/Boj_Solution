import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer=new int[id_list.length];
        boolean [][] visited  = new boolean[id_list.length][id_list.length]; 
        int [] buffer = new int[id_list.length];
        Map<String,Integer> map = new HashMap<>();
        for(int i =0; i<id_list.length; i++){
            map.put(id_list[i],i);
        }
        // map.put("a",1);
        // int a = map.get("a");
        for(int i=0; i<report.length; i++){
            String[] ids = report[i].split(" ");
            String first = ids[0];
            String second = ids[1];
            
            if(!visited[map.get(first)][map.get(second)]){
               visited[map.get(first)][map.get(second)]=true;
                buffer[map.get(second)]+=1;
            }
            
        }
        List<Integer>list = new ArrayList<>();
        for(int i=0; i<buffer.length; i++){
            if(buffer[i]>=k){
                list.add(i);
            }
        }
        
        for(int i=0; i<visited.length; i++){
            for(int j=0; j<visited.length; j++){
                if(visited[i][j]){
                    for(int l=0; l<list.size(); l++){
                        if(list.get(l)==j)
                            answer[i]++;
                    }
                }
                    
            }
        }
        
        
        return answer;
    }
}
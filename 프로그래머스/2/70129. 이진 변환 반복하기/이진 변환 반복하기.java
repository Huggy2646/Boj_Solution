import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = {0,0};
        while(!s.equals("1")){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<s.length(); i++){
                char buffer = s.charAt(i);
                if(buffer=='1')
                    sb.append(buffer);
                else{
                    answer[1]++;
                }
            }
            s = Integer.toBinaryString(sb.toString().length());
            answer[0]++;
        }

        return answer;
    }
}
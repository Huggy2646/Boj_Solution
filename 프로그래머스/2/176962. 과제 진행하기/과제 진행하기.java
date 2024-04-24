import java.util.*;
import java.io.*;

class Solution {
    static class Hw implements Comparable<Hw>{
        String part;
        int time;
        int playtime;
        public Hw(String part,String time, String playtime){
            
            this.part=part;
            String[] HM = time.split(":");
            this.time = Integer.parseInt(HM[0])*60+Integer.parseInt(HM[1]);
            this.playtime = Integer.parseInt(playtime);
            
        }
        @Override
        public int compareTo(Hw o){
            return Integer.compare(this.time,o.time);
        }
        
        @Override
        public String toString(){
            return "part: "+part+" / time: "+time+" / playtime: "+playtime;
        }
    }
    public String[] solution(String[][] plans) {
        String [] answer = new String[plans.length];
        int index=0;

        Stack<Hw> stack = new Stack();
        PriorityQueue<Hw> pq = new PriorityQueue<>();
        //입력을 Hw클래스로 바꾸고 priorityqeue에 넣기
        for(int i=0; i<plans.length; i++){
            pq.offer(new Hw(plans[i][0],plans[i][1],plans[i][2]));
        }
        
        //스케줄링
        stack.push(pq.poll());
        int curr = stack.peek().time;
        while(!pq.isEmpty()){
           if(stack.isEmpty()){
                stack.push(pq.poll());
                curr=stack.peek().time;
               continue;
            }
            Hw buff_1=stack.pop();
            Hw buff_2=pq.poll();
            // System.out.println(buff_1);
            // System.out.println(buff_2);
            // System.out.println(curr);
            // System.out.println();

            if(curr==buff_2.time){
                stack.push(buff_1);
                stack.push(buff_2);
                continue;
            }
            if(curr+buff_1.playtime <= buff_2.time){
                answer[index]=buff_1.part;
                pq.offer(buff_2);
                index++;
                curr=curr+buff_1.playtime;
            }
            else{
                buff_1.playtime-=(buff_2.time-curr);
                stack.push(buff_1);
                stack.push(buff_2);
                curr = buff_2.time;
            }
        }
        while(!stack.isEmpty()){
            answer[index++]=stack.pop().part;
        }
        
        return answer;
    }
}
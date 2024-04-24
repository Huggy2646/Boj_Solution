import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer=new int [2];
        int sSize = sequence.length;
        int start=0;
        int end=0;
        long sum=0L;
        int min=Integer.MAX_VALUE;
        while(true){
            if(sum<k){
                if(end==sSize){
                    break;
                }
                sum+=sequence[end];
                end++;
            }
            else if (sum>=k){
                if(sum==k && (end-start)<min){
                    answer[0]=start;
                    answer[1]=end-1;
                    min = end-start;
                }
                sum-=sequence[start];
                start++;  
            }
 
        }
         // System.out.println(Arrays.toString(sums));
        return answer;
    }
}
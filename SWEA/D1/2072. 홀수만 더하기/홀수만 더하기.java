import java.util.*;
import java.io.*;

public class Solution {
   public static void main(String[] args) throws IOException{
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     StringTokenizer st = null;
     StringBuilder sb = new StringBuilder();
     int T = Integer.parseInt(br.readLine());
     for(int t=0; t<T; t++){
       int result=0;
       st = new StringTokenizer(br.readLine()," ");
       for(int n=0; n<10; n++){
          int num = Integer.parseInt(st.nextToken());
          if(num%2!=0)
	result+=num;
       }
       sb.append("#").append(t+1).append(" ").append(result).append("\n");	
     }
     System.out.println(sb.toString());
   }

}
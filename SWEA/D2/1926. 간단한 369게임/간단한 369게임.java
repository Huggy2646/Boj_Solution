import java.util.*;
import java.io.*;
public class Solution
{
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int n=1; n<N+1; n++){
		    String num = Integer.toString(n);
		    Queue<Character> q = new ArrayDeque<>();
		    boolean flag = false;
		    for(int i=0; i<num.length(); i++){
		        int charac = num.charAt(i);
		        // 3의 배수
		        if((int)charac%3==0 && charac!='0'){
		            flag=true;
		            q.offer('-');
		        }
		        else{
		            q.offer((char)charac);
		        }
		    }
		    while(!q.isEmpty()){
		        char buffer=q.poll();
		        if(flag){
		            if(buffer=='-')
		                sb.append(buffer);
		        }
		        else
		            sb.append(buffer);
		    }
            sb.append(" ");
		}
		System.out.println(sb.toString());
	}
}
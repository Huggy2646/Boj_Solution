import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = 0;
	    PriorityQueue<Integer> posiPq = new PriorityQueue<>((a1,a2)->{
	        return Integer.compare(a2,a1);
	    });
	    PriorityQueue<Integer> negaPq = new PriorityQueue<>((a1,a2)->{
	        return Integer.compare(a1,a2);
	    });
	    for(int n=0; n<N; n++){
	        int num = Integer.parseInt(br.readLine());
	        if(num==1)
	            result+=1;
	        else if(num<=0)
	            negaPq.offer(num);
	        else
	            posiPq.offer(num);
	    }
	    while(!posiPq.isEmpty()){
	        if(posiPq.size()==1){
	            result+=posiPq.poll();
	            break;
	        }
	            
	        int first = posiPq.poll();
	        int second = posiPq.poll();
	        result+= first*second;
	    }
	    while(!negaPq.isEmpty()){
	        if(negaPq.size()==1){
	            result+=negaPq.poll();
	            break;
	        }
	       int first = negaPq.poll();
	       int second = negaPq.poll();
	       result+=first*second;
	    }
	    
	    System.out.println(result);
	    
	   
	}
}
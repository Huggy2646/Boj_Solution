import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a1,a2)->{
		    return Integer.compare(a1[0],a2[0]);
		});
		PriorityQueue<Integer> pq2 = new PriorityQueue<>((a1,a2)->{
		    return Integer.compare(a1,a2);
		});
		
		for(int i=0; i<N; i++){
		    st = new StringTokenizer(br.readLine());
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        pq.offer(new int[]{a,b});
		}
		
		while(!pq.isEmpty()){
		    int [] inp = pq.poll();
		    int s = inp[0];
		    int e = inp[1];
		    if(pq2.isEmpty())
		        pq2.offer(e);
		    else{
		        if(pq2.peek()<=s){
		            pq2.poll();
		        }
		        pq2.offer(e);
		    }

		}
		System.out.println(pq2.size());
	}
}
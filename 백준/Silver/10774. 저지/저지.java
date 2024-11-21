import java.util.*;
import java.io.*;

public class Main
{
    static class Node{
        char size;
        int num;
        
        public Node(char size, int num){
            this.size = size;
            this.num = num;
        }
    }
	public static void main(String[] args)throws IOException {
	    
	    Map<Character,Integer> sizeMap = new HashMap<>();
	    sizeMap.put('S',0);
	    sizeMap.put('M',1);
	    sizeMap.put('L',2);
		PriorityQueue<Node> member = new PriorityQueue<>((a1,a2)->{
		    return Integer.compare(a1.num,a2.num);
		});
		PriorityQueue<Node> jeozi = new PriorityQueue<>((a1,a2)->{
		    return Integer.compare(a1.num,a2.num);
		});
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int J = Integer.parseInt(br.readLine());
		int A = Integer.parseInt(br.readLine());
		
		for(int i=1; i<J+1; i++)
		    jeozi.offer(new Node(br.readLine().charAt(0),i));
		
		for(int i=0; i<A; i++){
		    st = new StringTokenizer(br.readLine());
		    member.offer(new Node(st.nextToken().charAt(0),Integer.parseInt(st.nextToken())));
		}
	    int cnt=0;
	    while(!member.isEmpty()){
	        if(jeozi.isEmpty())
	            break;
	        Node m = member.peek();
	        Node j = jeozi.peek();
	        if(j.num<m.num){
	            jeozi.poll();
	            continue;
	        }
	        else if(j.num==m.num){
	           if(sizeMap.get(m.size)<=sizeMap.get(j.size)){
	               cnt++;
	               jeozi.poll();
	           }
	           member.poll();
	        }
	        else{
	            member.poll();
	        }
	            
	    }
		
		System.out.println(cnt);
		    
	}
}
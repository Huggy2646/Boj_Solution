import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Queue<Integer> q = new LinkedList<Integer>();
		for(int t=0; t<10; t++) {
			int count = 1;
			
			sb.append("#").append(br.readLine()).append(" ");
			String [] ss =br.readLine().split(" ");
			int [] is=new int[8];
			for(int i=0; i<8;i++) {
				is[i]=Integer.parseInt(ss[i]);
			}
			for(int i=0; i<8; i++)
				q.offer(is[i]);
			
			while(true) {
				if(count==6) {
					count=1;
				}
				int buffer = q.poll()-count;
				if(buffer<=0) {
					q.offer(0);
					break;
				}
				else {
					q.offer(buffer);
				}
				count++;
			}
			for(int i=0; i<8; i++) {
				sb.append(q.poll()).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}

}
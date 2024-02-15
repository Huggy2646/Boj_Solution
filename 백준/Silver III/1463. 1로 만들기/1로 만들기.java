import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static List<int[]> ls = new ArrayList<int[]>();//queue\
	static int []  visited;
	
	public static int oper(int []node) {
		int num = node[0];
		int depth = node[1];
		if(num==1) {
			return depth;
		}
		if(num%3==0 && visited[num/3]==0) {
			if(num/3==1) {
				return depth+1;
			}
			int []buffer_node = new int[2];
			buffer_node[0]=num/3;
			buffer_node[1]=depth+1;
			ls.add(buffer_node);
			visited[num/3]=1;
		}
		if(num%2==0 && visited[num/2]==0) {
			if(num/2==1) {
				return depth+1;
			}
			int []buffer_node = new int[2];
			buffer_node[0]=num/2;
			buffer_node[1]=depth+1;
			ls.add(buffer_node);
			visited[num/2]=1;
		}
		if(0<=num-1 && visited[num-1]==0) {
			if(num-1==1) {
				return depth+1;
			}
			int []buffer_node = new int[2];
			buffer_node[0]=num-1;
			buffer_node[1]=depth+1;
			ls.add(buffer_node);
			visited[num-1]=1;
		}
			
		return -1;
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int num = Integer.parseInt(br.readLine());
		visited = new int[num];
		int []node = new int[2];
		
		node[0]=num;
		node[1]=0;
		
		ls.add(node);
		
		while(true) {
			node = ls.get(0);
			ls.remove(0);
			int result = oper(node);
			if(result!=-1) {
				System.out.println(result);
				break;
			}
			if(ls.size()==0) {
				System.out.println("empty");
				break;
			}
			
		}
	
	}
}
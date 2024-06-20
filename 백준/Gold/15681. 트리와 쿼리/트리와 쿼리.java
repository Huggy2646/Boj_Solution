import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static class Node{
		List<Integer> connect = new ArrayList<>();
	}
	static boolean []visited;
	private static Node[] nodes;
	private static int root;
	private static int[] size;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		root = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		nodes = new Node[N+1];
		visited = new boolean[N+1]; 
		for(int i=1; i<N+1; i++) {
			nodes[i]=new Node();
		}
		
		for(int n=0; n<N-1; n++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a==root)
				nodes[a].connect.add(b);
			if(b==root)
				nodes[b].connect.add(a);
			else {
				nodes[a].connect.add(b);
				nodes[b].connect.add(a);
			}

		}
		size = new int[N+1];
		Arrays.fill(size, 1);
		makeTree(root);
		for(int q=0; q<Q; q++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(size[num]).append("\n");
		}
		System.out.println(sb.toString());
	}
	private static int makeTree(int root) {
		visited[root]=true;
		List<Integer> list = nodes[root].connect;
		for(int num:list) {
			if(!visited[num]) {
				visited[num]=true;
				size[root]+=makeTree(num);
			}
		}
		return size[root];
		
	}
	
}
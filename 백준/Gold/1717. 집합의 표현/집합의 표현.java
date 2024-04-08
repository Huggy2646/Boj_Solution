import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	private static int[] parents;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String [] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		parents = new int[N+1];
		

		for(int i=0; i<N+1; i++) {
			parents[i]=i;
		}
		
		
		for(int m=0; m<M; m++) {
			String [] cmds = br.readLine().split(" ");
			String cmd = cmds[0];
			int a = Integer.parseInt(cmds[1]);
			int b = Integer.parseInt(cmds[2]);
			
			if(cmd.equals("0"))
				union(a,b);
			else if(cmd.equals("1")) {
				int a_root = find(a);
				int b_root = find(b);
				if(a_root==b_root)
					sb.append("YES").append("\n");
				else
					sb.append("NO").append("\n");
			}	
			
		}
		System.out.println(sb);
	}

	//find root
	private static int find(int num) {
		if(parents[num]==num)
			return num;
		return parents[num]=find(parents[num]);
		
	}

	private static void union(int a, int b) {
		int a_root = find(a);
		int b_root = find(b);
		if(a_root!=b_root)
			parents[a_root]=b_root;
	}

}
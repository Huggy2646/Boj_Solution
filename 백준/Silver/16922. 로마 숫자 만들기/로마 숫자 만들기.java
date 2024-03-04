import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static int N;
	static int result;
	static int [] roma= {1,5,10,50};
	static Set<Integer> set =new HashSet<>();
	public static void dfs(int level,int start,int buffer) {
		if(level==N) {
			set.add(buffer);
			return;
		}
		for(int i=start; i<4; i++) {
			dfs(level+1,i,buffer+roma[i]);
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		
		dfs(0,0,0);
		System.out.println(set.size());
	}

}
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int min_cost = Integer.MAX_VALUE;
	static int N;
	static int [][] ground;
	static boolean[] visited;
	static int [] result;
	public static void dfs(int level) {

		if(level==N) {
			int cost_b=0;
//			System.out.println(Arrays.toString(result));
			for(int i=0; i<N-1; i++) {
					if(ground[result[i]][result[i+1]]==0)
						return;
					else
						cost_b+=ground[result[i]][result[i+1]];
					

			}
			if(ground[result[N-1]][result[0]]==0)
				return;
			else
				min_cost=Math.min(cost_b+ground[result[N-1]][result[0]],min_cost);
			return;
		}
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i]=true;
				result[level]=i;
				dfs(level+1);
				visited[i]=false;
			} 
			
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("res/sample_input.inp"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N=Integer.parseInt(br.readLine());
		ground=new int[N][N];
		visited=new boolean[N];
		result=new int[N];
		for(int n=0; n<N; n++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int col=0; col<N; col++) {
				ground[n][col]=Integer.parseInt(st.nextToken());
			}
		}
		
//		visited[0]=true;
		dfs(0);

		System.out.println(min_cost);
	}

}
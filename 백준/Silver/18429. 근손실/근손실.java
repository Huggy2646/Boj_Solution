import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int [] powers;
	static int N;
	static int K;
	static int total_count=0;
	static boolean[] visited;
	public static void dfs(int level, int p) {
		if(p<0) {
			return;
		}
		if(level==N) {
			total_count++;
			return;
		}
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i]=true;
				dfs(level+1,p+powers[i]-K);
				visited[i]=false;
			}
		}
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		st= new StringTokenizer(br.readLine()," ");
		powers=new int[N];
		visited=new boolean[N];
		for(int i=0; i<N; i++) {
			powers[i]=Integer.parseInt(st.nextToken());
		}
		dfs(0,0);
		System.out.println(total_count);
		
	}

}
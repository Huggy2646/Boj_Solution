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
	// 굳이 3대 운동 중량 500계산을 하지 않았음 
	// p는 현재의 중량 증가된 결과
	public static void dfs(int level, int p) {
		//현재 중량 증가량이 -1가 된다면 운동을 해도 근손실이 더 크다는 뜻이라 가지치기
		if(p<0) {
			return;
		}
		// 가지치기 안되고 끝까지 갔다면 유지가 잘 된거라서 count
		if(level==N) {
			total_count++;
			return;
		}
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i]=true;
				//넘겨 줄 때 현재 중량 + 증가될 증량 - 근손실
				dfs(level+1,p+powers[i]-K);
				visited[i]=false;
			}
		}
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		//데이터 init
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		powers=new int[N];
		visited=new boolean[N];
		st= new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			powers[i]=Integer.parseInt(st.nextToken());
		}
		
		//dfs시작(순열)
		dfs(0,0);
		System.out.println(total_count);
		
	}

}
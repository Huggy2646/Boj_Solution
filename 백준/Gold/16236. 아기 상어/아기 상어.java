import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int [][] direc = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [][] grid = new int[N][N];
		Queue<int[]> queue = new ArrayDeque<>();
		
		
		int shark = 2;
		int shark_count=2;
		boolean [][] visited = new boolean[N][N];
		int cnt=0;
		
		for(int n=0; n<N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int c=0; c<N; c++) {
				grid[n][c]=Integer.parseInt(st.nextToken());
				if(grid[n][c]==9) {
					grid[n][c]=0;
					queue.offer(new int[] {n,c,2,0});
					visited[n][c]=true;
				}
					
			}
		}
		
		while(!queue.isEmpty()) {
			boolean flag = false;
			int size = queue.size();
			PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					
					if(o1[0]==o2[0]) {
						return Integer.compare(o1[1], o2[1]);
					}
					return Integer.compare(o1[0], o2[0]);
				}
				
			});
			for(int s=0; s<size; s++) {
				int [] position = queue.poll();
				int r = position[0];
				int c = position[1];
				int k = position[2];
				int move=position[3];
				for(int d=0; d<4; d++) {
					int nr = r+direc[d][0];
					int nc = c+direc[d][1];
					if(0<=nr && nr<N && 0<=nc && nc<N && !visited[nr][nc] && grid[nr][nc]<=shark) {
						visited[nr][nc]=true;
						if(grid[nr][nc]!=0 && grid[nr][nc]<shark) {
							flag=true;
							pq.offer(new int[] {nr,nc,k-1,move+1});
						}
						queue.offer(new int[] {nr,nc,k,move+1});
					}
				}
			}
			if(flag) {
				flag=false;
				int[] p = pq.poll();
				grid[p[0]][p[1]]=0;
				pq.clear();
				queue.clear();
				cnt=p[3];
				visited=new boolean[N][N];
				visited[p[0]][p[1]]=true;
				if(p[2]==0) {
					shark++;
					queue.offer(new int[]{p[0],p[1],shark,p[3]});
				}
				else
					queue.offer(p);
			}
			
		}
		System.out.println(cnt);
		
		
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int [][] monkey_d = {{-1,0},{1,0},{0,-1},{0,1}}; //루피...?
	static int [][] horse_d = {{-2,-1},{-2,1},{2,-1},{2,1},{-1,-2},{1,-2},{-1,2},{1,2}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		if(W==1 && H==1) {
			System.out.println(0);
			return;
		}
		int [][] grid = new int[H][W];
		boolean [][][] visited= new boolean[H][W][K+1];
		//grid init start
		for(int h=0; h<H; h++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int w=0; w<W; w++) {
				grid[h][w]=Integer.parseInt(st.nextToken());
			}
		}//grid init end
		
		//bfs
		Queue<int[]> q = new ArrayDeque<>();
		//Queue init
		// row,col, horse_count;
		q.offer(new int[]{0,0,K});
		visited[0][0][K]=true;
		int result=0;
		boolean flag=false;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0; s<size; s++) {
				int[] buff = q.poll();
				int r = buff[0];
				int c = buff[1];
				int count = buff[2];
				
				for(int d=0; d<monkey_d.length; d++) {
					int nr = r+monkey_d[d][0];
					int nc = c+monkey_d[d][1];
					if(0<=nr && nr<H && 0<=nc && nc<W && !visited[nr][nc][count] && grid[nr][nc]!=1) {
						if(nr==H-1 && nc==W-1) {
							System.out.println(result+1);
							return;
						}
						visited[nr][nc][count]=true;
						q.offer(new int[] {nr,nc,count});
					}
				}
				if(0<count) {
					count--;
					for(int d=0; d<horse_d.length; d++) {
						int nr = r+horse_d[d][0];
						int nc = c+horse_d[d][1];
						if(0<=nr && nr<H && 0<=nc && nc<W && !visited[nr][nc][count] && grid[nr][nc]!=1) {
							if(nr==H-1 && nc==W-1) {
								System.out.println(result+1);
								return;
							}
							visited[nr][nc][count]=true;
							q.offer(new int[] {nr,nc,count});
						}
					}
				}
			}
			result++;
		}//bfs end
		
		System.out.println(-1);
		
		
	}//main end
}
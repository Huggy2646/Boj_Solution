import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int[][] grid;
	private static int[][] gridVisited;
	private static List<int[]> virusPosition;
	private static int count=0;
	private static int M;
	private static int N;
	private static boolean[] combiVisited;
	private static int[][] combiResult;
	private static int empty;
	private static int[][] direc = {{-1,0},{1,0},{0,-1},{0,1}};
	private static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		grid = new int[N][N];
		virusPosition = new ArrayList<>();

		//grid init
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int c=0; c<N; c++) {
				grid[r][c]=Integer.parseInt(st.nextToken());
				if(grid[r][c]==2)
					virusPosition.add(new int[] {r,c});
				if(grid[r][c]==0)
					empty++;
			}
		}//grid init
		
		combiVisited = new boolean[virusPosition.size()];
		combiResult = new int[M][2];
		if(empty==0){
			System.out.println(0);
			return;
		}
		
		combi(0,0);
//		System.out.println(count);
		if(min==Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);

	}

	private static void combi(int index, int level) {
		if(level==M) {
			int ffResult=floodfill(combiResult);
			if(ffResult!=-1)
				min=Integer.min(min,ffResult);
			return;
		}
		for(int i=index; i<virusPosition.size(); i++) {
			if(!combiVisited[i]) {
				combiVisited[i]=true;
				combiResult[level]=virusPosition.get(i);
				combi(i,level+1);
				combiVisited[i]=false;
			}
			
		}
		
	}

	private static int floodfill(int[][] input) {
		boolean[][] gridVisited=new boolean[N][N];
		Queue<int []> q =new ArrayDeque<>();
		for(int[] i:input) {
			q.offer(i);
			gridVisited[i[0]][i[1]]=true;
		}
		int level=0;
		int count=0;
		while(!q.isEmpty()) {
			int size=q.size();
			for(int i=0; i<size; i++) {
				int[]position = q.poll();
				int r = position[0];
				int c = position[1];
				for(int d=0; d<4; d++) {
					int nr = r+direc[d][0];
					int nc = c+direc[d][1];
					if(0<=nr && nr<N && 0<=nc && nc<N && !gridVisited[nr][nc] && grid[nr][nc]!=1) {
						gridVisited[nr][nc]=true;
						if(grid[nr][nc]==0)
							count++;
						q.offer(new int[] {nr,nc});
					}
				}
				
			}//size for end
			level++;
			if(count>=empty)
				return level;
		}// while end

		return -1;
	}//floodfill end

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private static int[][] grid;
	private static int[]paper= {5,5,5,5,5};
	private static List<int[]>position;
	private static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		grid = new int[10][10];
		position=new ArrayList<>();
		//grid init
		for(int r=0; r<10; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int c=0; c<10; c++) {
				grid[r][c]=Integer.parseInt(st.nextToken());
				if(grid[r][c]==1) {
					position.add(new int[] {r,c});
				}
				
			}
		}
		
		
		//dfs
		dfs(0,0,0);
		if(min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}

	private static void dfs(int index,int cnt,int flag) {
		if(position.size()<=index) {
			if(flag==position.size()) {
				min=Integer.min(min,cnt);
			}
			return;
		}
		int row=position.get(index)[0];
		int col=position.get(index)[1];
		
		if(grid[row][col]==0)
			dfs(index+1,cnt,flag);
		for(int i=4; 0<=i; i--) {
//		for(int i=0; i<5; i++) {
			if(paper[i]==0) {
				continue;
			}
			if(change(row,col,i)) {
				paper[i]--;
				i=i+1;
				for(int r=row; r<row+i; r++) {
					for(int c=col; c<col+i; c++) {
						grid[r][c]=0;
					}
				}
				dfs(index+1,cnt+1,flag+(i*i));
				for(int r=row; r<row+i; r++) {
					for(int c=col; c<col+i; c++) {
						grid[r][c]=1;
					}
				}
				i=i-1;
				paper[i]++;
			}
			
		}
		
	}


	private static boolean change(int row, int col, int i) {
		int cnt=0;
		i=i+1;
		for(int r=row; r<row+i; r++) {
			if(10<=r)
				return false;
			for(int c=col; c<col+i; c++) {
				if(10<=c)
					return false;
				if(grid[r][c]==0) {
					return false;
				}
			}
		}
		return true;	
	}

}
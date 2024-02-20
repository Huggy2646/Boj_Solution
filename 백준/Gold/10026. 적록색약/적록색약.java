import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	//상하좌우
	static int [][] direc = {{-1,0},{1,0},{0,-1},{0,1}};
	static String [][] grid ;
	static boolean[][] visited;
	static int count=0;
	public static void dfs(int row, int col,String rgb,boolean blindness) {
		//		count++;
		if(!blindness) {
			for(int i=0; i<direc.length; i++) {
				int n_row=row+direc[i][0];
				int n_col=col+direc[i][1];
				if(0<=n_row && n_row<N && 0<=n_col&& n_col<N && !visited[n_row][n_col]) {
					
					if(grid[n_row][n_col].equals(rgb)) {
						visited[n_row][n_col]=true;
						dfs(n_row,n_col,grid[n_row][n_col],false);
						
					}
				}
			}
			return;
		}
		else {
			for(int i=0; i<direc.length; i++) {

				int n_row=row+direc[i][0];
				int n_col=col+direc[i][1];
				if(0<=n_row && n_row<N && 0<=n_col&& n_col<N && !visited[n_row][n_col]) {
					String buffer_color=(grid[n_row][n_col].equals("R"))||(grid[n_row][n_col].equals("G"))? "N":grid[n_row][n_col];
					rgb = (rgb.equals("G"))||(rgb.equals("R"))? "N":rgb;
					
					if(buffer_color.equals(rgb)) {
						visited[n_row][n_col]=true;
						dfs(n_row,n_col,grid[n_row][n_col],true);
					}
				}

			}
		}


		//		if(count==(N*N))
		return;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		grid = new String[N][];

		for(int n=0; n<N; n++) {
			grid[n]=br.readLine().split("");
		}

		visited = new boolean[N][N];
//		visited[0][0]=true;
		for(int n=0; n<N; n++) {
			for(int c=0; c<N; c++) {
				if(!visited[n][c]) {
					dfs(n,c,grid[n][c],false);
					count++;
				}		
			}
			
		}
		System.out.print(count+" ");

		visited=new boolean[N][N];
		count=0;
		for(int n=0; n<N; n++) {
			for(int c=0; c<N; c++) {
				if(!visited[n][c]) {
					dfs(n,c,grid[n][c],true);
					count++;
				}		
			}
			
		}
		System.out.print(count+" ");
	}


}
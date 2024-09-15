/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
import java.io.*;
public class Main
{
    static int [][] direc = {{-1,-1},{-1,0},{-1,1}};
    static int R;
    static int C;
	public static void main(String[] args)throws IOException {
	        
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 R = Integer.parseInt(st.nextToken());
		  C = Integer.parseInt(st.nextToken());
		 int [][] grid = new int[R][C];
		 for(int r=0; r<R; r++){
		     st = new StringTokenizer(br.readLine());
		     for(int c=0; c<C; c++){
		         grid[r][c] = Integer.parseInt(st.nextToken());
		     }
		 }//input
		 
		 int [][][] dp = new int[R][C][3];
		 
		 //dp init
		 for(int c=0; c<C; c++){
		     dp[0][c][0] = grid[0][c];
		     dp[0][c][1] = grid[0][c];
		     dp[0][c][2] = grid[0][c];
		 }
		 
		 for(int r=1; r<R; r++){
		     for(int c=0; c<C; c++){
		         for(int d=0; d<3; d++){
		             int nr = r+direc[d][0];
		             int nc = c+direc[d][1];
		             if(isBound(nr,nc)){
		                 if(d==0)
		                    dp[r][c][d] = Integer.min(dp[nr][nc][1],dp[nr][nc][2])+grid[r][c];
		                else if(d==1)
		                    dp[r][c][d] = Integer.min(dp[nr][nc][0],dp[nr][nc][2])+grid[r][c];
		                else
		                    dp[r][c][d] = Integer.min(dp[nr][nc][0],dp[nr][nc][1])+grid[r][c];
		             }
		             else
		                dp[r][c][d] = Integer.MAX_VALUE;
		         }
		     }
		 }
		 int min = Integer.MAX_VALUE;
		 for(int c=0; c<C; c++){
		     for(int d=0; d<3; d++)
		        min = Integer.min(min,dp[R-1][c][d]);
		 }
		 System.out.println(min);
		 
		 
	}
	public static boolean isBound(int r, int c){
        return 0<=r && r<R && 0<=c && c<C;
	}
}
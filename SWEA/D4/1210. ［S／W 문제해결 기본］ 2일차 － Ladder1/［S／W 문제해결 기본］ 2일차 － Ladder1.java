import java.util.*;
import java.io.*;

public class Solution {
  static int[][] direc = {{0,-1},{0,1},{-1,0}};
  static int[][] grid;
  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();
    StringTokenizer st = null;
    for(int t=0; t<10 ;t++){
      int []X = new int[2];
      Integer.parseInt(br.readLine());
      grid = new int[100][100];
      //grid init start
      for(int r=0;r<100; r++){
        st = new StringTokenizer(br.readLine()," ");
        for(int c=0; c<100; c++){
          grid[r][c]=Integer.parseInt(st.nextToken());
          if(grid[r][c]==2){
            X[0]=r;
            X[1]=c;
          }
        }
      }// grid init end

      //3방탐색
      while(true){
        int r=X[0];
        int c=X[1];
        if(r==0)
          break;
        for(int d=0; d<3; d++){
          int nr = r+direc[d][0];
          int nc = c+direc[d][1];
          if(0<= nc && nc<100 && 0<=nr && nr<100 && grid[nr][nc]==1){
            grid[r][c]=0;
            X[0]=nr;
            X[1]=nc;
            break;
          }
        }
      }
      sb.append("#").append(t+1).append(" ").append(X[1]).append("\n");
    
    }//Test case end
    System.out.println(sb.toString());

  }// main end

}
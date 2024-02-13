import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0 ;t<T; t++) {
			sb.append("#").append(t+1).append("\n");
			int n = Integer.parseInt(br.readLine());
			int [][] snail = new int[n][n];
			int count=0;
			int x=0;
			int y=0;
			while(true) {
				while(true) {
					if(y<n && snail[x][y]==0) {
						snail[x][y]=count+1;
						y++;
						count++;
					}
					else {
						y--;
						x++;
						break;
					}
				}
				if(count==n*n) {
					break;
				}
				//2
				while(true) {
					if(x<n && snail[x][y]==0) {
						snail[x][y]=count+1;
						x++;
						count++;

					}
					else {
						x--;
						y--;
						break;
					}
				}
				if(count==n*n) {
					break;
				}
				//3
				while(true) {
					if(0<=y && snail[x][y]==0) {
						snail[x][y]=count+1;
						y--;
						count++;

					}
					else {
						y++;
						x--;
						break;
					}
				}
				if(count==n*n) {
					break;
				}
				//4
				while(true) {
					if(0<=x && snail[x][y]==0) {
						snail[x][y]=count+1;
						x--;
						count++;

					}
					else {
						x++;
						y++;
						break;
					}
				}
		
				if(count==n*n) {
					break;
				}
				
			}
			for(int i=0 ;i<n; i++) {
				for(int j=0;j<n; j++) {
					sb.append(snail[i][j]).append(" ");
				}
				sb.append("\n");
			}
			
		}
		System.out.println(sb);
	}

}
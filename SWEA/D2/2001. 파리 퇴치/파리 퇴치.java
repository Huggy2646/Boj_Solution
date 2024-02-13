import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			sb.append("#").append(t+1).append(" ");
			String [] NnM=br.readLine().split(" ");
			//grid size
			int N = Integer.parseInt(NnM[0]);
			//snap size
			int M = Integer.parseInt(NnM[1]);
			int [][]grid = new int[N][];
			for(int i=0; i<N; i++) {
				grid[i]=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			
			int max = Integer.MIN_VALUE;
			
			for(int i=0; i<=N-M; i++) {
				for(int j=0; j<=N-M; j++) {
					int sum=0;
					for(int k=i; k<i+M; k++) {
						for(int l =j; l<j+M; l++) {
							sum+=grid[k][l];
						}
					}
					max = max<sum? sum:max;
				}
				
			}
			
			sb.append(max).append("\n");
		}
		
		System.out.println(sb);
		
		
	}

}
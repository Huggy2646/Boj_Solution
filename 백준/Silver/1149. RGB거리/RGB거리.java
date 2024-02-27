import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int [][]home_cost=new int [N][3];
		int [][]dp= new int[N][3];
		for(int n=0; n<N; n++) {
			home_cost[n]=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		dp[0][0]=home_cost[0][0];
		dp[0][1]=home_cost[0][1];
		dp[0][2]=home_cost[0][2];
		for(int i=1; i<N; i++) {
				dp[i][0]= Math.min(dp[i-1][1]+home_cost[i][0],dp[i-1][2]+home_cost[i][0]);
				dp[i][1]= Math.min(dp[i-1][0]+home_cost[i][1],dp[i-1][2]+home_cost[i][1]);
				dp[i][2]= Math.min(dp[i-1][0]+home_cost[i][2],dp[i-1][1]+home_cost[i][2]);
			
		}
		System.out.println(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2])));
	}

}
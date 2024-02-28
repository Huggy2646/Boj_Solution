import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		/* 
		 * [row][col][0] == 가로
		 * [row][col][1] == 대각
		 * [row][col][2] == 세로*/ 
		int dp[][][] = new int[N][N][3];
		int map[][] = new int[N][N];
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int c=0; c<N; c++) {
				map[n][c]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=2; i<N; i++) {
			if(map[0][i]==1)
				break;
			dp[0][i][0]=1;
		}
		dp[0][1][1]=1;
		for(int i=1; i<N; i++) {
			for(int j=2; j<N; j++) {
				//가로
				if(map[i][j]!=1) {
					dp[i][j][0]=dp[i][j-1][0]+dp[i][j-1][1];
				}
				//대각
				if(map[i][j]!=1 && map[i-1][j]!=1 && map[i][j-1]!=1)
					dp[i][j][1]=dp[i-1][j-1][0]+dp[i-1][j-1][1]+dp[i-1][j-1][2];
				//세로
				if(map[i][j]!=1)
					dp[i][j][2]=dp[i-1][j][1]+dp[i-1][j][2];
			}
		}
		

		System.out.println(dp[N-1][N-1][0]+dp[N-1][N-1][1]+dp[N-1][N-1][2]);
	}

}
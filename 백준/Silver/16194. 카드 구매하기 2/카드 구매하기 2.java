import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int []dp= new int[N+1];
		int []cards = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int n=1; n<N+1; n++) {
			cards[n]=Integer.parseInt(st.nextToken());
		}
		dp[1]=cards[1];
		//dp
		for(int i=2; i<N+1; i++) {
			int min = Integer.MAX_VALUE;
			//cards
			for(int j=1; j<N+1; j++) {
				if(i-j >0) {
					min = Integer.min(dp[i-j]+cards[j],min);
				}
				else if(j-i==0) {
					min = Integer.min(cards[j],min);
				}
				
			}
			dp[i]=min;
		}
		System.out.println(dp[N]);
		
	}

}
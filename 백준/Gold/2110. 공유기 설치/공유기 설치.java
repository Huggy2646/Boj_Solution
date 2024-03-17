import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int  C;
	static int N ;
	static int [] home; 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NC = br.readLine().split(" ");
		N= Integer.parseInt(NC[0]);
		C = Integer.parseInt(NC[1]);

		home = new int[N];
		for(int n=0; n<N; n++) {
			home[n]=Integer.parseInt(br.readLine());
		}

		Arrays.sort(home);

		int start=1;
		int end = home[N-1]-home[0];
		int result = 0;
		//binary search
		while(true) {
			if(end<start)
				break;
			int mid = (start+end)/2;
			if(C<=count(mid)) {
				result = mid;
				start=mid+1;
			}
			else {
				end = mid-1;
			}
		}
		System.out.println(result);
	}
	public static int count(int mid) {
		int count=1;
		int current=0;
		boolean flag=false;
		for(int i=1; i<N; i++) {
			int diff = home[i]-home[current];
			if(mid<=diff) {
				count++;
				current=i;
			}
		}
		
		return count;
	}

}
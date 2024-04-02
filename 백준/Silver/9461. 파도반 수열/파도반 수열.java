import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long [] nums= new long[101];
		StringBuilder sb = new StringBuilder();
		int top = 5;
		//init
		nums[1]=1L;
		nums[2]=1L;
		nums[3]=1L;
		nums[4]=2L;
		nums[5]=2L;
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine());
			if(1<=n && n<=top) {
				sb.append(nums[n]).append("\n");
			}
			else {
				for(int i=top+1; i<=n; i++) {
					nums[i]=nums[i-1]+nums[i-5];
				}
				top=n;
				sb.append(nums[n]).append("\n");
			}
			
		}
		System.out.println(sb);
	}

}
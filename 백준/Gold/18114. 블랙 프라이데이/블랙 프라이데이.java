import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;



public class Main {
	static int [] price;
	static int N;
	static int result =0;
	static boolean[] visited;
	static int C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		price=new int[N];
		
		
		
		st=new StringTokenizer(br.readLine()," ");
		
		for(int n=0; n<N; n++) {
			price[n]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(price);

		
		for(int i=0; i<N; i++) {
			int start = i+1;
			int end = N-1;
			while(true) {
				if(end<=start)
					break;
				int two = price[start]+price[end];
				int two_1= price[start]+price[i];
				int two_2= price[i]+price[end];
				int three= price[start]+price[i]+price[end];
				if(price[start]==C || price[end]==C || price[i]==C ||two==C|| two_1==C || two_2==C || three==C) {
					result=1;
					break;
				}
				
				if(three<C) {
					start++;
				}
				else
					end--;
					
			}
			
		}
		System.out.println(result);
	}

}
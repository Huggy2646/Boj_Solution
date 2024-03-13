import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		
		int N = Integer.parseInt(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		long [] Trees = new long[N];
		long end= Long.MIN_VALUE;
		st = new StringTokenizer(br.readLine()," ");
		for(int n=0; n<N; n++) {
			Trees[n]=Long.parseLong(st.nextToken());
			end = end<Trees[n]? Trees[n]:end;
		}
		
		long start=0;
		long result=0;
		long buffer=Long.MAX_VALUE;
		while(true) {
			if(end<start)
				break;
			long mid = (start+end)/2;
			long len=0;
			for(int i=0; i<N; i++) {
				if(mid<Trees[i])
					len+= Trees[i]-mid;
			}
			if(M==len){
				result = mid;
				break;
			}
			if(M<len) {
				if(Math.abs(len-M)<buffer) {
					buffer=Math.abs(len-M);
					result=mid;
				}
				start=mid+1;
			}
			else if(len<M)
				end=mid-1;
		}
		System.out.println(result);
		
	}

}
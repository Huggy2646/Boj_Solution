import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		long K = Long.parseLong(br.readLine());
		long start=1;
		long end = N*N;
		long min = Long.MAX_VALUE;
		long ans=0;
		while(true) {
			long count=0;
			if(end<start) {
				System.out.println(start);
				break;
			}

			long mid = (start+end)/2;
			for(int i=1; i<N+1; i++) {
				long divi = mid/i;
				if(divi<=N) {
					count+=divi;
				}
				else if(N<divi) {
					count+=N;
				}

			}
			if(K<=count)
				end=mid-1;
			else if(count<K) {
				start=mid+1;
			}

		}

	}



}
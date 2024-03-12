import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String [] KM = br.readLine().split(" ");
		int K = Integer.parseInt(KM[0]);
		int M = Integer.parseInt(KM[1]);
		long []lans=new long[K];
		long start=1;
		long end=Long.MIN_VALUE;
		long max  = Long.MIN_VALUE;
		//data init, 제일 큰 수를 찾아서 저장(자를때 가장 긴 랜선 이상으로는 짜르지 않기 때문)
		for(int k=0; k<K; k++) {
			lans[k]=Long.parseLong(br.readLine());
			end = end<lans[k]? lans[k]:end;
		}
		
		//binary search
		while(true) {
			//기저
			if(end<start)
				break;
			long mid = ((long)start+(long)end)/2;
			
			long count = 0;
			// 중간 값 길이만큼 랜선을 잘라보고 몇개가 나오는지 count
			for(int k=0; k<K; k++) {
				count += lans[k]/mid;
			}
			//만약 원하는 갯수가 나오면 or
			//원하는 갯수보다 많으면 더 크게 잘라 갯수를 줄이기 위해 범위를 오른쪽으로 포커스를 맞춤
			if(M<=count) {
				// 전에 찾은 길이보다 길면 저장
				max = mid;
				//최적이 아닐 수 도 있으니깐  start를 mid+1 바꿔서 찾는 범위 줄이기 + 오른쪽로 짤라본다(더 길게 짤라봄)
				start=mid+1;

			}
			//원하는 갯수보다 적으면 더 작게 잘라 갯수를 늘리기 위해 범위를 왼쪽을 포커스를 맞춤
			else if(count<M) {
				end=mid-1;
			}
			


		}
		System.out.println(max);
		
		
	}

}
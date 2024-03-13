import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		//input data init
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
		//binary search
		while(true) {
			//기저
			if(end<start)
				break;
			long mid = (start+end)/2;
			long len=0;
			//나무에서 mid높이 만큼 자르고 남은 나무 합
			for(int i=0; i<N; i++) {
				if(mid<Trees[i])
					len+= Trees[i]-mid;
			}
			//합이 같으면 가장 최적인 높이라서 break
			if(M==len){
				result = mid;
				break;
			}
			//원하는 길이보다 자라고 남은 나무의 합이 더 클때
			if(M<len) {
				//그 높이로 잘랐을 때 원하는 길이와의 차이가 가장 작을 때
				//result에 저장
				if(Math.abs(len-M)<buffer) {
					buffer=Math.abs(len-M);
					result=mid;
				}
				//최적이 아닐 수도 있어서 오른쪽으로 범위를 좁혀 더 높게 잘라봄
				start=mid+1;
			}
			//원하는 길이보다 자라고 남은 나무의 합이 더 작을 때
			else if(len<M)
				// 더 낮게 자르기
				end=mid-1;
		}
		System.out.println(result);
		
	}

}
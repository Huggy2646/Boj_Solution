import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int []store;
	static int N;
	static int M;	
	static int L;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		store = new int[N+2];
		st = new StringTokenizer(br.readLine()," ");
		store[0]=0;
		store[N+1]=L;
		for(int n=1; n<N+1;n++) {
			store[n]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(store);
		
		int start= 1;
		int end = L;
		int min = Integer.MAX_VALUE;
		while(true) {
			if (end<start) {
				break;
			}
			int mid = (start+end)/2;
			int c = check(mid);
			if(c<=M) {
				min= mid<min? mid:min;
				end=mid-1;
			}
//			else if(c<M) {
//				end = mid-1;
//				
//			}
			else if(M<c){
				start=mid+1;
			}
		}
		System.out.println(min);
		
	}
	public static int check(int mid) {
		PriorityQueue<Integer> dif_distance = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				
				return o2.compareTo(o1);
			}
			
		});
		for(int n=0; n<N+1; n++) {
			dif_distance.offer(store[n+1]-store[n]);
		}
		
		
		int count=0;
		while(true) {
			if(dif_distance.peek()<=mid)
				break;
			int distan = dif_distance.poll();
			dif_distance.offer(distan-mid);
			dif_distance.offer(mid);
			count++;

		}
		
		return count;
	}


}
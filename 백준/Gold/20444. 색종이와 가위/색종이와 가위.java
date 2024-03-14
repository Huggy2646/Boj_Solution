import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		long K = sc.nextLong();
//		System.out.println(N+K);
		
		long start=0;
		long end=N/2;
		
		while(true) {
			if(end<start) {
				System.out.println("NO");
				break;
			}
				
			long mid = (start+end)/2;
			
			long size = (mid+1)*(N-mid+1);
//			System.out.println(mid);
//			System.out.println(N-mid);
//			System.out.println();
			if(size==K) {
				System.out.println("YES");
				break;
			}
				
			else if(size<K) {
				start=mid+1;
			}
			else if(K<size) {
				end=mid-1;
			}
			
		}
	}

}
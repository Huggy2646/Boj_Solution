import java.util.Scanner;
/*
 * 자를 수 있는 횟수에서 최대로 조각이 나오는 경우를 계산하면
 * ((N/2)+1)*(N-(N/2)+1)
 * ex) N=6;
 * 	   이때 나올 수 있는 조각의 개수들은 
 * 	  4*4=16, => 세로 3번 가로 3번
 *    3*5=15, => 세로 2번 가로 4번
 *    2*6=12, => 세로 1번 가로 5번
 *    1*7=13  => 세로 0번 가로 6번
 * 그러므로 한변에 자를 수 있는 최대의 갯수는 N/2 이고,
 * 최소는 0이다.
 * 
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		long K = sc.nextLong();

		//한쪽의 변에서 한번도 안자를때 있기 때문에 0
		long start=0;
		//한쪽의 변에서 가장 많이 자를 경우;
		long end=N/2;
		
		//이분 탐색 start
		while(true) {
			if(end<start) {
				System.out.println("NO");
				break;
			}
				
			long mid = (start+end)/2;
			
			//나올 수 있는 조각 갯수 계산
			long size = (mid+1)*(N-mid+1);
			//같으면 break;
			if(size==K) {
				System.out.println("YES");
				break;
			}
			// 나온 조각 갯수가 찾고있는 숫자보다 작으면 오른쪽으로
			else if(size<K) {
				start=mid+1;
			}
			// 나온 조각 갯수가 찾고있는 숫자보다 크면면 왼쪽으로
			else if(K<size) {
				end=mid-1;
			}
			
		}
	}

}

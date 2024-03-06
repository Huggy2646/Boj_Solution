import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] result;
	static boolean be=false;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.nextLine());
		result = new int [N];
		permu(0);
	}
	public static void permu(int level){
		if(level==N){
			for(int a:result) {
				System.out.print(a);
			}
			
			be=true;
			return;
		}
		for(int i=1; i<4; i++){
			result[level]=i;
			if(level!=0){
				if(check(level))
					continue;

			}

			permu(level+1);


			if(be)
				return;
		}

	}
	public static boolean check(int end){
		
		for(int count=1; count<=end; count++) {// 비교할 크기 ++
			int buffer=end;
			int count_b=0;
			for(int i=0; i<count; i++) {// 비교할 크기만큼 비교를 해야됨
				
				if(buffer-count < 0) {
					break;
				}
				//System.out.println(buffer+"..."+(buffer-count));
				//비교하는 위치는 비교할 크기만큼 비례
				if(result[buffer]==result[buffer-count]) {
					//같은 count
					count_b++;
				}
				
				buffer--;//비교하는 대상이 하나씩 왼쪽으로 ㄱㄱ
			}
			//비교하는 크기와 비교했을때 같은 숫자의 count가 같으면 같은 순서를 가진 연속된부분 수열
			if(count_b==count)
				return true;

		}
		
		return false;
	}
}

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
				//비교하는 대상이 하나씩 줄어야 됨
				if(buffer-count < 0) {
					break;
				}
				//System.out.println(buffer+"..."+(buffer-count));
				if(result[buffer]==result[buffer-count]) {
					
					count_b++;
				}
				
				buffer--;
			}
			if(count_b==count)
				return true;

		}
		
		return false;
	}
}
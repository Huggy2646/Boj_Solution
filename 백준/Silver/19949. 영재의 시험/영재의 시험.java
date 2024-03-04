import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int [] corrects;
	static int [] result;
	static int total_count;
	
	// result_count == 중복순열이 만들어 지는 도중 계속 정답과 찍은 정답이 맞는지 count해서 넘겨주기 위해 인자로 설정 
	public static void dfs(int level,int result_count) {
		
		if(level==10) {
			//정답과 찍은 답과 일치하는 수가 5개 이상 이면 
			if(5<=result_count) {
				total_count++;
			}
			return;
		}
		for(int i=1; i<6 ;i++) {
			int count=0;
			// 찍는 답들이 3개 이상일 때
			if(2<=level)
				// 현재 찍은 답 전의 찍은 답과 전전의 찍은 답을 확인
				for(int j=1; j<3; j++) {
					// 같으면 count++
					if(result[level-j]==i)
						count++;
				}
			//연속으로 3개의 같은 숫자가 나오지 않았다면
			if(count!=2) {
				//중복순열에  저장
				result[level]=i;
				//찍은 답과 정답이 같다면 result_count+1해서 recursion
				if(corrects[level]==result[level])
					dfs(level+1,result_count+1);
				//찍은 답과 정답이 다르면 그냥 recursion
				else
					dfs(level+1,result_count);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 정답들 입력
		corrects=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		// 중복 순열 저장 할 배열 초기화
		result=new int[10];
		//dfs 시작
		dfs(0,0);
		System.out.println(total_count);
	}

}
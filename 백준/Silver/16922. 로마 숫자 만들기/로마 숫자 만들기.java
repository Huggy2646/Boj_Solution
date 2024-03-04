import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static int N;
	static int result;
    // 각각 l V X L
	static int [] roma= {1,5,10,50};
	// 결과로 나오는 값들을 set으로 저장하여 중복 값 제거
	static Set<Integer> set =new HashSet<>();
	public static void dfs(int level,int start,int buffer) {
		if(level==N) {
			set.add(buffer);
			return;
		}
		//중복조합
		for(int i=start; i<4; i++) {
			dfs(level+1,i,buffer+roma[i]);
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		//중복조합
		dfs(0,0,0);
		System.out.println(set.size());
	}

}
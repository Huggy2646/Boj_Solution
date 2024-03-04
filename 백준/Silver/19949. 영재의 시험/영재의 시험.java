import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int [] collects;
	static int [] result;
	static int total_count;
	public static void dfs(int level,int result_count) {

		if(level==10) {
			if(5<=result_count) {
				total_count++;
			}
			return;
		}
		for(int i=1; i<6 ;i++) {
			int count=0;
			if(2<=level)
				for(int j=1; j<3; j++) {
					if(result[level-j]==i)
						count++;
				}
			if(count!=2) {
				result[level]=i;
				if(collects[level]==result[level])
					dfs(level+1,result_count+1);
				else
					dfs(level+1,result_count);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		collects=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		result=new int[10];
		dfs(0,0);
		System.out.println(total_count);
	}

}
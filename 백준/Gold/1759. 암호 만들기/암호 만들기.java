import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	static String [] alpha;
	static List<String> aeiou;
	static List<String> not_aeiou;
	static String [] result;
	static List<String> result_list = new ArrayList<>();
	static boolean visited[];
	static int L;
	static int C;
	static StringBuilder sb = new StringBuilder();
	static void make_key(int level,int start) {
		
		if(level==L) {
			String [] copy_result=Arrays.copyOf(result, L);
			Arrays.sort(copy_result);
			String result_s="";
			for(String s:copy_result)
				result_s+=s;
			result_list.add(result_s);
			return;
		}
		
		for(int i=start; i<not_aeiou.size(); i++) {
			if(!visited[i]) {
				visited[i]=true;
				result[level]=not_aeiou.get(i);
				make_key(level+1,i+1);
				visited[i]=false;
			}
		}
			
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String [] LC = br.readLine().split(" ");
		
		L = Integer.parseInt(LC[0]);
		C = Integer.parseInt(LC[1]);
		
		alpha = br.readLine().split(" ");
		
		aeiou=new ArrayList<>();
		not_aeiou=new ArrayList<>();
		
		for(int i=0; i<alpha.length; i++) {
			if(alpha[i].equals("a") || alpha[i].equals("e") || alpha[i].equals("i") || alpha[i].equals("o") || alpha[i].equals("u")) {
				aeiou.add(alpha[i]);
			}
			else {
				not_aeiou.add(alpha[i]);
			}
		}
		for(int flag=1; flag<(1<<aeiou.size()); flag++) {
			List<String> buffer = new ArrayList<>();
			result = new String[L];
			visited = new boolean[not_aeiou.size()];
//			List<String>buffer_a = new ArrayList<>();
			int count=0;
			for(int i=0; i<aeiou.size(); i++) {
				if((flag &(1<<i))!=0) {
					buffer.add(aeiou.get(i));
					count++;
				}
				
//				System.out.print(((? :"x")+"\t");
			}
			if(L-count<2) {
				continue;
			}
			for(int i=0; i<buffer.size(); i++) {
				result[i]=buffer.get(i);
			}
			
			
			make_key(count,0);
			
		}
		Collections.sort(result_list);
		for(int i=0; i<result_list.size(); i++) {
			System.out.println(result_list.get(i));
		}
		
		
	}

}
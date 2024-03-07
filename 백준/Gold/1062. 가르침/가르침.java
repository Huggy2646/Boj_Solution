import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	//{'b','d','e','f','g','h','g','k','l','m','o','p','q','r','s','u','v','w','x','y','z'}
	//{'a','c','i','n','t'} 은 일단 배웠다고 가정하고 시작 배운 언어 따로 빼서 나중에 result init할때 넣을 예정
	static char[] already={'a','c','i','n','t'};
	//제시된 단어중 {'a','c','i','n','t'}을 제외한 알파벳
	static Object[] alpha;
	//combi 결과
	static char[] result;
	//배울 언어들 => 넣을때  anta, tica 사이에 있는 단어만 추가
	static char [][] words;
	static Set<Character> set;
	static int K;
	static boolean visited[];
	static int max=Integer.MIN_VALUE;
	
	public static void combi(int level,int start) {
		if(level==K|| alpha.length==0) {
			//비교
			int count=0;
			for(char []c:words) {
				int count_char=0;
				for(int i=0; i<c.length; i++) {
					for(int j=0; j<result.length; j++) {
						if(c[i]==result[j]) {
							count_char++;
							break;
						}
					}
				}
				if(c.length==count_char)
					count++;
			}
			max = Integer.max(count, max);
			return;
		}
		for(int i=start; i<alpha.length; i++) {
			if(!visited[i]) {
				visited[i]=true;
				result[level]=(char)alpha[i];
				combi(level+1,i);
				visited[i]=false;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		words= new char[N][];
		set  = new HashSet<>();
		for(int n=0; n<N; n++) {
			char [] buffer = br.readLine().toCharArray();	
			//anta와 tica사이의 알바벳만 솎아내서 단어장에 저장
			words[n]=Arrays.copyOfRange(buffer, 4, buffer.length-4);
			for(char a:words[n]) {
				//acint를 제외한 단어를 set에 저장 => set에 저장함으로써 입력으로 들어오는 배울 알파벳들 중복 없앰
				if(!(a=='a'|| a=='c' || a=='i' || a=='n' || a=='t'))
					set.add(a);
			}
		}
		// set to array
		alpha=set.toArray();

		//만약에 anta+tica의 중복 제거된 알파벳의 갯수 5개보다 배울 수 있는 알파벳의 수 K가 작으면 배울수 있는 단어가 없으므로 답은 0;
		if(K-5<0) {
			System.out.println(0);
		}
		// 배울 알파벳보다 acint를 제외하고 배울수 있는 알파벳의 수가 더 크면 다 배울수 있기 때문에 답은 입력된 단어의 수
		else if(alpha.length<K-5) {
			System.out.println(words.length);
		}
		// combination ㄱㄱ
		else {
			result=new char[K];
			//visited init
			visited=new boolean[alpha.length];
			//result init
			for(int i=0; i<already.length; i++) {
				result[i]=already[i];
			}
			//조합
			combi(already.length,0);
			System.out.println(max);
		}

		
	}
}
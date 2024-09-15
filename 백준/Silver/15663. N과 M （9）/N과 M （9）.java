import java.util.*;
import java.io.*;
public class Main
{
    static int a;
    static int b;
    static int [] input;
    static int [] result;
    static boolean [] visited;
    static Map<String,Boolean> map = new HashMap<>();
    static StringBuilder answer = new StringBuilder();
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		input = new int[a];
		result = new int[b];
		visited = new boolean[a];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<a; i++){
		    input[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		per(0);
		System.out.println(answer.toString());
	}

    public static void per(int level){
        if(level==b){
            StringBuilder buff = new StringBuilder();
            for(int i:result){
                buff.append(i).append(" ");
            }
            String s = buff.toString();
            if(map.get(s)==null){
                map.put(s,true);
                answer.append(s).append("\n");
            }
            return;
        }//if
        for(int i=0; i<a; i++){
            if(!visited[i]){
                visited[i]=true;
                result[level]=input[i];
                per(level+1);
                visited[i]=false;
            }
        }
    }//per
}
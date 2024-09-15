import java.util.*;
import java.io.*;

public class Main
{
    static int a;
    static int b;
    static int [] result;
    static StringBuilder answer = new StringBuilder();
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken())+1;
		b = Integer.parseInt(st.nextToken());
	    result = new int[b];
	    per(0);
	    System.out.println(answer.toString());
	}
	
	//중복 순열
	public static void per(int level){
	    if(level==b){
	        for(int i=0; i<b; i++){
	            answer.append(result[i]).append(" ");
	        }
	        answer.append("\n");
	        return;
	    }
	    for(int i=1; i<a; i++){
	        result[level]=i;
	        per(level+1);
	    }
	    
	}
}

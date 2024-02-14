import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {
	static char [][] bitmap;
	static int N;
	static int count=0;
	static StringBuilder sb = new StringBuilder();
	static boolean check(int size,int start_r, int start_c,int end_r,int end_c) {
		char first=bitmap[start_r][start_c];
		for(int i=start_r; i<end_r; i++) {
			for(int j=start_c; j<end_c; j++) {
				if(first!=bitmap[i][j])
					return false;
			}
		}
		return true;
		
	}
	static void divide_conq(int level,int size,int start_r, int start_c,int end_r,int end_c) {
		if(check(size,start_r,start_c, end_r, end_c)) {
			sb.append(bitmap[start_r][start_c]);
			return;
		}
		if(size==1) {
			sb.append(bitmap[start_r][start_c]);
			return;
		}
		//1사분면
		sb.append('(');
		divide_conq(level+1,size/2,start_r,start_c,start_r+size/2,start_c+size/2);
		//2사분면
		divide_conq(level+1,size/2,start_r,start_c+size/2,end_r-size/2, end_c);
		//3사분면
		divide_conq(level+1,size/2,start_r+size/2,start_c,end_r,end_c-size/2);
		//4사분면
		divide_conq(level+1,size/2,start_r+size/2,start_c+size/2,end_r,end_c);
		sb.append(')');
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("res/main_1992_input.inp"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(br.readLine());
		//init
		bitmap=new char[N][];
		for(int i=0; i<N; i++) {
			String line_s = br.readLine();
			char [] line_a=new char[N];
			for(int c=0; c<line_s.length(); c++) {
				line_a[c]=line_s.charAt(c);
			}

			bitmap[i]=line_a;
		}
		divide_conq(0,N,0,0,N,N);
		System.out.println(sb);
	}

}
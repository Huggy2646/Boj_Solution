import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N =Integer.parseInt(br.readLine());
		int [][] M = new int[N][];
		for(int i=0; i<N; i++) {
			M[i]=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		int min=Integer.MAX_VALUE;
		for(int flag=1; flag<(1<<N); flag++) {
			int s = 1;
			int b = 0;
			int min_buffer=0;
			for(int i=0; i<N; i++) {
				if((flag & (1<<i))!=0) {
					s*=M[i][0];
					b+=M[i][1];
				}
			}


			min_buffer= Math.abs(s-b);
			min=(min_buffer<min)? min_buffer:min;


		}
		System.out.println(min);
	}
}
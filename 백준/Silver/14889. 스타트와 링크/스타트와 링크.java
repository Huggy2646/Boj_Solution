import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;



public class Main {
	static int[][] powers;
	static int N;
	static boolean[] visited;
	static int[] buffer_team;
	static int min = Integer.MAX_VALUE;
	static StringBuilder sb;
	static int total_power=0;
	static void make_team(int level,int current_power,int start) {
		

		if(level==N/2) {
			sb = new StringBuilder();
			int []diff_team= new int[N/2];
			int diff_team_power=0;
			int team_power=0;
			int index_count=0;
			for(int i=0; i<N/2; i++) {
				for(int j=i+1; j<N/2; j++) {
					team_power+=powers[buffer_team[i]-1][buffer_team[j]-1];
					team_power+=powers[buffer_team[j]-1][buffer_team[i]-1];
				}
				
			}
			for(int i=0; i<N;i++) {
				if(index_count==N/2)
					break;
				if(Arrays.binarySearch(buffer_team,i+1)<0) {
					diff_team[index_count]=i;
					index_count++;
				}
			}
			for(int i=0; i<N/2; i++) {
				for(int j=i+1; j<N/2; j++) {
					diff_team_power+=powers[diff_team[i]][diff_team[j]];
					diff_team_power+=powers[diff_team[j]][diff_team[i]];
				}
				
			}

			int buffer_min = Math.abs(diff_team_power-team_power);
			
			min = buffer_min<min? buffer_min:min;

			return;
		}
			
		for(int i=start; i<N; i++) {
			if(!visited[i]) {
				visited[i]=true;
				buffer_team[level]=i+1;
				make_team(level+1,current_power,i);
			}
			visited[i]=false;
			
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N= Integer.parseInt(br.readLine());
		powers = new int[N][];
		buffer_team=new int[N/2];
		visited=new boolean[N];
		for(int i=0; i<N;i++) {
			powers[i]=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for(int j=0;j<N;j++) {
				total_power+=powers[i][j];

			}
		}
		make_team(0,0,0);

		System.out.println(min);

	}

}
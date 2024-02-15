import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/*
.	평지(전차가 들어갈 수 있다.)
*	벽돌로 만들어진 벽
#	강철로 만들어진 벽
-	물(전차는 들어갈 수 없다.)
^	위쪽을 바라보는 전차(아래는 평지이다.)
v	아래쪽을 바라보는 전차(아래는 평지이다.)
<	왼쪽을 바라보는 전차(아래는 평지이다.)
>	오른쪽을 바라보는 전차(아래는 평지이다.)

U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
*/


public class Solution {
	static int T;
	static int H;
	static int W;
	static char current_state;
	static int current_r;
	static int current_c;
	static char [][] map;
	public static void U() {
		current_state='U';
		if(0<=current_r-1) {
			if(map[current_r-1][current_c]=='.') {
				map[current_r-1][current_c]='^';
				map[current_r][current_c]='.';
				current_r--;
			}
			else {
				map[current_r][current_c]='^';
			}
			return;
			
		}
		map[current_r][current_c]='^';
			
	}
	public static void D() {
		current_state='D';
		if(current_r+1<H) {
			if(map[current_r+1][current_c]=='.') {
				map[current_r+1][current_c]='v';
				map[current_r][current_c]='.';
				current_r++;
			}
			else {
				map[current_r][current_c]='v';
			}
			return;
			
		}
		map[current_r][current_c]='v';
		
		
	}
	public static void L() {
		current_state='L';
		if(0<=current_c-1) {
			if(map[current_r][current_c-1]=='.') {
				map[current_r][current_c-1]='<';
				map[current_r][current_c]='.';
				current_c--;
			}
			else {
				map[current_r][current_c]='<';
				
			}
			return;
		}
		map[current_r][current_c]='<';
	};
	public static void R() {
		current_state='R';
		if(current_c+1<W) {
			if(map[current_r][current_c+1]=='.') {
				map[current_r][current_c+1]='>';
				map[current_r][current_c]='.';
				current_c++;
			}
			else {
				map[current_r][current_c]='>';
			}
			return;
		}
		map[current_r][current_c]='>';
	};
	public static void S() {
		int buffer_r=current_r;
		int buffer_c=current_c;
		if(current_state=='U') {
			while(true) {
				buffer_r--;
				if(buffer_r<0) {
					break;
				}
				if(map[buffer_r][buffer_c]=='*') {
					map[buffer_r][buffer_c]='.';
					break;
				}
				else if(map[buffer_r][buffer_c]=='#') {
					break;
				}
			}
		}
		else if(current_state=='D') {
			while(true) {
				buffer_r++;
				if(H<=buffer_r) {
					break;
				}
				if(map[buffer_r][buffer_c]=='*') {
					map[buffer_r][buffer_c]='.';
					break;
				}
				else if(map[buffer_r][buffer_c]=='#') {
					break;
				}
			}
		}
		else if(current_state=='L') {
			while(true) {
				buffer_c--;
				if(buffer_c<0) {
					break;
				}
				if(map[buffer_r][buffer_c]=='*') {
					map[buffer_r][buffer_c]='.';
					break;
				}
				else if(map[buffer_r][buffer_c]=='#') {
					break;
				}
			}
		}
		else if(current_state=='R') {
			while(true) {
				buffer_c++;
				if(W<=buffer_c) {
					break;
				}
				if(map[buffer_r][buffer_c]=='*') {
					map[buffer_r][buffer_c]='.';
					break;
				}
				else if(map[buffer_r][buffer_c]=='#') {
					break;
				}
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			System.out.print("#"+(t+1)+" ");
			String []buffer = br.readLine().split(" ");
			H = Integer.parseInt(buffer[0]);
			W = Integer.parseInt(buffer[1]);
			map=new char[H][W];
			//init map
			for(int i=0;i<H;i++) {
				String line = br.readLine();
				for(int j=0;j<W;j++) {
					map[i][j]=line.charAt(j);
					
					switch(map[i][j]) {
						case '>':
							current_state='R';
							current_r=i;
							current_c=j;
							break;
						case '^':
							current_state='U';
							current_r=i;
							current_c=j;
							break;
						case '<':
							current_state='L';
							current_r=i;
							current_c=j;
							break;
						case 'v':
							current_state='D';
							current_r=i;
							current_c=j;
							break;
					}
				}
			}
			int cmd_num=Integer.parseInt(br.readLine());
			char [] cmds = br.readLine().toCharArray();
			for(char c: cmds) {
				switch(c) {
					case 'U':
						U();
						break;
					case 'D':
						D();
						break;
					case 'L':
						L();
						break;
					case'R':
						R();
						break;
					case'S':
						S();
						break;
				}
			}//cmds for end
			for(char []ca:map) {
				for(char c:ca)
					System.out.print(c);
				System.out.println();
			}
		}//test case for end


		
	}//main end

}//class end
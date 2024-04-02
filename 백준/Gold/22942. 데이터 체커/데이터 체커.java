import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
	public static class position implements Comparable<position>{
		
		  // 원이 x축에 접하는 x 좌표
			public int x;
			// 몇번째 원의 접점인지 저장하는 변수
			public int num;
			// 원의 x 접점의 왼쪽 오른쪽
			public char oc;
			public position() {
				super();
				// TODO Auto-generated constructor stub
			}

			public position(int x, int num,char oc) {
				super();
				this.x = x;
				this.num = num;
				this.oc = oc;
			}

			@Override
			public int compareTo(position o) {
				
				return Integer.compare(this.x, o.x);
			}
			
			
		}
		public static void main(String[] args) throws NumberFormatException, IOException {
			// TODO Auto-generated method stub
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int N = Integer.parseInt(br.readLine());
			
			position [] input = new position[N*2];
			
			
			for(int n=0 ; n<N*2; n+=2) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				int mid  = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				
				position ps = new position(mid-r,n,'o');
				position pe = new position(mid+r,n,'c');
				input[n]=ps;
				input[n+1]=pe;
					
			}
			Arrays.sort(input);
			
			String result="YES";
			Stack <position> stack = new Stack<>();
			stack.push(input[0]);
			for(int i=1; i<N*2; i++) {
				if(stack.isEmpty()) {
					stack.push(input[i]);
					continue;
				}
				position stack_p = stack.peek();
				position arr_p = input[i];
				if(stack_p.num==arr_p.num) {
					stack.pop();
				}
	            else{
	                if(stack_p.x == arr_p.x){
					    result="NO";
					    break;
				    }
				    else if(stack_p.oc ==arr_p.oc) {
					    stack.push(arr_p);
				    }
				    else if(stack_p.oc!=arr_p.oc) {
					    result="NO";
					    break;
				    }
	            }

			}
			System.out.println(result);
			
		}

	}
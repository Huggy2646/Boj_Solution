import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if(n == 0) {
			System.out.println(0);
			return;
		} else if(n==1) {
			System.out.println(br.readLine());
			return;
		} else if(n==2) {
			System.out.println(Math.round(Integer.parseInt(br.readLine())+Integer.parseInt(br.readLine()))/2.0);
			return;
		}else if(n==3) {
			System.out.println(Math.round(Integer.parseInt(br.readLine())+Integer.parseInt(br.readLine())+Integer.parseInt(br.readLine()))/3.0);
			return;
			
		}
		
		int ftper = (int) Math.round(n*0.15);
		int[] nums = new int[n];
		for(int i=0; i<n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(nums);
		int sum = 0;
		int cnt = 0;
		for(int i=ftper; i<n-ftper; i++) {
			sum+=nums[i];
			cnt++;
		}
		System.out.println(Math.round((float)sum/cnt));
		
		return ;
	}

}
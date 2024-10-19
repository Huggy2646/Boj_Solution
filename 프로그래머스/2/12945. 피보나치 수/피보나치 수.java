import java.util.*;
class Solution {
    static int[] dp = new int[1000000];
    public int solution(int n) {
        Arrays.fill(dp,-1);
        dp[0]=0;
        dp[1]=1;
        int answer = fibo(n);
        return answer;
    }
    
    public int fibo(int n){
        if(dp[n]!=-1)
            return dp[n];
        return dp[n]=(fibo(n-1)+fibo(n-2))%1234567;
    }
}
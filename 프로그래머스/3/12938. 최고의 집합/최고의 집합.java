class Solution {
    public int[] solution(int n, int s) {
        int div = s/n;
        if(div==0)
            return new int[]{-1};
        int mod = s%n;
        
        int [] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=div;
        }
        
        int idx = 0;
        for(int i=0; i<mod; i++){
            arr[(n-1)-(idx%n)]+=1;
            idx++;
        }
        
        return arr;
    }
}
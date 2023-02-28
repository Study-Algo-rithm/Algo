class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int dp[] = new int [n+1];
        dp[1] = 1;// 한칸
        dp[2] = 2;// 두칸
        
        for(int i = 3; i <= n; i++){
            dp[i] = (dp[i-1]%1000000007+ dp[i-2]%1000000007)%1000000007;
        }//나눠서 나머지의 합저장
        
        
        answer = dp[n];
        return answer;
    }
}
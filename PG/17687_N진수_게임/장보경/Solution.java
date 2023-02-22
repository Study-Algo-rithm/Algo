class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";

        int num = 0;
        StringBuilder sb = new StringBuilder();
        while(sb.length() < t*m){
            String decimalToN = Integer.toString(num, n);
            sb.append(decimalToN);
            num++;
        }
        
        for (int i=p-1; i<sb.length(); i+=m){
            answer += sb.toString().charAt(i);
            
            if(answer.length() == t) break;
        }
        answer = answer.toUpperCase();

        return answer;
    }
}

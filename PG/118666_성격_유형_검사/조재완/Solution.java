class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        int R = 0, T = 0, C = 0, F = 0,
            J = 0, M = 0, A = 0, N = 0;
        
        for(int i = 0; i < survey.length; i++){
            
            String temp = survey[i];
            
            char type = temp.charAt(0);
            
            if(choices[i] > 4){
                type = temp.charAt(1);
            }
            
            int score = Math.abs(choices[i] - 4);
            
            switch(type){
                case 'R' : 
                    R += score;
                    break;
                case 'T' : 
                    T += score;
                    break;
                
                case 'C' : 
                    C += score;
                    break;
                case 'F' : 
                    F += score;
                    break;
                
                case 'J' : 
                    J += score;
                    break;
                case 'M' : 
                    M += score;
                    break;
                
                case 'A' : 
                    A += score;
                    break;
                case 'N' : 
                    N += score;
                    break; 
            }
        }
        
        
        char T1 = (R >= T) ? 'R':'T';
        char T2 = (C >= F) ? 'C':'F';
        char T3 = (J >= M) ? 'J':'M';
        char T4 = (A >= N) ? 'A':'N';
        answer =""+T1+T2+T3+T4;
        return answer;
    }
}
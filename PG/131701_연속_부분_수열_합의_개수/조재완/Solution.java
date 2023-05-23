import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> A = new HashSet<Integer>();
        
        for(int i = 1; i <=elements.length; i++){
            int [] arr = getSum(i,elements);
            for(int sum : arr){
                A.add(sum);
                
            }
            

        }
        answer = A.size();
        return answer;
        
    }
    
    public int [] getSum(int n, int[] elements){
        int [] res = new int [elements.length];
        for(int i = 0; i<elements.length; i++){
            int sum = 0;
            for(int j = 0; j<n; j++){
                int idx = (i+j)%elements.length;
                sum += elements[idx];
            }
            res[i] = sum;
        }
        return res;
    }
}
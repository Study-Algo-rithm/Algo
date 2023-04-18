import java.util.*;
class Solution {
    public int solution(int[] topping) {
       int answer = 0;
        
        Map<Integer, Integer> heung = new HashMap<>(); 
        Map<Integer, Integer> dongsang = new HashMap<>();
        
        for (int e : topping) {
            dongsang.put(e, dongsang.getOrDefault(e, 0) + 1);
        }
        
        for (int e : topping) {
            heung.put(e, heung.getOrDefault(e, 0) + 1);
            
            if (dongsang.get(e) - 1 == 0)
                dongsang.remove(e);
            else
                dongsang.put(e, dongsang.get(e) - 1);  
            
            if (heung.size() == dongsang.size())
                answer++;
        }

        return answer;
    }
}
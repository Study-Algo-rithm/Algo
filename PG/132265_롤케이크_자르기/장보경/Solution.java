import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        int toppingCnt = topping.length;
        HashSet<Integer> hs = new HashSet<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        hs.add(topping[0]);
        for (int i=1; i<toppingCnt; i++){
            hm.put(topping[i], hm.getOrDefault(topping[i], 0)+1);
        }

        for (int i=1; i<toppingCnt; i++){
            hs.add(topping[i]);
            hm.replace(topping[i], hm.get(topping[i])-1);
            if (hm.get(topping[i]) == 0){
                hm.remove(topping[i]);
            }
            
            if (hs.size() == hm.size()){
                answer++;
            }
        }
        System.out.println(answer);
        
        return answer;
    }
}

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> match = new HashMap<>();
        for(int i = 0; i < want.length; i++) {
            match.put(want[i], i);
        }

        
        int ptr1 = 0;
        int ptr2 = 9;

        int[] saleNum = new int[number.length];
        for(int i = 0; i < 10; i++) {
            if(match.containsKey(discount[i])) {
                saleNum[match.get(discount[i])]++;
            }
        }
        while(true) {
           if(checkMatch(number, saleNum))
               answer++;

            if(match.containsKey(discount[ptr1])) {
                saleNum[match.get(discount[ptr1])]--;
            }

           ptr1++;
           ptr2++;

            if(ptr2 == discount.length)
                break;

            if(match.containsKey(discount[ptr2])) {
                saleNum[match.get(discount[ptr2])]++;
            }
        }
        
        return answer;
    }
    
     Boolean checkMatch(int[] number, int[] saleNum) {
        for(int i = 0; i < number.length; i++) {
            if(number[i]>saleNum[i])
                return false;
        }
        return true;
    }
}
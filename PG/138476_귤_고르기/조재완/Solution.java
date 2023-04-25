import java.util.*;
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        for (int e : tangerine) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }
      
        List<Integer> keylist = new ArrayList<>(map.keySet());
        Collections.sort(keylist, new TComparator());

        for (Integer e : keylist) {
            if (k <= 0) 
                break;
            answer++;
            k -= map.get(e);
        }
        return answer;
    }
    
    public class TComparator implements Comparator<Integer> {
        
        @Override
        public int compare(Integer o1, Integer o2) {
            return map.get(o2).compareTo(map.get(o1));
        }
    }
}
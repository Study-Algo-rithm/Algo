import java.util.*;

class Solution {
    static ArrayList<Integer> al;
    static HashMap<Integer, Integer> hm;

    public static int solution(int k, int[] tangerine) {
        int answer = 0;

        hm = new HashMap<>();
        for (int i=0; i<tangerine.length; i++){
            hm.put(tangerine[i], hm.getOrDefault(tangerine[i], 0)+1);
        }
        al = new ArrayList<>(hm.keySet());
        al.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return hm.get(o2) - hm.get(o1);
            }
        });

        for (int num: al){
            if (k <= 0) break;
            answer++;
            k -= hm.get(num);
        }

        return answer;
    }
}

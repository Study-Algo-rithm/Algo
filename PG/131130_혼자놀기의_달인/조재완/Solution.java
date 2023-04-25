import java.util.*;
class Solution {
   static boolean[] visit;
    static int depth;

    public int solution(int[] cards) {
        int answer = 0;
        visit = new boolean[cards.length+1];
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<cards.length;i++) {
            if(!visit[i+1]) {
                depth = 1;
                visit[i+1] = true;
                open(cards[i], cards);
                list.add(depth);
            }
        }
        if(list.size()<2) {
            return 0;
        }
        Collections.sort(list, Collections.reverseOrder());
        answer = list.get(0) * list.get(1);
        return answer;
    }

    private static void open(int x, int[] cards) {
        if(!visit[x]) {
            visit[x] = true;
            depth += 1;
            open(cards[x-1], cards);
        }
    }
}
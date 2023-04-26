import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<Integer> al;

    public static int solution(int[] cards) {
        int answer = 0;

        al = new ArrayList<>();
        visited = new boolean[cards.length];
        for (int i=0; i<cards.length; i++){
            if (visited[i]) continue;
            openBox(cards, i, 0);
        }

        if (al.size() != 1){
            Collections.sort(al);

            int a = al.get(al.size()-1);
            int b = al.get(al.size()-2);
            answer = a * b;
        }
        
        return answer;
    }

    static void openBox(int[] cards, int idx, int cnt){
        if (visited[idx]){
            al.add(cnt);
            return;
        }

        visited[idx] = true;
        openBox(cards, cards[idx]-1, cnt+1);
    }
}

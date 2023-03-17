import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        
        int min = name.length()-1;
        for (int i=0; i<name.length(); i++){
            char c = name.charAt(i);
            int mov = c - 'A';
            if ('Z' - c + 1 <= mov){
                mov = 'Z' -c +1;
            }
            answer += mov;

            int nextIdx = i + 1;
            while (nextIdx<name.length() && name.charAt(nextIdx) == 'A'){
                nextIdx++;
            }

            min = Math.min(min, (i*2) + name.length() - nextIdx);
            min = Math.min(min, (name.length() - nextIdx) * 2 + i);
        }
        answer += min;
        System.out.println(answer);

        return answer;
    }
}

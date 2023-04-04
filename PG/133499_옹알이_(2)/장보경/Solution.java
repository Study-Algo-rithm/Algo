import java.util.*;

class Solution {
    static int ans;
    
    public int solution(String[] babbling) {
        int answer = 0;

        for (int i=0; i<babbling.length; i++){
            chkContains(babbling[i]);
        }
        answer = ans;

        return answer;
    }

    // 네 가지 발음이 포함되어있는 지 확인
    static void chkContains(String s){
        String[] splitResult = s.split("aya|ye|woo|ma");

        if (splitResult.length == 0){
            chkRepeat(s);
        }
    }

    // 연속해서 같은 발음을 하는 지 확인
    static void chkRepeat(String s){
        String[] pronunciations = {"aya", "ye", "woo", "ma"};

        for (int i=0; i<4; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(pronunciations[i]).append(pronunciations[i]);

            if (s.contains(sb.toString())){
                return;
            }
        }
        ans++;
    }
}

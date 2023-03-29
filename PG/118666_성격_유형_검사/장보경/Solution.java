import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        String[] type = {"R", "T", "C", "F", "J", "M", "A", "N"};
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i=0; i<type.length; i++){
            hm.put(type[i], 0);
        }

        // 매우비동의 ~ 매우동의 점수 매겨서 hm 갱신
        for (int i=0; i<survey.length; i++){
            if (choices[i] == 4) continue;
            if (choices[i] < 4){
                String key = String.valueOf(survey[i].charAt(0));
                int value = 4 - choices[i];

                hm.replace(key, hm.get(key)+value);
            } else{
                String key = String.valueOf(survey[i].charAt(1));
                int value = choices[i] - 4;

                hm.replace(key, hm.get(key)+value);
            }
        }

        // 지표번호가 같은 애들끼리 비교
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<type.length; i+=2){
            int typeVal1 = hm.get(type[i]);
            int typeVal2 = hm.get(type[i+1]);

            if (typeVal1 == typeVal2){
                sb.append(type[i]);  // 사전순으로 배열에 들어가있음
            } else if (typeVal1 > typeVal2){
                sb.append(type[i]);
            } else{
                sb.append(type[i+1]);
            }
        }
        answer = sb.toString();
        
        return answer;
    }
}

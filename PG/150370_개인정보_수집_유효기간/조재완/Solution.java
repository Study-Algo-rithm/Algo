import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        Map<String, String> termsMap = new HashMap<>(); // key : 종류, value : 기간
        for (String term : terms) {
            String[] termSplit = term.split(" ");
            termsMap.put(termSplit[0], termSplit[1]);
        }

        int number = 1; 
        List<Integer> result = new ArrayList<>();
        int todayTotalDate = getTotalDate(today, 0);
        for (String p : privacies) {
            String[] privateSplit = p.split(" ");
            
            String privateDate = privateSplit[0];
            
            String privateTerm = privateSplit[1];
           
            int termsMonth = Integer.valueOf(termsMap.get(privateTerm));

            
            int privateTotalDate = getTotalDate(privateDate, termsMonth) - 1; 
            
            if (privateTotalDate < todayTotalDate) {
                result.add(number);
            }

            number++;
        }
        answer = result.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }


    private Integer getTotalDate(String strDate, Integer termsMonth) {
        String[] dateSplit = strDate.split("\\.");
        Integer year = Integer.valueOf(dateSplit[0]);
        Integer month = Integer.valueOf(dateSplit[1]) + termsMonth;
        Integer day = Integer.valueOf(dateSplit[2]);


        return (year * 12 * 28) + (month * 28) + day;
    }
}
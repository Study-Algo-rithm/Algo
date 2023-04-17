import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        int[] todayArr = splitStr(today);
        int tYear = todayArr[0];
        int tMonth = todayArr[1];
        int tDay = todayArr[2];

        HashMap<String, Integer> hm = new HashMap<>();
        for (int i=0; i<terms.length; i++){
            String[] termStrArr = terms[i].split(" ");
            hm.put(termStrArr[0], Integer.parseInt(termStrArr[1]));
        }

        ArrayList<Integer> al = new ArrayList<>();
        for (int i=0; i<privacies.length; i++){
            String[] privacieArr = privacies[i].split(" ");
            int[] dateArr = splitStr(privacieArr[0]);

            int privacie = hm.get(privacieArr[1]);
            int year = dateArr[0]+((dateArr[1]+privacie-1)/12);
            int month = (dateArr[1]+privacie)%12;
            if(month == 0){
                month = 12;
            }

            if (tYear==year){
                if (tMonth == month){
                    if (tDay >= dateArr[2]){
                        al.add(i+1);
                    }
                } else if (tMonth > month){
                    al.add(i+1);
                }

            } else if (tYear > year){
                al.add(i+1);
            }
        }

        answer = new int[al.size()];
        for (int i=0; i<al.size(); i++){
            answer[i] = al.get(i);
            System.out.println(answer[i]);
        }

        return answer;
    }

    public static int[] splitStr(String date){
        String[] dateArr = date.split("\\.");
        int year = Integer.parseInt(dateArr[0]);
        int month = Integer.parseInt(dateArr[1]);
        int day = Integer.parseInt(dateArr[2]);

        return new int[]{year, month, day};
    }
}

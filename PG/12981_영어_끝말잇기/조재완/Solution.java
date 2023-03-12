import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};// 초기값 세팅
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i< words.length; i++){
            if(i != 0){//0일 때는 생략
                String last = words[i-1];//직전 단어
                String now = words[i];//현재 단어
                
                if(map.containsKey(now) || last.charAt(last.length()-1) != now.charAt(0)){ // 있는거 말하거나 다르게 말하거나
                    answer[0] = (i%n)+1; // 번호
                    answer[1] = (i/n)+1; // 차례
                    
                    return answer;
                }
            }
            
            map.put(words[i],1);// 단어 저장
        }
        

        return answer;
    }
}
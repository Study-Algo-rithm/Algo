import java.util.*;

class Solution {
    static int ans;
    
    public int solution(String s) {
        int answer = 0;

        rotation(s);
        answer = ans;

        return answer;
    }

    static void rotation(String s){
        for (int i=0; i<s.length(); i++){
            Stack<Character> open = new Stack<>();

            for (int j=0; j<s.length(); j++){
                int idx = (i+j) % s.length();

                char now = s.charAt(idx);
                if (open.isEmpty()){
                    open.add(now);
                } else if (open.peek()=='(' && now==')'){
                    open.pop();
                } else if (open.peek()=='{' && now=='}'){
                    open.pop();
                } else if (open.peek()=='[' && now==']'){
                    open.pop();
                } else{
                  open.add(now);  
                }
            }

            if (open.isEmpty()){
                ans++;
            }
        }
    }
}

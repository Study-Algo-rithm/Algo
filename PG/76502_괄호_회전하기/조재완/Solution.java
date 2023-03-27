import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for (int i = 0; i < s.length(); i++) {
            Stack<Character> st = new Stack<>();
            
            String temp = s.substring(i, s.length()) + s.substring(0, i);
            
            for (int j = 0; j < temp.length(); j++) {
                char c = temp.charAt(j);
                if (st.isEmpty()) {//비었으면 넣고
                    st.push(c);
                } else if (c == ')' && st.peek() == '(') {//닫는 괄호이고 같은 쌍이면 스텍에서 꺼내고
                    st.pop();
                } else if (c == '}' && st.peek() == '{') {
                    st.pop();
                } else if (c == ']' && st.peek() == '[') {
                    st.pop();
                } else {//여는 괄호면 넣고
                    st.push(c);
                }
            }
            if (st.isEmpty()) {
                answer++;
            }
        }

        
        return answer;
    }
}
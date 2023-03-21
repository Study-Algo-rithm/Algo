class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();

        int idx; 
        int move = len - 1; 

        for(int i = 0; i < name.length(); i++){
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);// 알파벳 상하 계산
            idx = i + 1;// 다음 글자를 보고 A 인지 확인
            while(idx < len && name.charAt(idx) == 'A'){// A 나올 때 까지 카운트
                idx++;
            }
 
            move = Math.min(move, i * 2 + (len - idx));// 앞에 부터 바꾸고 다시 뒤로
            move = Math.min(move, (len - idx) * 2 + i);// 뒤에 부터 바꾸고 다시 앞으로
        }
        return answer + move;
    }
}
import java.util.*;

class Solution {
    public static int[] solution(int n, long k) {
        int[] answer = new int[n];

        long cal = 1;  // 경우의 수
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=1; i<=n; i++){
            cal *= i;
            al.add(i);
        }
        k--;

        int cnt = 0;
        for (int i=n; i>0; i--){
            cal /= i;  // 범위 나누기

            int idx = (int) (k/cal); // n명의 사람 중 한명 선택하기 위한 인덱스
            answer[cnt++] = al.get(idx);  // 순서대로 배열에 넣어주기
            al.remove(idx);  // 선택한 사람 지우기
            k %= cal; // 인덱스 선택하고 난 나머지
        }
        
        return answer;
    }
}

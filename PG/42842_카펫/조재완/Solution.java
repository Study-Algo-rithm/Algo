class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        
        //노란색과 갈색의 타일 전체 수를 더한다. 왜? 총 타일수를 알아야 가로새로를 구할꺼 아니냐
        //이제부터 가로와 세로 타일 개수를 구한다.
        //조건은 가로 세로 둘다 3이상이어야 한다 왜냐면 노랑이 둘러싸이려면 최소 가로와 세로가 3이상이어야하기 때문
        //그리고 가로가 더 길다거나 같다고 문제 상황에서 나와있다.
        
        for (int i = 3; i < sum; i++) {// 3부터 시작해서 
            int j = sum / i;
            
            if (sum % i == 0 && j >= 3) {// 나누어 떨어지고 몫도 3이상일 경우에
                int garo = Math.max(i, j);// 가로
                int sero = Math.min(i, j);// 세로
                int iner = (garo - 2) * (sero - 2);// 태두리 빼고 안에 있는 타일 수
                
                if (iner == yellow) {// 안에 있는 타일 수가 제시된 yellow 와 같으면
                    answer[0] = garo;// 답에 집어넣기
                    answer[1] = sero;
                    return answer;
                }
            }
        }
        return answer;
    }
}
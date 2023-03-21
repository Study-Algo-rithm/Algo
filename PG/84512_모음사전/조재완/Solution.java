class Solution {
    public int solution(String word) {
        int answer = 0;
        String str = "AEIOU";
		int[] x = {781, 156, 31, 6, 1};// 자리 위치 별로 커지는 순서의 단위
		int idx =word.length();
        answer = word.length();// 처음에 a 하나부터 5개 까지 는 초기값으로 더해주고
		for(int i=0;i<word.length();i++){
			idx = str.indexOf(word.charAt(i));// 그자리의 모음을 찾아주고
			answer += x[i]*idx;// 자리 위치의 순서의 단위랑 모음의 순서랑 곱해서 더한다.
		}
		
        return answer;
    }
}
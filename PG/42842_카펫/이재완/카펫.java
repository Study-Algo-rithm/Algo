class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int y=3;;y++)
        {
            int x=(brown+4)/2-y;
            if((x-2)*(y-2)==yellow)
            {
                answer[0]=x;
                answer[1]=y;
                break;
            }
        }
        return answer;
    }
}
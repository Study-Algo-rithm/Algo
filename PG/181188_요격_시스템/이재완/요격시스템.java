import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (o1,o2)->{
            return o1[1]-o2[1];
        });
        
        int shootLOC=0;
        for(int[] target:targets)
        {
            if(shootLOC==0)
            {
                shootLOC=target[1];
                answer++;
                continue;
            }

            if(target[0]>=shootLOC)
            {
                answer++;
                shootLOC=target[1];
            }
            
        }
        return answer;
    }
}
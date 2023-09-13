import java.util.*;
class Solution {
    public static boolean weightFull(int truck,int bridgeWeight,int weight)
    {
        if(truck+bridgeWeight>weight)
            return true;
        return false;
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int bridgeWeight=0;
        int truckOut=0;
        Queue<Integer> que=new LinkedList<>();
        
        for(int i=0;truckOut<truck_weights.length;)
        {
            if(que.size()==bridge_length)
            {
                int truck=que.remove();
                bridgeWeight-=truck;
                if(truck!=0)
                    truckOut++;
            }
            
            if(i<truck_weights.length&&!weightFull(truck_weights[i],bridgeWeight,weight))
            {
                que.add(truck_weights[i]);
                bridgeWeight+=truck_weights[i];
                i++;
            }
            else
                que.add(0);
            
            answer++;
        }
        return answer;
    }
}
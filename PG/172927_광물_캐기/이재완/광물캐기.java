import java.util.*;
class Solution {
    public int result=Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int pickSize=0;
        for(int i=0;i<picks.length;i++)
            pickSize+=picks[i]*5;
        
        dfs(0,0, picks, minerals, answer,pickSize);
        return result;
    }
    public void dfs(int depth,int pick, int[] picks, String[] minerals, int answer,int pickSize)
    {
        int tired;
        if(depth==minerals.length||depth==pickSize)
        {
            result=Math.min(answer,result);
            return;
        }
        if((depth)%5!=0)
        {
            tired=addTired(pick,minerals[depth],answer);
            dfs(depth+1,pick,picks,minerals,tired,pickSize);
        }
        else
        {
            //곡괭이 반복문
            for(int i=0;i<3;i++)
            {
                if(picks[i]!=0)
                {
                    tired=addTired(i,minerals[depth],answer);
                    --picks[i];
                    dfs(depth+1,i,picks,minerals,tired,pickSize);
                    ++picks[i];
                }
            }
        }
        
    }
    public int addTired(int pick, String mineral, int answer)
    {
        if(pick==0&&mineral.equals("diamond"))
            return answer+1;
        else if(pick==0&&mineral.equals("iron"))
            return answer+1;
        else if(pick==0&&mineral.equals("stone"))
            return answer+1;
        else if(pick==1&&mineral.equals("diamond"))
            return answer+5;
        else if(pick==1&&mineral.equals("iron"))
            return answer+1;
        else if(pick==1&&mineral.equals("stone"))
            return answer+1;
        else if(pick==2&&mineral.equals("diamond"))
            return answer+25;
        else if(pick==2&&mineral.equals("iron"))
            return answer+5;
        else if(pick==2&&mineral.equals("stone"))
            return answer+1;
        else
            return -1;
    }
}
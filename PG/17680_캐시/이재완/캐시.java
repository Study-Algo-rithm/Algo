import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> list=new ArrayList<>();
        
        for(int i=0;i<cities.length;i++)
        {
            boolean hit=false;
            String input=cities[i].toUpperCase();
            for(int j=0;j<list.size();j++)
            {
                String inList=list.get(j).toUpperCase();
                if(cacheSize!=0&&inList.equals(input))
                {
                    list.remove(j);
                    hit=true;
                    break;
                }
            }
            
            if(cacheSize!=0&&list.size()==cacheSize)
                list.remove(0);
            
            list.add(input);
            answer=hit?++answer:answer+5;
        }
        
        return answer;
    }
}
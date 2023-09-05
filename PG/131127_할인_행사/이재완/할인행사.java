import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int[] discountNum=new int[number.length]; //할인제품 중 원하는 물건들의 개수
        ArrayList<String> slidingWindow=new ArrayList<String>(); //열흘짜리 슬라이딩 윈도우
        
        for(int i=0;i<10;i++)
        {
            slidingWindow.add(discount[i]); //첫 열흘의 물건들 
            ///첫 열흘 중 물건 개수 확인///
            for(int j=0;j<want.length;j++)
            {
                if(discount[i].equals(want[j])) //내가 원하는 할인제품임
                    discountNum[j]++; //원하는 물건의 개수 ++
            }
        }
        
        ////원하는 개수가 모두 충족되는지 ///
        int count=0;
        for(int i=0;i<discountNum.length;i++)
        {
            if(number[i]==discountNum[i])
                count++;
        }
        if(count==number.length)
            answer++;
        
        ///슬라이딩 윈도우 시작///
        for(int i=10;i<discount.length;i++)
        {
            ///제외할 물건 discountNum에서 -- ///
            for(int j=0;j<want.length;j++)
            {
                if(slidingWindow.get(0).equals(want[j]))
                {
                    discountNum[j]--; 
                    break;
                }
            }
            
            slidingWindow.remove(0);
            slidingWindow.add(discount[i]);
            
            ///추가할 물건 dicountNum에서 ++ ///
            for(int j=0;j<want.length;j++)
            {
                if(slidingWindow.get(9).equals(want[j]))
                {
                    discountNum[j]++;
                    break;
                }
            }
            
            ////원하는 개수가 모두 충족되는지 ///
            count=0;
            for(int j=0;j<discountNum.length;j++)
            {
                if(number[j]==discountNum[j])
                    count++;
            }
            if(count==number.length)
                answer++;

        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int len=citations.length;
        int[] arr=Arrays.copyOf(citations,len+1); //배열에 0 추가
        
        reverseSort(arr,len+1); //내림차순 정렬
        
        int start=arr[0];
        int h=1;
        
        loop:
        for(int i=1;i<len+1;i++)
        {
            if(start!=arr[i])
            {
                for(int j=start;j>arr[i];j--)
                {
                    if(h>=j) //h번 이상 인용된 논문이 h편 이상
                    {
                        answer=j;
                        break loop;
                    }
                }
                start=arr[i];
            }
            h++;
        }
        
        return answer;
    }
    public void reverseSort(int[] citations,int len)
    {
        Arrays.sort(citations);
        
        int[] tmp=new int[len];
        for(int i=0,j=len-1;i<len;i++,j--)
            tmp[i]=citations[j];
        
        System.arraycopy(tmp,0,citations,0,tmp.length); //중요!
    }
}
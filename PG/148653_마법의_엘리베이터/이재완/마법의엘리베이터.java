class Solution {
    public static int answer=Integer.MAX_VALUE;
    public int solution(int storey) {
        String num=Integer.toString(storey);
        int[] arr=new int[num.length()+1]; 
        
        for(int i=1;i<arr.length;i++)
            arr[i]=num.charAt(i-1)-'0';
        
        dfs(arr,arr.length-1,0);
        
        return answer;
    }
    public static void dfs(int[] arr, int depth,int result)
    {
        if(depth==-1)
        {
            answer=Math.min(answer,result);
            return;
        }
        
        if(arr[depth]>=6)
        {
            result+=(10-arr[depth]);
            arr[depth-1]++;   
            dfs(arr,depth-1,result);
            arr[depth-1]--;
        }
        else if(arr[depth]==5)
        {
            arr[depth]++;   
            dfs(arr,depth,result+1);
            arr[depth]--;
            
            arr[depth]--;
            dfs(arr,depth,result+1);
            arr[depth]++;
        }
        else
        {
            result+=arr[depth];
            dfs(arr,depth-1,result);
        }
    }
}
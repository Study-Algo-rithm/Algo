class Solution {
    public int[][] arr;
    public int[] dr={1,0,-1}; //하,우,좌상
    public int[] dc={0,1,-1};
    public boolean[][] visited;
    
    public int[] solution(int n) {
        int size=(1+n)*(n/2);
        int middleV=(n/2)+1;
        size=n%2!=0?size+middleV:size;
        int[] answer=new int[size];
        
        arr=new int[n][n];
        arr[0][0]=1;     
        visited=new boolean[n][n];
        visited[0][0]=true;
        
        dfs(2,0,0,0,size);
        
        int cnt=0;
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr.length;j++)
            {
               if(arr[i][j]!=0)
                   answer[cnt++]=arr[i][j];
            }
        }
        
        return answer;
    }
    public void dfs(int num,int x,int y,int dir,int size)
    {
        if(num>size)
            return;

        int nextX=x+dr[dir];
        int nextY=y+dc[dir];
        while(range(nextX,nextY)&&!visited[nextX][nextY])
        {   
            arr[nextX][nextY]=num++;
            visited[nextX][nextY]=true;
            x=nextX;
            y=nextY;
            nextX=x+dr[dir];
            nextY=y+dc[dir];
        }

        if(dir!=dr.length-1)
            dfs(num,x,y,dir+1,size);
        else
            dfs(num,x,y,0,size);
        
    }
    public boolean range(int x,int y)
    {
        return x>=0&&x<arr.length&&y>=0&&y<arr.length;
    }
}
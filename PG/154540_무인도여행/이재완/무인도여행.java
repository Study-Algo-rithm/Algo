import java.util.*;
class Solution {
    public static char[][] arr;
    public static boolean[][] visited;
    public static int[] dr={0,1,0,-1};
    public static int[] dc={1,0,-1,0};
    
    public int[] solution(String[] maps) {
        int rows=maps.length;
        int cols=maps[0].length();
        arr=new char[rows][cols];
        visited=new boolean[rows][cols];
        ArrayList<Integer> list=new ArrayList<>();
        int[] answer;
        
        //배열 입력
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
                arr[i][j]=maps[i].charAt(j);
        }
        
        //무인도 탐색
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(!visited[i][j]&&arr[i][j]!='X')
                    list.add(bfs(i,j,rows,cols,0));
            }
        }
        
        //정답 출력 형식으로 변환
        if(list.isEmpty())
            answer=new int[]{-1};
        else
        {
            answer=new int[list.size()];
            for(int i=0;i<list.size();i++)
                answer[i]=list.get(i);
            Arrays.sort(answer);
        }
        
        return answer;
    }
    public static int bfs(int x,int y,int rows,int cols,int val)
    {
        Queue<Integer> que=new LinkedList<>();
        visited[x][y]=true;
        que.add(x);
        que.add(y);
        
        while(!que.isEmpty())
        {
            x=que.remove();
            y=que.remove();
            val+=Character.getNumericValue(arr[x][y]);
            
            for(int i=0;i<4;i++)
            {
                int nextX=x+dr[i];
                int nextY=y+dc[i];
                
                if(nextX>=0&&nextX<rows&&nextY>=0&&nextY<cols&&!visited[nextX][nextY]&&arr[nextX][nextY]!='X')
                {
                    visited[nextX][nextY]=true;
                    que.add(nextX);
                    que.add(nextY);
                }
            }
        }
        
        return val;
    }
}
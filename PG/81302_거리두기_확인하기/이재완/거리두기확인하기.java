import java.util.*;

class Solution {
    public class Loc
    {
        public int x;
        public int y;
        public Loc(int x, int y)
        {
            this.x=x;
            this.y=y;
        }
    }
    
    public int[] solution(String[][] places) {
        
        int[] answer = {1,1,1,1,1};
        for(int i=0;i<places.length;i++)
        {
            char[][] arr=new char[5][5];
            ArrayList<Loc> loc=new ArrayList<Loc>();
            for(int j=0;j<places[i].length;j++)
            {
                for(int k=0;k<places[i][j].length();k++)
                {
                    arr[j][k]=places[i][j].charAt(k);
                    //출발점
                    if(arr[j][k]=='P')
                        loc.add(new Loc(j,k));
                }
            }
            
            //대기실 배열 완성 (이후 BFS)//
            int loc_len=loc.size();
            for(int t=0;t<loc_len;t++)
            {
                if(bfs(loc.get(t).x,loc.get(t).y,arr))
                    answer[i]=1;
                else
                {
                    answer[i]=0;
                    break;
                }    
            }
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
    public boolean bfs(int x, int y, char[][] arr)
    {
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        int depth=0;
        boolean[][] visited=new boolean[arr.length][arr[0].length];
        visited[x][y]=true;
        Queue<Integer> que_x=new LinkedList<Integer>();
        Queue<Integer> que_y=new LinkedList<Integer>();
        que_x.add(x);
        que_y.add(y);
        
        while(!que_x.isEmpty()&&depth<3)
        {
            int size=que_x.size();
            while(size>0)
            {
                int x1=que_x.remove();
                int y1=que_y.remove();

                if(depth!=0&&arr[x1][y1]=='P')
                    return false;
                
                for(int i=0;i<4;i++)
                {
                    int x2=x1+dx[i];
                    int y2=y1+dy[i];
                    if(x2>=0&&x2<arr.length&&y2>=0&&y2<arr[0].length)
                    {
                        if(!visited[x2][y2]&&arr[x2][y2]!='X')
                        {
                            que_x.add(x2);
                            que_y.add(y2);
                            visited[x2][y2]=true;
                        }
                    }
                    
                }
                size--;
            }
            depth++;
        }
        return true;
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class newGame {
    public static int N;
    public static int K;
    public static ArrayList<HORSE>[][] arr;
    public static char[][] colors;
    public static int dr[]={0,0,-1,1}; //우좌상하
    public static int dc[]={1,-1,0,0};

    public static class HORSE
    {
        public int x,y,dir,num;

        public HORSE(int x, int y, int dir, int num)
        {
            this.x=x;
            this.y=y;
            this.dir=dir;
            this.num=num;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int turn=1;
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        arr=new ArrayList[N][N];
        colors=new char[N][N];
        HORSE[] horses=new HORSE[K];

        for(int i=0;i<N;i++)
        {
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++)
            {
                colors[i][j]=st.nextToken().charAt(0);
                arr[i][j]=new ArrayList<>();
            }
        }

        for(int i=0;i<K;i++)
        {
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken())-1;
            int y=Integer.parseInt(st.nextToken())-1;
            int dir=Integer.parseInt(st.nextToken())-1;

            horses[i]=new HORSE(x,y,dir,i);
            arr[x][y].add(horses[i]);
        }
        Loop:
        while(turn<=1000)
        {
            for(int i=0;i<horses.length;i++)
            {
                //지금 말이 제일 밑에 있는 말임
                if(arr[horses[i].x][horses[i].y].get(0).num==i)
                {
                    int dir=horses[i].dir;
                    int nextX=horses[i].x+dr[dir];
                    int nextY=horses[i].y+dc[dir];
                    //다음 위치가 배열 범위 내
                    if(nextX>=0&&nextX<N&&nextY>=0&&nextY<N)
                    {
                        if(!move(i,horses,nextX,nextY,dir, colors[nextX][nextY]))
                            break Loop;
                    }
                    //배열 범위 밖
                    else
                    {
                        if(!move(i,horses,nextX,nextY,dir, '2'))
                            break Loop;
                    }
                }
            }
            turn++;
        }
        if(turn>=1000)
            System.out.println(-1);
        else
            System.out.println(turn);
    }
    public static boolean move(int i,HORSE[] horses, int nextX, int nextY, int dir,char ch)
    {
        int x=horses[i].x;
        int y=horses[i].y;
        switch (ch)
        {
            case '0': //흰색
                while(arr[x][y].size()>0)
                {
                    arr[x][y].get(0).x=nextX;
                    arr[x][y].get(0).y=nextY;
                    arr[nextX][nextY].add(arr[x][y].get(0));
                    arr[x][y].remove(0);
                }
                break;
            case '1': //빨강색
                while(arr[x][y].size()>0)
                {
                    int lasIDX=arr[x][y].size()-1;
                    arr[x][y].get(lasIDX).x=nextX;
                    arr[x][y].get(lasIDX).y=nextY;
                    arr[nextX][nextY].add(arr[x][y].get(lasIDX));
                    arr[x][y].remove(lasIDX);
                }
                break;
            case '2': //파랑색
                switch(dir)
                {
                    case 0:
                        arr[x][y].get(0).dir=1;
                        break;
                    case 1:
                        arr[x][y].get(0).dir=0;
                        break;
                    case 2:
                        arr[x][y].get(0).dir=3;
                        break;
                    case 3:
                        arr[x][y].get(0).dir=2;
                        break;
                }
                dir=horses[i].dir;
                nextX=x+dr[dir];
                nextY=y+dc[dir];
                //반대방향이 범위 내
                if(nextX>=0&&nextX<N&&nextY>=0&&nextY<N&&colors[nextX][nextY]!='2')
                    return move(i,horses,nextX,nextY,dir, colors[nextX][nextY]);
                else
                    return true;
        }
        if(arr[nextX][nextY].size()>=4)
            return false;
        else
            return true;
    }
}

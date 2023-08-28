import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class pipe {
    public static int dr[]={0,1,1}; //우/우하/하
    public static int dc[]={1,1,0}; //우/우하/하
    public static int[][] arr;
    public static int result=0;
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        arr=new int[N][N];
        for(int i=0;i<N;i++)
        {
            StringTokenizer st=new StringTokenizer(br.readLine());
            int cnt=st.countTokens();
            for(int j=0;j<cnt;j++)
                arr[i][j]=Integer.parseInt(st.nextToken());
        }

        dfs(0,0,1,N);
        System.out.println(result);
    }
    public static void dfs(int direction,int eWidth,int eHeight,int N)
    {
        if(eWidth==N-1&&eHeight==N-1) //도착지 도착
        {
            result++;
            return;
        }

        int start=0;
        int end=0;

        switch(direction)
        {
            case 0: //가로
                start=0;end=1;
                break;
            case 1: //대각선
                start=0;end=2;
                break;
            case 2: //세로
                start=1;end=2;
        }

        for(int i=start;i<=end;i++)
        {
            int nextW=eWidth+dr[i];
            int nextH=eHeight+dc[i];
            if(nextW<N&&nextH<N&&arr[nextW][nextH]!=1)
            {
                if(i==1&&(arr[nextW-1][nextH]==1||arr[nextW][nextH-1]==1))
                    continue;
                dfs(i,nextW,nextH,N);
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class universeShip {
    public static int[][] arr;
    public static boolean[] visited;
    public static int[] result;
    public static int min=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        visited=new boolean[N];
        result=new int[N];
        arr=new int[N][N];

        //입력
        for(int i=0;i<N;i++)
        {
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++)
                arr[i][j]=Integer.parseInt(st.nextToken());
        }

        //플로이드 워샬
        for(int k=0;k<N;k++)
        {
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                    arr[i][j]=Math.min(arr[i][j],arr[i][k]+arr[k][j]);
            }
        }

        //경로 탐색
        dfs(K,N,0);
        System.out.println(min);
    }
    public static void dfs(int start, int size,int depth)
    {
        //마지막 노드
        if(depth==size)
        {
            int len=0;
            for(int i=0;i<size-1;i++)
                len+=arr[result[i]][result[i+1]];
            min=Math.min(len,min);
            return;
        }
        //시작 노드
        else if(depth==0)
        {
            visited[start]=true;
            result[0]=start;
            dfs(start,size,depth+1);
            visited[start]=false;
        }
        else
        {
            for(int i=0;i<size;i++)
            {
                if(!visited[i])
                {
                    visited[i]=true;
                    result[depth]=i;
                    dfs(start,size,depth+1);
                    visited[i]=false;
                }
            }
        }

    }

}

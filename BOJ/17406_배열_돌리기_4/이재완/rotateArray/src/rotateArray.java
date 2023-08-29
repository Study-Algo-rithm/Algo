import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class rotateArray {
    public static boolean[] visited;
    public static int[] permList;
    public static int arr[][];
    public static int size[][];
    public static int dr[]={0,1,0,-1};//우하좌상
    public static int dc[]={1,0,-1,0};
    public static int min=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());

        arr=new int[N][M];
        size=new int[K][3];
        visited=new boolean[K];
        permList=new int[K];

        for(int i=0;i<N;i++)
        {
            st= new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++)
                arr[i][j]=Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<K;i++)
        {
            st= new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++)
                size[i][j]=Integer.parseInt(st.nextToken());
        }
        //배열 돌리기 순열
        perm(K,K,0);
        System.out.println(min);
    }
    public static void perm(int n,int r,int cnt)
    {
        if(cnt==r)
        {
            setArea();
            return;
        }
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                visited[i]=true;
                permList[cnt]=i;
                perm(n,r,cnt+1);
                visited[i]=false;
            }
        }
    }
    public static void setArea()
    {
        int[][] tmp=new int[arr.length][arr[0].length];
        //arr2에 원본 배열 복사
        int[][] arr2=new int[arr.length][arr[0].length];
        for(int i=0;i< arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
                arr2[i][j]=arr[i][j];
        }

        //순열대로 배열 돌리기
        for(int i=0;i<permList.length;i++)
        {
            int idx=permList[i];
            int R=size[idx][0];
            int C=size[idx][1];
            int S=size[idx][2];

            int startX=R-S-1;
            int startY=C-S-1;
            int endX=R+S-1;
            int endY=C+S-1;

            //배열 돌리기
            int depth=(endX-startX)/2; //중간 위치
            for(int j=0;j<depth;j++) //사각형 돌리기
                rotate(startX+j,startY+j,startX+j,startY+j,endX-j,endY-j,tmp,arr2,0);
            tmp[startX+depth][startY+depth]=arr2[startX+depth][startY+depth]; //중간값 저장

            //arr2에 tmp(돌린 배열) 복사
            for(int k=startX;k<=endX;k++)
            {
                for(int t=startY;t<=endY;t++)
                    arr2[k][t] = tmp[k][t];
            }

        }
        //배열의 최솟값 구하기
        min=Math.min(getMin(arr2),min);
    }
    public static void rotate(int startX,int startY,int X, int Y, int endX,int endY,int[][] tmp,int[][] arr2,int direction)
    {
        if(startX==X&&startY==Y&&direction!=0)
            return;

        int newX=X+dr[direction];
        int newY=Y+dc[direction];
        if(newX>=startX&&newX<=endX&&newY>=startY&&newY<=endY)
        {
            tmp[newX][newY]=arr2[X][Y];
            rotate(startX,startY,newX,newY,endX,endY,tmp,arr2,direction);
        }
        else
        {
            newX=X+dr[direction+1];
            newY=Y+dc[direction+1];
            tmp[newX][newY]=arr2[X][Y];
            rotate(startX,startY,newX,newY,endX,endY,tmp,arr2,direction+1);
        }
    }
    public static int getMin(int[][] arr2)
    {
        int minimum=Integer.MAX_VALUE;
        for(int i=0;i< arr2.length;i++)
        {
            int sum=0;
            for(int j=0;j<arr2[0].length;j++)
                sum += arr2[i][j];
            minimum=Math.min(sum,minimum);
        }
        return minimum;
    }
}

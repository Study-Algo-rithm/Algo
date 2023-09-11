import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static boolean[] visited;
    public static int[][] arr;
    public static boolean[] planV;
    public static boolean result=true;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int M=Integer.parseInt(br.readLine());
        int start;
        arr=new int[N][N];
        visited=new boolean[N];
        planV=new boolean[N];
        StringTokenizer st;

        //인접행렬 입력
        for(int i=0;i<N;i++)
        {
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++)
                arr[i][j]=Integer.parseInt(st.nextToken());
        }

        //여행계획 입력
        st=new StringTokenizer(br.readLine());
        start=Integer.parseInt(st.nextToken())-1;
        planV[start]=true;
        for(int i=1;i<M;i++)
        {
            int city=Integer.parseInt(st.nextToken())-1;
            planV[city]=true;
        }

        //1.연결관계 탐색
        bfs(start,N);

        //2.여행계획과 비교
        for(int i=0;i<N;i++)
        {
            //여행계획에 있는 노드인데, bfs로 탐색 못했으면
            if(planV[i]&&!visited[i])
            {
                result = false; //여행불가
                break;
            }
        }
        String answer=result?"YES":"NO";
        System.out.println(answer);
    }
    public static void bfs(int start,int N)
    {
        Queue<Integer> que=new LinkedList<>();
        que.add(start);

        while (!que.isEmpty())
        {
            int area=que.remove();
            visited[area]=true;
            for(int i=0;i<N;i++)
            {
                if(arr[area][i]==1&&!visited[i])
                {
                    que.add(i);
                }
            }
        }
    }

}

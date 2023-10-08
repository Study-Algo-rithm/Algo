import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좋다 {
    public static int[] arr;
    public static boolean visited[];
    public static boolean resultV[];
    public static int[] result=new int[2];
    public static int answer=0;
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        arr=new int[N];
        visited=new boolean[N];
        resultV=new boolean[N];
        for(int i=0;i<N;i++)
        {
            int num=Integer.parseInt(st.nextToken());
            arr[i]=num;
        }
        Arrays.sort(arr);
        comb(N,2,0,0);
        System.out.println(answer);
    }
    public static void comb(int n,int r, int depth,int start)
    {
        if(depth==r)
        {
            int sum=arr[result[0]]+arr[result[1]];

            for(int i=0;i<arr.length;i++)
            {
                if(!resultV[i]&&arr[i]==sum&&i!=result[0]&&i!=result[1])
                {
                    answer++;
                    resultV[i]=true;
                }
                else if(arr[i]>sum)
                {
                    break;
                }
            }
            return;
        }
        for(int i=start;i<n;i++)
        {
            if(!visited[i])
            {
                result[depth]=i;
                visited[i]=true;
                comb(n,r,depth+1,i);
                visited[i]=false;
            }
        }
    }
}

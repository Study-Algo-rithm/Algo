import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int wantSize=Integer.parseInt(br.readLine()); //손님이 원하는 크기
        StringTokenizer st=new StringTokenizer(br.readLine());
        int m=Integer.parseInt(st.nextToken()); //A 피자조각 개수
        int n=Integer.parseInt(st.nextToken()); //B 피자조각 개수
        int pizzaA[]=new int[m]; //A피자
        int pizzaB[]=new int[n]; //B피자
        int dpA[]=new int[m];
        int dpB[]=new int[n];
        int[] cntA; //피자 A의 중복되는 조각값 세기 (ex. 값이 3인 조각을 몇 개를 만들 수 있는지)
        int[] cntB; //피자 B의 중복되는 조각값 세기
        int pizzaATotal=0;
        int pizzaBTotal=0;
        int valA;
        int valB;
        int answer=0;

        //피자 A,B 입력
        for(int i=0;i<m;i++)
        {
            pizzaA[i] = Integer.parseInt(br.readLine());
            pizzaATotal+=pizzaA[i];
        }
        for(int i=0;i<n;i++)
        {
            pizzaB[i]=Integer.parseInt(br.readLine());
            pizzaBTotal+=pizzaB[i];
        }
        cntA=new int[pizzaATotal+1];
        cntB=new int[pizzaBTotal+1];

        getSum(dpA,pizzaA,cntA,m,pizzaATotal);
        getSum(dpB,pizzaB,cntB,n,pizzaBTotal);

        //피자 A로 만들 수 있는 합들 하나씩 꺼냄
        for(int i=0;i<=pizzaATotal;i++) {
            if(cntA[i]!=0){
                valA= i;
                valB=wantSize-valA;
                if(valB<0||valB>pizzaBTotal)
                    valB=0;
                //피자 A가 고객이 원하는 값임
                if(valA==wantSize)
                    answer+=cntA[valA];
                //피자 B가 고객이 원하는 값임
                else if(valB==wantSize)
                    answer+=cntB[valB];
                //피자 A+B가 고객이 원하는 값임
                else if(valA+valB==wantSize)
                    answer+=cntA[valA]*cntB[valB];
            }
        }
        System.out.println(answer);
    }
    public static void getSum(int[] dp,int[] pizza,int[] cnt,int size,int total)
    {
        //현재 피자가 0이고, 다른 피자가 wantSize일 경우 대비
        cnt[0]++;
        //현재 피자로 만들 수 있는 모든 합계를 구함
        for(int depth=0;depth<size-1;depth++)
        {
            for(int j=0;j<size;j++)
            {
                //대충 누적합 내용임
                int IDX=depth+j>=size?(depth+j)-size:depth+j;
                dp[j]=dp[j]+pizza[IDX];
                //이 누적합이 몇 개나 되는지 count
                cnt[dp[j]]++;
            }
        }
        //총합은 한 개만 들어가야 하므로, 따로 분기
        cnt[total]++;
    }
}
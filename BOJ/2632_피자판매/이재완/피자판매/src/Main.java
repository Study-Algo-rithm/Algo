import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
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
        HashSet<Integer> set=new HashSet<>(); //피자 A로 만들 수 있는 합들 저장
        int[] cntA=new int[m*1000]; //피자 A의 중복되는 조각값 세기 (ex. 값이 3인 조각을 몇 개를 만들 수 있는지)
        int[] cntB=new int[n*1000]; //피자 B의 중복되는 조각값 세기
        int answer=0;

        //피자 A,B 입력
        for(int i=0;i<m;i++)
            pizzaA[i]=Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++)
            pizzaB[i]=Integer.parseInt(br.readLine());

        //피자A
        set.add(0); //피자A가 0이고 피자B가 wantSize일 경우 대비
        //A로 만들 수 있는 모든 합계를 구함
        for(int depth=0;depth<m;depth++)
        {
            if(depth==m-1)
            {
                //총합은 한 개만 들어가야 하므로, 따로 분기
                set.add(dpA[0]+pizzaA[m-1]);
                cntA[dpA[0]+pizzaA[m-1]]++;
                break;
            }
            for(int j=0;j<m;j++)
            {
                //대충 누적합 내용임
                int IDX=depth+j>=m?(depth+j)-m:depth+j;
                dpA[j]=dpA[j]+pizzaA[IDX];
                //누적합이 아직 없는 값이면 set에 삽입
                set.add(dpA[j]);
                //이 누적합이 몇 개나 되는지 count
                cntA[dpA[j]]++;
            }
        }

        //피자B
        //B로 만들 수 있는 모든 합계를 구함
        for(int depth=0;depth<n;depth++)
        {
            if(depth==n-1)
            {
                //총합은 한 개만 들어가야 하므로, 따로 분기
                cntB[dpB[0]+pizzaB[n-1]]++;
                break;
            }
            for(int j=0;j<n;j++)
            {
                //대충 누적합 내용임
                int IDX=depth+j>=n?(depth+j)-n:depth+j;
                dpB[j]=dpB[j]+pizzaB[IDX];
                //이 누적합이 몇 개나 되는지 count
                cntB[dpB[j]]++;
            }
        }

        //피자 A로 만들 수 있는 합들 하나씩 꺼냄
        Iterator iter = set.iterator();
        while(iter.hasNext()) {
            int valA= (int) iter.next();
            int valB=0;
            if(wantSize-valA>=0&&cntB[wantSize-valA]!=0)
                valB=wantSize-valA;
            //피자 A가 고객이 원하는 값임
            if(valA==wantSize)
            {
                //해당 A값의 개수만큼 answer++
                for(int i=0;i<cntA[valA];i++)
                    answer++;
            }
            //피자 B가 고객이 원하는 값임
            else if(valB==wantSize)
            {
                //해당 B값의 개수만큼 answer++
                for(int i=0;i<cntB[valB];i++)
                    answer++;
            }
            //피자 A+B가 고객이 원하는 값임
            else if(valA+valB==wantSize)
            {
                //해당 A의 값의 개수 곱하기
                for(int i=0;i<cntA[valA];i++)
                {
                    //해당 B의 값의 개수
                    for(int j=0;j<cntB[valB];j++)
                        answer++;
                }
            }
        }
        System.out.println(answer);
    }
}

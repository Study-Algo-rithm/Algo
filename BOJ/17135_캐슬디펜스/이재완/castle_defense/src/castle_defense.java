import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class castle_defense{
    static class ENEMY
    {
        public int x,y,distance;
        public boolean death;
        ENEMY(int distance)
        {
            this.distance=distance;
        }
        ENEMY(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
    }
    public static int N;
    public static int M;
    public static int D;
    public static boolean isVisited[];
    public static int result[]=new int[3];
    public static ENEMY[] enemy;
    public static int answer=0;
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        D=Integer.parseInt(st.nextToken());
        isVisited=new boolean[M];

        //적의 위치를 리스트에 저장
        ArrayList<ENEMY> list=new ArrayList<>();
        for(int i=0;i<N;i++)
        {
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++)
            {
                if(st.nextToken().charAt(0)=='1')
                    list.add(new ENEMY(i,j));
            }
        }
        enemy=new ENEMY[list.size()];
        for(int i=0;i< list.size();i++)
            enemy[i]= list.get(i);

        comb(M,3,0,0);
        System.out.println(answer);
    }

    public static int getClose(ENEMY enemy, int resultY)
    {
        int r1=enemy.x;
        int c1=enemy.y;
        int r2=N;
        int c2=resultY;
        return Math.abs(r1-r2)+Math.abs(c1-c2);
    }
    public static void comb(int n,int r,int depth,int start)
    {
        //궁수 위치 조합 생성완료
        if(depth==r)
        {
            //적의 위치를 리스트로 저장
            ArrayList<ENEMY> list=new ArrayList<>();
            for(int i=0;i< enemy.length;i++)
                list.add(new ENEMY(enemy[i].x,enemy[i].y));
            int arrowKill=0;

            //적이 없을 때까지
            while(list.size()>0)
            {
                //궁수턴 (사살)
                for (int i = 0; i < 3; i++)
                {
                    ENEMY m_distance=new ENEMY(9999);
                    int mIDX=0;
                    //가장 가까운 적 탐색
                    for (int j = 0; j < list.size(); j++)
                    {
                        ENEMY now=list.get(j);
                        int distance=getClose(now,result[i]);
                        now.distance=distance;
                        //가장 가까우면
                        if(m_distance.distance>distance)
                        {
                            //가장 가까운 적 채택
                            m_distance=now;
                            mIDX=j;
                        }
                        //가장 가까운 거리가 같으면
                        else if(m_distance.distance==distance)
                        {
                            //왼쪽에 있는 적을 채택
                            if(m_distance.y> now.y)
                            {
                                m_distance=now;
                                mIDX=j;
                            }

                        }
                    }
                    //가장 가까이 있는 적이 살아있고, 사정거리 내
                    if(!list.get(mIDX).death&&list.get(mIDX).distance<=D)
                    {
                        arrowKill++; //킬수 증가
                        list.get(mIDX).death=true; //적 죽음
                    }

                }
                //적의 턴 (진격)
                for (int j = 0; j < list.size(); j++)
                {
                    //만약 죽었다면
                    if(list.get(j).death)
                    {
                        //리스트에서 제거
                        list.remove(j);
                        j--;
                    }
                    //죽지 않았다면
                    else
                    {
                        list.get(j).distance--; //궁수와 거리 한 칸 감소
                        if(++list.get(j).x==N) //적이 앞으로 한 칸 진격
                        {
                            //진격한 칸이 궁수칸이면, 적을 리스트에서 제거
                            list.remove(j);
                            j--;
                        }
                    }
                }
            }
            answer=Math.max(answer,arrowKill);
            return;
        }

        for(int i=start;i<n;i++)
        {
            if(!isVisited[i])
            {
                isVisited[i]=true;
                result[depth]=i;
                comb(n,r,depth+1,i+1);
                isVisited[i]=false;
            }
        }
    }
}

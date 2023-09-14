import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static ArrayList<Integer>[] arr;
	public static int subset[];
	public static int weight[];
	public static boolean isSelected[];
	public static int min=1000000000;
	
	public static void generateSubSet(int cnt,int start, int N,int r)
	{
		if(cnt==r)
		{
			ArrayList<Integer> subset1=new ArrayList<Integer>(); //부분집합1
			ArrayList<Integer> subset2=new ArrayList<Integer>(); //부분집합2
			for(int i=1;i<=N;i++)
				subset2.add(i);
			
			int subset_len=subset.length;
			for(int i=0;i<subset_len;i++)
			{
				if(subset[i]!=0)
				{	
					subset1.add(subset[i]); //부분집합1 생성(조합)
					subset2.remove((Integer)subset[i]); //부분집합2 생성(전체에서 부분집합1 뺌)
				
				}
			}
			
			boolean sub1_chk=dfs(subset1,subset1.get(0)); //연결되어 있는지 확인
			isSelected=new boolean[N+1];
			boolean sub2_chk=dfs(subset2,subset2.get(0)); //연결되어 있는지 확인
			isSelected=new boolean[N+1];
			
			if(sub1_chk&&sub2_chk) //부분집합이 다 연결되어 있음
			{
				int sum1=0;
				for(int i=0;i<subset1.size();i++)
				{
					int node=subset1.get(i);
					sum1+=weight[node];
				} //부분집합1의 합
				int sum2=0;
				for(int i=0;i<subset2.size();i++)
				{
					int node=subset2.get(i);
					sum2+=weight[node];
				} //부분집합2의 합
				
				int result=Math.abs(sum1-sum2); //절댓값(부분집합1의 합-부분집합2의 합)
				if(result<min)
				{
					min=result; //차이가 더 작으면 최솟값 갱신
				}
			}
		}
		else
		{
			for(int i=start;i<N;i++)
			{
				subset[cnt]=i+1;
				generateSubSet(cnt+1,i+1,N,r);
			} //부분집합 생성(조합)
		}
	}
	public static boolean dfs(ArrayList<Integer> subset, int start)
	{
		boolean check=false;
		int len=subset.size();
		
		int node=subset.get(subset.indexOf((Integer)start)); //부분집합의 start번째 요소
		isSelected[node]=true;
			
		for(int j=0;j<arr[node].size();j++)
		{
			int next=arr[node].get(j); //연결 노드
			if(!isSelected[next]) //연결 노드 아직 선택 안됨
			{
				if(subset.contains((Integer)next)) //부분집합에 있는 값임
					dfs(subset,next);
			}
		}
			
		
		
		for(int i=0;i<len;i++) //부분집합의 크기만큼 반복
		{
			if(isSelected[subset.get(i)]==true) 
			{
				check=true;
			}
			else //부분집합 중 선택 안된 요소가 있음
			{
				check=false; 
				break;
			}
		}
		return check;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		
		int N=Integer.parseInt(br.readLine()); //구역의 개수
		arr=new ArrayList[N+1]; //구역 그래프
		for(int i=0;i<N+1;i++)
			arr[i]=new ArrayList<Integer>();
		
		weight=new int[N+1]; //구역의 인구(가중치)
		subset=new int[N]; //부분집합 저장
		isSelected=new boolean[N+1]; //선택 여부
		
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<N+1;i++)
		{
			weight[i]=Integer.parseInt(st.nextToken()); //가중치 입력 (인구 수)
		}
		
		for(int i=1;i<N+1;i++)
		{
			st=new StringTokenizer(br.readLine());
			int len=Integer.parseInt(st.nextToken());
			for(int j=1;j<=len;j++)
			{
				int value=Integer.parseInt(st.nextToken());
				arr[i].add(value); //연결된 구역
			} 
		}
		
		for(int i=1;i<N;i++)
		{
			generateSubSet(0,0,N,i); //부분집합 생성
		}
		if(min!=1000000000)
			System.out.println(min); //최솟값이 변경됨(개리맨더링 가능)
		else
			System.out.println(-1); //최솟값이 변경되지 않음(개리맨더링 불가능)
	}

}
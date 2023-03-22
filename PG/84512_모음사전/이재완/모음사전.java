import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 모음사전 {
	public static char[] alphabet= {'A','E','I','O','U'}; //지정된 알파벳
	public static char answer[]=new char[5]; //정답 배열
	public static int cnt=0; //횟수
	public static char made[]=new char[5]; //현재 배열
	public static boolean out=false; //탈출 조건
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String word=br.readLine();
		solution(word);
		System.out.println(cnt);
	}
	
	public static int solution(String word)
	{
		for(int i=0;i<answer.length;i++)
		{
			made[i]='X'; //초기값 전부 X
			if(i>=word.length())
				answer[i]='X'; //정답을 넘는 위치는 X로 초기화
			else
				answer[i]=word.charAt(i); //정답을 answer 배열에 입력
		}

		dfs(0);
		return cnt;
	}
	
	public static void dfs(int idx)
	{
		if(idx>=5) //다섯 글자를 넘으면
			return;
		else //다섯 글자 내
		{
			for(int i=0;i<5;i++) //A,E,I,O,U 순회
			{
				if(!out) 
				{
					made[idx]=alphabet[i];
					cnt++;
					if(compare()) //현재값 == 정답
						out=true; //out을 true로
					else //현재값 != 정답
						dfs(idx+1); //다음 위치로 이동
				}
				else
					return;
			}
			made[idx]='X';
		}
	}
	//현재값이 정답과 일치하는지 확인
	public static boolean compare()
	{
		for(int i=0;i<5;i++)
		{
			if(made[i]!=answer[i])
				return false;
		}
		return true;
	}
	
	public static void print()
	{
		for(int i=0;i<made.length;i++)
			System.out.print(made[i]);
		System.out.println();
	}
}

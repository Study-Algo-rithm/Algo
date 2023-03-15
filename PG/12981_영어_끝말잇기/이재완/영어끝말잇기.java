import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class 영어끝말잇기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());

		String[] words= {"hello", "one", "even", "never", "now", "world", "draw"};

		System.out.println(Arrays.toString(solution(n,words)));
		
	}
	public static int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        int len=words.length;
        
        HashSet<String> used=new HashSet<>();
        used.add(words[0]);
        char word_last=words[0].charAt(words[0].length()-1);
        int who=1;
        int cycle=1;
        
        for(int i=1;i<len&&words[i].length()>1;i++) //한 글자 이상임
        {
        	if((who=i%n+1)==1) //몇 번 사람인가 
        		cycle++; //1번 사람이면 싸이클++
        	
        	//이전 마지막 글자와 현재 첫 글자 일치 & 중복x
        	if(word_last==words[i].charAt(0)&&used.add(words[i])) //끝말잇기 가능
        		word_last=words[i].charAt(words[i].length()-1); //마지막 글자를 현재 첫 글자로 갱신
        	else //불가능
        	{
        		answer[0]=who;
        		answer[1]=cycle;
        		break;
        	}
        	
        }
        
        return answer;
    }

}

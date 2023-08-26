import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 괄호추가하기 {
	public static char arr[];
	public static char[] SBracket= {'(',' '};
	public static char[] EBracket= {')',' '};
	public static int max=Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		String input=br.readLine();
		if(N==1)
		{
			System.out.println(input);
			return;
		}
		arr=new char[N*2+1];

		for(int i=1,j=0;i<arr.length;i+=2,j++)
			arr[i]=input.charAt(j);

		dfs(0,0,arr.length);
		System.out.println(max);
	}
	public static void dfs(int idx, int SIdx,int size) {
		if(idx+6==size)
		{
			operate(arr);
			return;
		}
		for(int i=0;i<2;i++)
		{
			if(idx==SIdx)
			{
				arr[idx]=SBracket[i];
				arr[idx+6]=EBracket[i];
				if(SBracket[i]=='(')
					dfs(idx+1,SIdx+8,size);
				else
					dfs(idx+1,SIdx+4,size);

			}
			else
			{
				dfs(idx+1,SIdx,size);
				break;
			}
		}
	}
	public static void operate(char[] arr) {
		String str="";
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]!=0&&arr[i]!=' ')
				str+=arr[i];
		}

		char[] formula=str.toCharArray();
		int result=formula[0]-'0';
		int start=0;
		if(formula[0]=='(')
		{
			result=account(formula[2],formula[1]-'0',formula[3]-'0');
			start=4;
		}

		for(int i=start;i<formula.length-1;i++)
		{
			int num=formula[i+1]-'0';
			int temp=0;

			if(formula[i]=='*'||formula[i]=='+'||formula[i]=='-'||formula[i]=='/')
			{
				if(formula[i+1]=='(')
				{
					int num1=formula[i+2]-'0';
					int num2=formula[i+4]-'0';
					num=account(formula[i+3],num1,num2);
					temp=5;
				}
				result=account(formula[i],result,num);
			}

			i+=temp;
		}
		max=Math.max(max,result);
	}
	public static int account(char operator,int a, int b)
	{
		int result=0;
		if(operator=='*')
			result=a*b;
		else if(operator=='+')
			result=a+b;
		else if(operator=='-')
			result=a-b;
		else if(operator=='/')
			result=a/b;

		return result;
	}
}

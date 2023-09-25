import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.BitSet;

public class Main {
    public static BitSet bitset;
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int max=0;

        for(int i=0;i<n;i++)
            max=max*10+9;

        bitset=new BitSet(max+1);
        bitset.set(0);
        bitset.set(1);

        //에라토스테네스의 체 (소수인지 판단)
        for(int i=0;i<Math.sqrt(max+1);i++)
        {
            if(bitset.get(i))
                continue;
            for(int j=i*i;j<max+1;j=j+i)
                bitset.set(j);
        }

        for(int i=2;i<=7;i++)
        {
            if(i%2!=0||i==2)
                dfs(1,n,i);
        }
    }
    public static void dfs(int depth, int n,int num)
    {
        if(bitset.get(num))
            return;
        //결과 생성
        if(depth==n)
        {
            System.out.println(num);
            return;
        }

        for(int i=1;i<=9;i+=2)
            dfs(depth+1,n, num*10+i);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main{
    static int n;
    static char line [];
    static int ans;
    static List <Character> oplist;
    static List <Integer> numlist;


    static int calc (int v, int i, char op) {
        int temp = v;
        if(op == '+') {
            temp += i;
            return temp;
        }
        if(op == '-') {
            temp -= i;
            return temp;
        }
        if(op == '*') {
            temp *= i;
            return temp;
        }
        return -1;
    }
    // 연산을 하는 함수


    static void dfs(int value, int idx ) {// 값과 연산할 순서
        if(idx >= oplist.size()) {
            ans = Math.max(value, ans);// 최대값 비교
            return;
        }// 범위 넘어가면 반환


        int temp = calc(value,numlist.get(idx+1),oplist.get(idx));// 왼쪽부터 차례대로 연산한다.
        dfs(temp,idx+1);// 연산한 값을 가지고 다음 dfs 로 넘어감

        if(idx+1 <oplist.size()) {//괄호를 현재 인덱스와 다음 인덱스를 치는게 아니라 '다음 인덱스'와 '다다음 인덱스'를 친다.
            // 그러기 위해서는 다다음 인덱스가 넘어가지 않는지 확인해준다. idx + 1이 oplist의 크기보다 작으면 된다.
            // 어? idx+2는 그럼 넘어갈 수 있잖아 그건 위에 범위 넘어가변 반환 이라고 주석친 부분에서 잡아준다.
            int temp2 = calc(numlist.get(idx+1), numlist.get(idx+2), oplist.get(idx+1));
            dfs(calc(value,temp2,oplist.get(idx)),idx+2);
        }

    }
    //dfs 돌리기
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        String templine = bf.readLine();

        ans = Integer.MIN_VALUE;
        oplist =new ArrayList<>();
        numlist =new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char temp =templine.charAt(i);
            if(temp== '+' || temp== '-' || temp== '*' ) {
                oplist.add(temp);
            }else {
                numlist.add(temp-'0');
            }
        }

        dfs(numlist.get(0), 0);

        System.out.println(ans);
    }

}
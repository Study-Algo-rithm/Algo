import java.util.LinkedList;
import java.util.ArrayList;
class Solution {
//     static int [] visited;
//     static int [] output;
//     static long idx;
//     static int [] ans;
    
//     public int[] solution(int n, long k) {
//         int[] answer = {};
       
//         idx = 1;
//         visited = new int [n];
//         output = new int [n];
//         ans = new int [n];
//         dfs(n,k,0);
//         return ans;
//     }
    
//     public void dfs(int n, long k, int dep){
//         if(dep == n){
//             // for (int i = 0; i < n; i++)
//             //     System.out.print(output[i] + " ");
//             // System.out.println("idx = "+idx);
//             if(idx == k){
//                 ans = output.clone();
//             }
//             idx ++;
//             return;
//         }
        
//         for (int i = 0; i < n; i++) {
//             if (visited[i] != 1) {
//                 visited[i] = 1;
//                 output[dep] = i+1;
//                 dfs(n, k, dep+1);
//                 visited[i] = 0;
//             }
//         }
//     }
    
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        LinkedList<Integer> list = new LinkedList<>();
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            factorial *= i;
        }

        int i = 0;
        long remain = k - 1;
// k가 1부터 시작하므로

        while (i < n) {
            factorial = factorial / (n - i);
            long value = remain / factorial;
            answer[i++] = list.get((int)value);
            list.remove((int)value);
            remain = remain % factorial;
        }

        return answer;
//         ArrayList<Integer> al = new ArrayList<>();
//         int[] result = new int[n];
//         int fn = 1;
//         for(int i = 1;  i <= n; i++) {
//             fn *= i;
//             al.add(i);
//         }
//         k--;
        
//         int idx = 0;
//         while(n>0) {
//             fn /= n;            //n번 째 자리수가 정해짐
//             result[idx++] = al.get((int) (k/fn));
//             al.remove((int)k/fn);
//             k %= fn;
//             n--;
//         }
//         return result;
        
    }
}
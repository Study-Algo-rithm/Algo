import java.util.LinkedList;
import java.util.Queue;
class Solution {
    static int[][] map;
    public int solution(int n, int[][] wires) {
        int answer = n;
        map= new int[n+1][n+1];
        
        for(int i=0; i<wires.length; i++){
            map[wires[i][0]][wires[i][1]]=1;
            map[wires[i][1]][wires[i][0]]=1;
        }
        
        int a, b;
        for(int i=0; i<wires.length; i++){
            a= wires[i][0];
            b= wires[i][1];

            map[a][b]=0;
            map[b][a]=0;

            answer= Math.min(answer, bfs(n, a));
            
            map[a][b]=1;
            map[b][a]=1;
        }
        
        return answer;
    }
    
    public int bfs(int n, int start){
        int[] v= new int[n+1];
        int cnt=1;
        
        Queue<Integer> queue= new LinkedList<>();
        queue.offer(start);
        
        while(!queue.isEmpty()){
            int now= queue.poll();
            v[now]= 1;
            
            for(int i=1; i<=n; i++){ 
                if(v[i]==1) continue;
                if(map[now][i]==1) {
                    queue.offer(i);
                    cnt++;
                }
            }
        }
        return (int)Math.abs(n-2*cnt); 
    }
}
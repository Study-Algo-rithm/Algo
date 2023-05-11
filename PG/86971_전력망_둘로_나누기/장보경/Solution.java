import java.util.*;

class Solution {
    static int answer;
    static HashMap<Integer, ArrayList<Integer>> hm;

    public static int solution(int n, int[][] wires) {
        hm = new HashMap<>();
        for (int i=0; i<n-1; i++){
            int x = wires[i][0];
            int y = wires[i][1];

            ArrayList<Integer> al1 = hm.getOrDefault(x, new ArrayList<>());
            al1.add(y);
            hm.put(x, al1);

            ArrayList<Integer> al2 = hm.getOrDefault(y, new ArrayList<>());
            al2.add(x);
            hm.put(y, al2);
        }

        answer = 101;
        disconnect(n, wires);

        return answer;
    }

    static void disconnect(int n, int[][] wires){
        for (int i=0; i<n-1; i++){
            int x = wires[i][0];
            int y = wires[i][1];

            int cnt1 = chkConnection(n, x, y);
            int cnt2 = chkConnection(n, y, x);

            answer = Math.min(answer, Math.abs(cnt1-cnt2));
        }
    }

    static int chkConnection(int n, int x, int y){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(x);

        boolean[] chkTower = new boolean[n+1];
        chkTower[x] = true;
        chkTower[y] = true;

        int cnt = 0;
        while (!q.isEmpty()){
            int idx = q.poll();
            
            ArrayList<Integer> al = hm.get(idx);
            for (int i=0; i<al.size(); i++){
                int value = al.get(i);
                if (chkTower[value]) continue;
                
                chkTower[value] = true;
                q.add(value);
            }
            cnt++;
        }

        return cnt;
    }
}

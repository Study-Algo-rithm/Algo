import java.util.*;
class Solution {
    static ArrayList<Edge>[] al;
    static boolean[] visited;
    static int[] town;
    static int cnt;

    public static int solution(int N, int[][] road, int K) {
        int answer = 0;

        al = new ArrayList[N+1];
        for(int i=0; i<=N; i++) al[i] = new ArrayList<>();
        
        for(int i=0; i<road.length; i++){
            int x = road[i][0];
            int y = road[i][1];
            int w = road[i][2];

            al[x].add(new Edge(y, w));
            al[y].add(new Edge(x, w));
        }

        town = new int[N+1];
        for (int i=0; i<N+1; i++){
            town[i] = Integer.MAX_VALUE;
        }
        visited = new boolean[N+1];
        
        getDist(N);
        canDelivery(N, K);

        answer = cnt;
        return answer;
    }

    // 최소 거리 구해서 town배열에 넣기
    static void getDist(int N){
        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.add(new Edge(1, 0));

        while (!q.isEmpty()){
            Edge edge = q.poll();
            int pos = edge.pos;
            int weight = edge.weight;

            visited[pos] = true;
            town[pos] = Math.min(town[pos], weight);

            for (Edge e: al[pos]){
                if (!visited[e.pos]){
                    q.add(new Edge(e.pos, weight+e.weight));
                }
            }
        }
    }

    // K시간 이하 걸리는 마을 수
    static void canDelivery(int N, int K){
        for (int i=1; i<=N; i++){
            if (town[i] <= K){
                cnt++;
            }
        }
    }
}

class Edge implements Comparable<Edge>{
    int pos;
    int weight;

    Edge(int pos, int weight){
        this.pos = pos;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}

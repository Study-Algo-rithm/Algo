import java.util.*;

class Solution {
    static String[][] arr;
    static boolean[][] visited;
    static int connCnt;
    static boolean change;

    public static int solution(int m, int n, String[] board) {
        int answer = 0;

        arr = new String[m][n];
        for (int i=0; i<m; i++){
            String[] tmp = board[i].split("");
            for (int j=0; j<n; j++){
                arr[i][j] = tmp[j];
            }
        }

        connCnt = 0;
        change = true;
        while (change){
            change = false;
            visited = new boolean[m][n];
            for (int i=0; i<m-1; i++){
                for (int j=0; j<n-1; j++){
                    if (!arr[i][j].equals(".")){
                    	bfs(m, n, new Position(i, j), arr[i][j]);
                    }
                }
            }
            removeBlock(m, n);
        }
        answer = connCnt;

        return answer;
    }

    static int[] X = {0, 1, 1};
    static int[] Y = {1, 0, 1};

    public static void bfs(int m, int n, Position p, String name){
        Queue<Position> q = new ArrayDeque<>();
        q.add(p);

        int cnt = 0;
        while (!q.isEmpty()){
            Position now = q.poll();
            int x = now.x;
            int y = now.y;
            
            for (int i=0; i<3; i++){
                int nx = x + X[i];
                int ny = y + Y[i];

                if (nx>=0 && ny>=0 && nx<m && ny<n && arr[nx][ny].equals(name)){
                    cnt++;
                }
            }

            if (cnt == 3){
                visited[x][y] = true;
                for (int i=0; i<3; i++){
                    int nx = x + X[i];
                    int ny = y + Y[i];

                    visited[nx][ny] = true;
                }
                change = true;
            }
        }
    }

    public static void removeBlock(int m, int n){
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (visited[i][j] && !arr[i][j].equals(".")){
                    arr[i][j] = ".";
                    connCnt++;
                }
            }
        }
        move(m, n);
    }

    public static void move(int m, int n){
        for (int i=0; i<n; i++){
            for (int j=m-1; j>=0; j--){
                if (arr[j][i].equals(".")){
                    int tmpX = j;
                    while (findEmpty(tmpX, i) != -1){
                        int idx = findEmpty(tmpX, i);

                        arr[tmpX][i] = arr[idx][i];
                        arr[idx][i] = ".";
                        tmpX = idx;
                    }
                }
            }
        }
    }

    public static int findEmpty(int x, int y){
        for (int i=x-1; i>=0; i--){
            if (!arr[i][y].equals(".")){
                return i;
            }
        }
        return -1;
    }
}

class Position{
    int x;
    int y;

    Position(int x, int y){
        this.x = x;
        this.y = y;
    }
}



/*** bfs 안 쓴 버전 ***/
// public static int solution(int m, int n, String[] board) {
//         int answer = 0;

//         arr = new String[m][n];
//         for (int i=0; i<m; i++){
//             String[] tmp = board[i].split("");
//             for (int j=0; j<n; j++){
//                 arr[i][j] = tmp[j];
//             }
//         }

//         connCnt = 0;
//         change = true;
//         while (change){
//             change = false;
//             visited = new boolean[m][n];
            
//             for (int i=0; i<m-1; i++){
//                 for (int j=0; j<n-1; j++){
//                     if (!arr[i][j].equals(".")){
//                         if (chk(i, j)){
//                         	visited[i][j] = true;
//                         	visited[i][j+1] = true;
//                         	visited[i+1][j] = true;
//                         	visited[i+1][j+1] = true;
//                         	change = true;
//                         }
                        
//                     }
//                 }
//             }
//             removeBlock(m, n);
//         }
//         answer = connCnt;

//         System.out.println(connCnt);

//         return answer;
//     }
    
//     public static boolean chk(int x, int y) {
//     	String name = arr[x][y];
//     	if(arr[x][y+1].equals(name) && arr[x+1][y].equals(name) && arr[x+1][y+1].equals(name)) {
//     		return true;
//     	}
//     	return false;
//     }

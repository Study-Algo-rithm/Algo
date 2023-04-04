import java.util.*;

class Solution {
    static int cntOne, cntZero;
    static boolean[][] visited;
    
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        int len = arr.length;
        visited = new boolean[len][len];

        chkSameNum(arr, len, 0, 0);
        int idx = len/2;
        while (idx > 0){  // 나누기2씩 해서 쪼개기
            for (int i=0; i<=len-idx; i+=idx){
                for (int j=0; j<=len-idx; j+=idx){
                    chkSameNum(arr, idx, i, j);
                }
            }
            idx /= 2;
        }

        // 압축되지 않은 수 카운팅
        for (int i=0; i<len; i++){
            for (int j=0; j<len; j++){
                if (visited[i][j]) continue;
                if (arr[i][j] != 0){
                    cntOne++;
                } else{
                    cntZero++;
                }
            }
        }

        answer[0] = cntZero;
        answer[1] = cntOne;

        return answer;
    }

    // 압축하기
    static void chkSameNum(int[][] arr, int len, int r, int c){
        int num = arr[r][c];

        for (int i=r; i<r+len; i++){
            for (int j=c; j<c+len; j++){
                // 이미 방문한 배열이거나 첫번째 숫자와 다른 경우
                if (visited[i][j] || arr[i][j]!=num){
                    return;
                }
            }
        }

        for (int i=r; i<r+len; i++){
            for (int j=c; j<c+len; j++){
                visited[i][j] = true;
            }
        }
        if (num != 0){
            cntOne++;
        }else{
            cntZero++;
        }
    }
}

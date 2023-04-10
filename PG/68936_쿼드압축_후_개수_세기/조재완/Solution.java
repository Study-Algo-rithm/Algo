class Solution {
    static int[] answer = new int [2];
    
    public int[] solution(int[][] arr) {
        int Tsize = arr.length;
        dfs(arr,0,0,Tsize);
        
        return answer;
    }
    
    public static boolean check(int R, int C, int size, int [][] arr){
         for(int i = R; i < R+size; i++){
            for(int j = C; j < C+size; j++){
                if(arr[R][C] != arr[i][j]){
                    return false;
                }
            }
        }
        return true;
     }
    
     public static void dfs(int[][] arr, int startR, int startC, int size){
         if(check(startR, startC, size, arr)){
             answer[arr[startR][startC]]++;
             return;
         }
         
         dfs(arr, startR, startC, size/2);
         dfs(arr, startR+size/2, startC, size/2);
         dfs(arr, startR, startC+size/2, size/2);
         dfs(arr, startR+size/2, startC+size/2, size/2);
     }
}
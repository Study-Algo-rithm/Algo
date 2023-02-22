class Solution {
    public int solution(int n) {
        int[] arr = new int[n];
        arr[0] = 1;  // 세로로 배치
        arr[1] = 2;  // 가로로 배치
        
        // 이전에 저장된 값으로 n까지 계산
        for (int i=2; i<n; i++){
            arr[i] = (arr[i-2]+arr[i-1]) % 1_000_000_007;
        }

        return arr[n-1];
    }
}

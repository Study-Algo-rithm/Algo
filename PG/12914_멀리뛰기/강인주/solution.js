function solution(n) {
    
  arr = new Array(n+1) // (n=1, 1) (n=2, 2)
  arr[0] = 0;
  arr[1] = 1;
  arr[2] = 2;
  
  // BigInt : 2**53 - 1보다 큰 정수를 표현할 수 있도록 하는 내장객체
  if (n > 2) {
      for (let i=3; i<n+1; i++) {
          arr[i] = BigInt(arr[i-1]) + BigInt(arr[i-2]);
      }
      return arr[n] % BigInt(1234567)
  }
  
  return arr[n]
}
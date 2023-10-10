function solution(n) {
  const snail = new Array(n);
  for (let i=0; i<n; i++) {
      snail[i] = new Array(i+1).fill(0);
  }
  
  let direction = 0; // 아래 방향으로 시작
  let [i, j] = [-1, 0]; // 시작 위치
  let value = 0; // 시작 값
  
  while (n > 0) {
      // 1. 아래 방향
      if (direction === 0) {
          for (let a=0; a<n; a++) {
              i += 1;
              value += 1;
              snail[i][j] = value;
          }
      }
      // 2. 오른쪽 방향
      else if (direction === 1) {
          for (let a=0; a<n; a++) {
              j += 1;
              value += 1;
              snail[i][j] = value;
          }
      }
      // 3. 위쪽 방향
      else {
          for (let a=0; a<n; a++) {
              j -= 1;
              i -= 1;
              value += 1;
              snail[i][j] = value;
          }
      }
      direction = (direction + 1) % 3;
      n -= 1;
  }
  
  const ans = snail.reduce((acc, cur) => acc.concat(cur), []);
  
  return ans;
}
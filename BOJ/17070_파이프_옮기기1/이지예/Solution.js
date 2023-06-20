const data = require("fs").readFileSync("/dev/stdin").toString().trim().split("\n");
const n = +data[0];
const map = [];
for (let i = 1; i <= n; i++) {
  map[i - 1] = data[i].trim().split(" ");
}
const dp = Array.from({ length: n }, () => Array.from({ length: n }, () => Array(3).fill(0)));
for (let i = 1; i < n; i++) {
  if (map[0][i] == 1) break;
  dp[0][i] = [1, 0, 0];
}
for (let i = 1; i < n; i++) {
  for (let j = 1; j < n; j++) {
    if (map[i][j] == 1) continue;
    dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][1];
    dp[i][j][1] =
      map[i - 1][j] == 1 || map[i][j - 1] == 1
        ? 0
        : dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
    dp[i][j][2] = dp[i - 1][j][1] + dp[i - 1][j][2];
  }
}
let answer = dp[n - 1][n - 1].reduce((a, b) => a + b);
console.log(answer);

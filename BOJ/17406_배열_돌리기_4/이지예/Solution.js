function sol(input) {
  const [N, M, K] = input[0].split(" ").map(Number);
  let boards;
  let answer = Number.MAX_SAFE_INTEGER;
  const rotateOperations = input.slice(1 + N).map((str) => str.split(" ").map(Number)); // 회전연산을 담아둔다.

  dfs(0, []);

  return answer;
  // 코드 실행은 여기서 끝난다. 밑에부터는 구현한 함수다.

  function dfs(L, orders) {
    if (orders.length === K) {
      boards = input.slice(1, 1 + N).map((row) => row.split(" ").map(Number));
      // 경우의 수의 원소 갯수가 K개면 회전 연산을 수행할 것이므로, 배열 A를 복사한다.

      orders.forEach((order) => rotate2DMatrixBy1Step(...rotateOperations[order])); // 경우의수 orders의 원소를 순회하며 회전 연산을 수행한다.

      boards.forEach((row) => {
        const min = row.reduce((acc, val) => acc + val, 0);
        answer = Math.min(answer, min);
      }); // 배열 A의 행의 합 최솟값을 갱신한다.
      return;
    }

    for (let i = 0; i < K; i++) {
      if (orders.includes(i)) continue;
      dfs(L + 1, [...orders, i]);
    }
  }

  function rotate2DMatrixBy1Step(r, c, s) {
    const n = 2 * s + 1;
    const startR = r - s - 1;
    const startC = c - s - 1;
    // startR, startC는 배열A에서 회전을 시작할 행과 열이다.
    // 순서가 헷갈려서, 새로운 배열 result를 n*n 크기로 선언했다.
    // 여기에 회전 결과를 담아두고, board로 복사할 예정이다.

    const result = Array.from({ length: n }, () => new Array(n).fill(0));
    for (let i = 0; i < s; i++) {
      let sr = i,
        sc = i;
      // 회전 연산 당 s회만큼 반복해야 배열 내부를 모두 회전시킬 수 있다.
      // sr,sc는 시작할 지점이며, boards에서 실행해야 하므로 startR, startC와 연계한다.
      // 또한 result는 n*n크기이므로 (sr,sc)에 회전된 모습을 저장하게 된다.
      for (let j = 0; j < 4; j++) {
        while (sr === i && sc >= i && sc < n - 1 - i) {
          result[sr][sc + 1] = boards[startR + sr][startC + sc];
          sc++;
        } // 윗쪽 변 이동

        while (sr >= i && sr < n - 1 - i && sc === n - 1 - i) {
          result[sr + 1][sc] = boards[startR + sr][startC + sc];
          sr++;
        } // 오른쪽 변 이동

        while (sr === n - 1 - i && sc > i && sc <= n - 1 - i) {
          result[sr][sc - 1] = boards[startR + sr][startC + sc];
          sc--;
        } // 아랫 변 이동

        while (sr > i && sr <= n - 1 - i && sc === i) {
          result[sr - 1][sc] = boards[startR + sr][startC + sc];
          sr--;
        } // 왼쪽 변 이동
      }
    }
    result[s][s] = boards[startR + s][startC + s];
    // (r,c) 지점은 회전을 수행하지 않으므로 그대로 복사한다.

    for (let i = 0; i < n; i++) {
      for (let j = 0; j < n; j++) {
        boards[startR + i][startC + j] = result[i][j];
      }
    } // 회전 결과 배열을 boards 배열로 복사해주면 된다.
  }
}

const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input =
  process.platform === "linux"
    ? fs.readFileSync(filePath).toString().trim().split("\n")
    : fs
        .readFileSync(__dirname + "/input.txt")
        .toString()
        .trim()
        .split("\n");

console.log(sol(input));

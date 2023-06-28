const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
// const newline = process.platform === "linux" ? "\n" : "\r\n";
let input =
  process.platform === "linux"
    ? fs.readFileSync(filePath).toString().trim().split("\n")
    : fs
        .readFileSync(__dirname + "/input.txt")
        .toString()
        .trim()
        .split("\n");

const N = Number(input[0]);
const people = input[1].split(" ").map(Number);
const allPeople = people.reduce((sum, val) => sum + val);
let answer = allPeople;
const baseArr = Array.from({ length: N + 1 }, () => []);
for (let i = 2; i < N + 2; i++) {
  let nowInput = input[i].split(" ").map(Number);
  let len = nowInput[0];
  for (let j = 1; j <= len; j++) {
    baseArr[i - 1].push(nowInput[j]);
  }
}
//1~N-1개 부분집합 고르기
const subset = (ind, arr) => {
  if (ind > N) {
    if (arr.length > 0 && arr.length !== N) {
      let resultA = false;
      let resultB = false;
      //선택 or 비선택 연결 체크
      const checkConnect = (arr, linkedArr, num, AB) => {
        linkedArr.push(num);
        if (arr.length === linkedArr.length) {
          if (AB) resultA = true;
          else resultB = true;
          return;
        }
        let arrLen = baseArr[num].length;
        for (let i = 0; i < arrLen; i++) {
          if (arr.includes(baseArr[num][i]) && !linkedArr.includes(baseArr[num][i])) {
            checkConnect(arr, linkedArr, baseArr[num][i], AB);
          }
        }
      };

      const notArr = [];
      for (let i = 1; i <= N; i++) {
        if (!arr.includes(i)) notArr.push(i);
      }

      checkConnect(arr, [], arr[0], true);
      checkConnect(notArr, [], notArr[0], false);
      //차 구하기
      if (resultA && resultB) {
        let A = 0;
        let B = 0;
        for (let i = 1; i <= N; i++) {
          if (!arr.includes(i)) A += people[i - 1];
          else B += people[i - 1];
        }
        if (Math.abs(A - B) < answer) answer = Math.abs(A - B);
      }
    }
    return;
  }
  const arrNow = [...arr];
  arrNow.push(ind);
  subset(ind + 1, arrNow);
  subset(ind + 1, arr);
};

subset(1, []);

answer === allPeople ? console.log(-1) : console.log(answer);

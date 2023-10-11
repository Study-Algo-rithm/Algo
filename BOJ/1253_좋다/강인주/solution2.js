let fs = require('fs');
// let input = fs.readFileSync('/dev/stdin').toString().split('\n');
// 배열로 값을 받음
let input = fs.readFileSync('input.txt').toString().split('\n');

const N = Number(input[0]);
let numbers = input[1].split(' ');
numbers = numbers.map((s) => Number(s));

function solution(N, numbers) {

  let ans = 0; // 좋다 개수

  numbers.sort((a, b) => a - b); // 오름차순 정렬

  // 해당 수를 제외한 두 수를 합해서 비교
  for (let i=0; i<N; i++) {
    const target = numbers[i];
    let [start, end] = [0, N-1];

    while (start < end) {
      if (numbers[start] + numbers[end] === target) { // 좋다 수 판별하기
        if (i === start) { // 해당 수임
          start += 1;
        } else if (i === end) { // 해당 수임
          end -= 1;
        } else { // 해당 수가 아닌 경우
          ans += 1;
          break; // while 문 탈출
        }
      } else if (numbers[start] + numbers[end] > target) {
        end -= 1;
      } else {
        start += 1;
      }
    }
  }

  console.log(ans);
}

solution(N, numbers);
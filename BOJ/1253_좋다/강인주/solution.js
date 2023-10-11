let fs = require('fs');
// let input = fs.readFileSync('/dev/stdin').toString().split('\n');
// 배열로 값을 받음
let input = fs.readFileSync('input.txt').toString().split('\n');

const N = Number(input[0]);
let numbers = input[1].split(' ');
numbers = numbers.map((s) => Number(s));

function BinarySearch(arr, target, start, end) {
  while (start <= end) {
    const mid = Math.floor((start + end) / 2);

    if (arr[mid] === target) {
      return mid
    } else if (arr[mid] > target) {
      end = mid - 1;
    } else {
      start = mid + 1;
    }
  }
  return false
}

function solution(N, numbers) {
  let ans = 0;
  
  for (let i=0; i<N; i++) {
    let sumList = [];
    for (let j=0; j<N-1; j++) {
      if (j === i) continue;
      for (let k=j+1; k<N; k++) {
        if (k === i) continue;
        sumList.push(numbers[j] + numbers[k]);
      }
    }
    sumList.sort((a, b) => a - b);
    sumList = [...new Set(sumList)];
    // console.log(sumList)

    BinarySearch(sumList, numbers[i], 0, sumList.length-1) !== false ? ans += 1 : null;
  }

  console.log(ans);
}

solution(N, numbers);
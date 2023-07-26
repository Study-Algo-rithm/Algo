function solution(targets) {
  let answer = 0;

  targets.sort((a, b) => {
    //큰 수 같으면 작은 수 오름차순 정렬
    if (a[1] == b[1]) {
      return a[0] - b[0];
    }
    //큰 수 오름차순 정렬
    return a[1] - b[1];
  });

  let cut = -1;

  for (let i = 0; i < targets.length; i++) {
    let left = targets[i][0];
    let right = targets[i][1];
    if (left >= cut) {
      answer++;
      cut = right;
    }
  }
  return answer;
}
console.log(
  solution([
    [4, 5],
    [4, 8],
    [10, 14],
    [11, 13],
    [5, 12],
    [3, 7],
    [1, 4],
  ])
); //3

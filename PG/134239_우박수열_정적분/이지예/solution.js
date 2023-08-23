function solution(k, ranges) {
  const answer = [];
  const [y, accr] = [[k], [0]];

  //콜라츠 추측으로 y값 생성하기
  while (k > 1) {
    if (k % 2 === 0) k /= 2;
    else k = 3 * k + 1;
    y.push(k);
  }

  const last = y.length - 1;

  //누적 정적분 계산해서 accr에 넣기
  for (let i = 1; i <= last; i++) {
    accr[i] = accr[i - 1] + (y[i - 1] + y[i]) / 2;
  }

  //정적분을 구하고자 하는 배열의 요소를 반복문을 통해 모두 탐색
  for (const range of ranges) {
    //시작과 끝 x값 구하기
    const [x1, x2] = [range[0], last + range[1]];

    //시작값이 끝값보다 크면 -1
    if (x1 > x2) answer.push(-1);
    else answer.push(accr[x2] - accr[x1]); //시작값과 끝값 사이의 누적 정적분 값을 반환
  }
  return answer;
}

console.log(
  solution(5, [
    [0, 0],
    [0, -1],
    [2, -3],
    [3, -3],
  ])
); //[33.0,31.5,0.0,-1.0]

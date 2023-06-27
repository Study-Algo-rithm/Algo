function solution(N, A, B) {
  let answer = 1;

  for (; N >= 2; parseInt(N / 2)) {
    //A랑 B의 차가 1 나더라도, 대진상대가 아닐 경우도 고려해야 했음.
    if (Math.abs(A - B) === 1 && parseInt((A + 1) / 2) === parseInt((B + 1) / 2)) break;
    A = parseInt((A + 1) / 2);
    B = parseInt((B + 1) / 2);
    answer++;
  }

  return answer;
}
console.log(solution(8, 4, 7)); //3

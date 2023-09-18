function solution(storey) {
  let stone = 0; // 마법의 돌 개수
  let cur = storey;

  while (cur > 0) {
    let remain = cur % 10;
    if (remain < 5) {
      stone += remain;
    } else if (remain > 5) {
      stone += 10 - remain;
      cur += 10;
    } else { // 나머지가 5인 경우
      if (Math.floor(cur / 10) % 10 > 4) cur += 10; // 다음 숫자가 5이상이면 10만큼 더해주기
      stone += remain;
    }
    cur = Math.floor(cur / 10);
  }
  return stone
}

console.log(solution(455));
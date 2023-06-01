function solution(brown, yellow) {
  const answer = [];
  const sum = brown + yellow;

  for (let height = 3; height < sum; height++) {
    // 가운데 노란색 있으려면 최소높이가 3이 돼야됨
    if (sum % height === 0) {
      // 높이 * 너비가 카펫 수의 합이니까, 높이로 설정할 수 있는 숫자인가?
      let width = sum / height; //높이 설정 됐으면 너비도 정해줌

      if ((height - 2) * (width - 2) === yellow) {
        // 테두리 1 줄씩 제외한 카펫 격자 수가 노랑 카펫 격자 수인가?
        answer.push(width);
        answer.push(height);
        break;
      }
    }
  }

  return answer;
}

console.log(solution(10, 2));
console.log(solution(8, 1));
console.log(solution(24, 24));

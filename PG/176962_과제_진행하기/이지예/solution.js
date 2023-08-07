function solution(plans) {
  const answer = [];
  const plan = plans;
  //분단위 숫자로 변경하기
  for (let i of plan) {
    i[1] = Number(i[1].slice(3, 5)) + Number(i[1].slice(0, 2) * 60);
  }
  //시작시간 오름차순 정렬
  plan.sort((a, b) => a[1] - b[1]);

  let time = 0;
  let remain = null;
  let stack = [];
  //오름차순 제일 첫 요소를 현재 시간으로 설정
  time = plans[0][1];

  while (time <= 100000) {
    if (remain !== null) {
      if (remain[2] === 0) {
        answer.push(remain[0]);
        remain = null;
        if (stack.length > 0) {
          remain = stack.pop();
        }
      }
    }
    if (remain === null && plan.length === 0 && stack.length === 0) {
      break;
    }
    if (plan.length > 0) {
      if (time === plan[0][1]) {
        if (remain != null) {
          stack.push(remain);
          remain = null;
        }
        remain = plan.shift();
      }
      time++;
      if (remain !== null) {
        remain[2] -= 1;
      }
    } else {
      //개선한 부분
      if (remain !== null) {
        answer.push(remain[0]);
        while (stack.length > 0) {
          answer.push(stack.pop()[0]);
        }
        break;
      }
    }
  }

  return answer;
}
console.log(
  solution([
    ["science", "12:40", "50"],
    ["music", "12:20", "40"],
    ["history", "14:00", "30"],
    ["computer", "12:30", "100"],
  ])
);

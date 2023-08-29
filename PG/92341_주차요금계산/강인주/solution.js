function solution(fees, records) {
  const [baseT, baseF, unitT, unitF] = fees;
  
  function calculate(time) {
      if (time <= baseT) return baseF;
      return baseF + Math.ceil((time - baseT) / unitT) * unitF; // 초과한 시간이 단위 시간으로 나누어 지지 않으면 올림하기
  }
  
  let newRecords = records.map((value) => value.split(' ')); // 문자열의 입출차 기록을 배열로 저장
  newRecords.sort((a, b) => a[1] - b[1]); // 차량 번호를 오름차순으로 정렬
  // console.log(newRecords);
  
  let answer = {};
  let idx = 0;
  let stack = []; // In 이면 스택에 넣고, Out이면 스택에서 빼기
  while (idx < newRecords.length) {
      let [minute, car, content] = newRecords[idx];
      // console.log(minute, car, content);
      minute = Number(minute.slice(0, 2))*60 + Number(minute.slice(3, 5)); // 시간을 분으로 환산
      if (stack.length === 1 && stack[0][1] !== car) { // stack에 있는 차량과 다른 차량이 들어오면
          let [prevM, prevCar, prevContent] = stack.pop(); // stack에 있는 차량을 빼주고
          answer[prevCar] += 23*60 + 59 - prevM; // 출차 기록이 없으므로 23:59 출차로 계산
      }
      if (Object.hasOwn(answer, car) === false) { // 새로운 차량이 들어오면
          answer[car] = 0; // 해당 차량의 요금 초기화
      }
      if (content === 'IN') { // 입차하는 차량
          stack.push([minute, car, content]); // stack에 추가
          if (idx === newRecords.length - 1) { // 입차하는 차량이 마지막 차량인 경우
              let [prevM, prevCar, prevContent] = stack.pop();
              answer[prevCar] += 23*60 + 59 - prevM; // 무조건 23:59 출차로 계산
          }
      }
      else { // 출차하는 차량
          let [prevM, prevCar, prevContent] = stack.pop();
          answer[car] += minute - prevM;
      }
      idx += 1;
  }

  let keyList = Object.keys(answer); // 차량번호를 오름차순으로 배열로 저장
  keyList.sort((a, b) => a - b);
  let res = keyList.map((value) => {
      return calculate(answer[value]); // 요금 계산
  })
  
  return res
}
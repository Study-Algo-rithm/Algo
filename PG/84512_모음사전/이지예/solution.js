function solution(word) {
    const obj = {
      A: 0,
      E: 1,
      I: 2,
      O: 3,
      U: 4,
    };
    const plus = [781, 156, 31, 6, 1]; //각각의 숫자 추가 크기
    return word
      .split("") //들어온 글자 하나하나 자르기
      .reduce((acc, ch, idx) => acc + obj[ch] * plus[idx] + 1, 0);//idx는 현재 인덱스, ch는 해당 인덱스의 값, acc는 누적합
      //0은 뭔데?
  }
  console.log(solution("EIO"));
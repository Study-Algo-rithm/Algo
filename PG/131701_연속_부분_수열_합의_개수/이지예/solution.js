function solution(elements) {
  const answer = [];
  const len = elements.length;
  for (let numLen = 1; numLen <= len; numLen++) {
    //만들 수열 갯수
    for (let i = 0; i < len; i++) {
      //시작할 인덱스
      let sum = 0;
      for (let j = i; j < i + numLen; j++) {
        //수열의 합 구하기
        sum += elements[(j + len) % len];
      }
      answer.push(sum);
    }
  }
  //answer 중복 제거
  const set = new Set(answer); //Set객체는 중복을 없애준다.
  const uniqueAnswer = [...set];
  return uniqueAnswer.length;
}
console.log(solution([7, 9, 1, 1, 4]));

function solution(msg) {
  const answer = [];
  let nextWord = "";
  let lastCount = 27;
  const dict = {};

  for (let i = 0; i < 26; i++) {
    dict[String.fromCharCode(65 + i)] = i + 1;
  }

  const strArr = msg.split("").reduce((acc, cur) => {
    //맨 처음 acc는 인덱스 0, 맨 처음 cur는 인덱스 1로, acc는 이전 return 값을 가지게 되고, cur는 인덱스 1씩 증가.
    nextWord = acc + cur; //acc는 이전 단어가 넘어왔거나, 배열에서 한 글자씩 순서대로 acc로 설정됨.

    if (dict[nextWord] === undefined) {
      //한 글자 추가한 단어가 사전에 없는 단어라면
      dict[nextWord] = lastCount++;
    } else {
      return acc + cur; //이미 사전에 있는 단어라면 다음 acc로 전달 혹은 strArr로 초기화
    }

    answer.push(dict[acc]); //이전까지 받아온 단어는 한글자짜리 혹은 acc(이미 사전에 있는 단어)이기 때문에 사전에서 인덱스 값을 꺼내준다.
    return cur; //다음 acc로 전달 혹은 strArr로 초기화
  });

  answer.push(dict[strArr]);

  return answer;
}

console.log(solution("TOBEORNOTTOBEORTOBEORNOT")); //[11, 1, 27, 15]

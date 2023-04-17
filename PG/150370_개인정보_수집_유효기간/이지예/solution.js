function solution(today, terms, privacies) {
  let answer = [];
  const splitToday = today.split(".").map(Number);
  let alphabet = Array(26).fill(0); //26개의 배열을 만들어서 0으로 채운다.

  for (term of terms) {
    //of 잘 기억하기
    let splitTerm = term.split(" "); //A, 6
    alphabet[splitTerm[0].charCodeAt(0) - 65] = Number(splitTerm[1]);
    //들어온 알파벳의 0번째 자리의 글자를 아스키코드로 변환. 대문자 A의 아스키코드를 뺀 위치에 들어온 숫자를 넣기
  }

  for (let i = 0; i < privacies.length; i++) {
    let splitPrivacy = privacies[i].split(" ");
    let splitDay = splitPrivacy[0].split(".").map(Number); //자른 글자들 숫자로 변환해서 배열에 넣기
    splitDay[1] += Number(alphabet[splitPrivacy[1].charCodeAt(0) - 65]);
    while (splitDay[1] > 12) {
      splitDay[1] -= 12;
      splitDay[0] += 1;
    }
    if (
      (splitToday[0] - splitDay[0]) * 12 + (splitToday[1] - splitDay[1]) >
      0
    ) {
      answer.push(i + 1);
    } else if (
      (splitToday[0] - splitDay[0]) * 12 + (splitToday[1] - splitDay[1]) ===
        0 &&
      splitToday[2] - splitDay[2] >= 0
    ) {
      answer.push(i + 1);
    }
  }
  return answer;
}
solution(
  "2022.05.19",
  ["A 6", "B 12", "C 3"],
  ["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]
);

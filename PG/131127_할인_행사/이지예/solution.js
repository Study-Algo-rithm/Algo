function solution(want, number, discount) {
  let answer = 0;
  for (let i = 0; i < discount.length - 9; i++) {
    const count = Array(want.length).fill(0);
    for (let j = i; j < i + 10; j++) {
      if (want.indexOf(discount[j]) !== -1) {
        count[want.indexOf(discount[j])] += 1;
      }
    }
    for (let j = 0; j < want.length; j++) {
      if (number[j] !== count[j]) {
        answer -= 1;
        break;
      }
    }
    answer += 1;
  }
  return answer;
}
console.log(
  solution(
    ["banana", "apple", "rice", "pork", "pot"],
    [3, 2, 2, 2, 1],
    [
      "chicken",
      "apple",
      "apple",
      "banana",
      "rice",
      "apple",
      "pork",
      "banana",
      "pork",
      "rice",
      "pot",
      "banana",
      "apple",
      "banana",
    ]
  )
); //3
console.log(
  solution(
    ["apple"],
    [10],
    [
      "banana",
      "banana",
      "banana",
      "banana",
      "banana",
      "banana",
      "banana",
      "banana",
      "banana",
      "banana",
    ]
  )
); //0

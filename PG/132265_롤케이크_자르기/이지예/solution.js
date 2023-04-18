const solution = (topping) => {
  let answer = 0;
  const allTopping = new Map();
  const bro = new Map();

  topping.forEach((n) => {
    //topping 각각의 원소를 받아와서
    allTopping.set(n, (allTopping.get(n) || 0) + 1);
    //받아온 원소의 값에 +1해준다. 기존에 현재 원소를 담아놓지 않았다면 기존 값을 받아오지 않고 0으로 설정 해 준다.
  });

  for (let n of topping) {
    //각각의 원소를
    allTopping.set(n, allTopping.get(n) - 1); //allTopping에서 해당 원소 하나씩 뺀다.
    bro.set(n, true); //bro라는 Map 자료구조에 n을 true로 설정한다.
    if (!allTopping.get(n)) allTopping.delete(n);
    //n이 남은 토핑에 없으면 아예 없애준다.

    if (allTopping.size === bro.size) answer++;
    //남은 토핑이랑 뺀 토핑의 갯수가 같으면 정답에 +해준다.

    if (allTopping.size < bro.size) break;
    //뺀 토핑 갯수가 더 많아지면 아예 멈춘다.
  }
  return answer;
};
console.log(solution([1, 2, 1, 3, 1, 4, 1, 2]));

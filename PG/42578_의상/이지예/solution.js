function solution(clothes) {
  const clothesMap = {};
  let answer = 1;

  clothes.forEach((arr) => {
    const [type, name] = arr;
    //name을 key값으로 가지는 객체가 있는가?
    if (clothesMap.hasOwnProperty(name)) {
      clothesMap[name]++; //type이 모두 다르므로, 갯수 추가만 해줌
    } else {
      clothesMap[name] = 1; //1로 초기화
    }
  });

  for (const key in clothesMap) {
    answer *= clothesMap[key] + 1; //조합 a1C1*a2C1*...*anC1
  }
  return answer - 1; //모두 포함 안되는 경우 빼기
}

console.log(
  solution([
    ["yellow_hat", "headgear"],
    ["blue_sunglasses", "eyewear"],
    ["green_turban", "headgear"],
  ])
);

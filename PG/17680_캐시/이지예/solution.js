function solution(cacheSize, cities) {
  let answer = 0;
  if (cacheSize === 0) return cities.length * 5; //캐시 길이가 0인경우 예외처리
  const CACHE = [];

  cities.forEach((element) => {
    //대소문자 같이있으니까 소문자로 다 바꿔주기
    element = element.toLowerCase();
    const ind = CACHE.indexOf(element);
    //캐시에 있는가
    if (ind !== -1) {
      //있으면 빼주고, 맨뒤로 보냄. 1더해줌
      CACHE.splice(ind, 1);
      answer++;
      CACHE.push(element);
    } else {
      //없으면 길이따라서 넣어주거나 하나 빼고 넣고 5더해줌
      answer += 5;
      if (CACHE.length >= cacheSize) {
        CACHE.shift();
      }
      CACHE.push(element);
    }
  });
  return answer;
}

console.log(
  solution(3, [
    "Jeju",
    "Pangyo",
    "Seoul",
    "NewYork",
    "LA",
    "Jeju",
    "Pangyo",
    "Seoul",
    "NewYork",
    "LA",
  ])
); //50

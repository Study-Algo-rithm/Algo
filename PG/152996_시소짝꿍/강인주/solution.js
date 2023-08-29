function solution(weights) {

  let obj = {}; // {몸무게 : 사람수} 형식의 obj
  
  weights.forEach((value) => {
      if (Object.hasOwn(obj, value)) obj[value] += 1;
      else obj[value] = 1;
  })
  
  const keyList = Object.keys(obj); // 몸무게 값만 오름차순으로 배열에 나열
  
  let ans = 0;
  for (let i=0; i<keyList.length; i++) {
      const W1 = Number(keyList[i]);
      // 같은 무게의 사람들의 경우
      if (obj[W1] > 1) {
          ans += obj[W1] * (obj[W1] - 1) / 2;
      }
      
      // 다른 무게의 사람들의 경우
      if (Object.hasOwn(obj, W1*2)) ans += obj[W1*2] * obj[W1];
      if (Object.hasOwn(obj, W1*3/2)) ans += obj[W1*3/2] * obj[W1];
      if (Object.hasOwn(obj, W1*4/3)) ans += obj[W1*4/3] * obj[W1];
  }
  // 유효 범위는 일반적으로 9007199254740991 = 2^53 - 1
  // BigInt 형으로 변환
  // console.log(ans);
  return ans
}
function solution(orders, course) {
  const ordered = {};
  const candidates = {};
  const maxNum = Array(10 + 1).fill(0); //course가 10개. 근데 크기가 1에서 10까지니까 11개의 배열을 만드는듯

  const createSet = (arr, start, len, foods) => {
    //(["A","B","C","F","G"], 2,0,"AB") //(["A","B","C","F","G"], 3,0,"AC")
    if (len === 0) {
      ordered[foods] = (ordered[foods] || 0) + 1; //{AB:1, AC:1}
      if (ordered[foods] > 1) candidates[foods] = ordered[foods]; //{"AB":2} 임시
      maxNum[foods.length] = Math.max(maxNum[foods.length], ordered[foods]); // [0,0,1,0,0,0,0,0,0,0,0]
      return;
    }

    for (let i = start; i < arr.length; i++) {
      //0~5
      createSet(arr, i + 1, len - 1, foods + arr[i]); //(["A","B","C","F","G"], 2,0,"AB")
    }
  };

  orders.forEach((od) => {
    //"ABCFG"
    const sorted = od.split("").sort(); //sorted = ["A","B","C","F","G"]
    course.forEach((len) => {
      //2
      createSet(sorted, 0, len, "");
    });
  });

  const launched = Object.keys(candidates).filter(
    // "AB":food ??
    (food) => maxNum[food.length] === candidates[food]
  );
  return launched.sort();
}
console.log(
  solution(["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"], [2, 3, 4])
); //["AC", "ACDE", "BCFG", "CDE"]
console.log(
  solution(["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"], [2, 3, 5])
); //["ACD", "AD", "ADE", "CD", "XYZ"]
console.log(solution(["XYZ", "XWY", "WXA"], [2, 3, 4])); //["WX", "XY"]

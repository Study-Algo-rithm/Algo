function solution(info, query) {
  const answer = [];
  const lenQ = query.length;
  const lenI = info.length;

  for (let i = 0; i < lenQ; i++) {
    let splitQ = query[i].split(" ");
    let result = 0;
    for (let j = 0; j < lenI; j++) {
      let ind = 0;
      while (ind < splitQ.length) {
        if (ind === splitQ.length - 1) {
          let score = info[j].split(" ")[4];
          if (Number(score) >= Number(splitQ[ind])) {
            ind++;
          }
          break;
        }
        if (splitQ[ind] === "and" || splitQ[ind] === "-") {
          ind++;
          continue;
        }
        if (!info[j].includes(splitQ[ind])) break;
        ind++;
      }
      if (ind === splitQ.length) result++;
    }
    answer.push(result);
  }
  return answer;
}

console.log(
  solution(
    [
      "java backend junior pizza 150",
      "python frontend senior chicken 210",
      "python frontend senior chicken 150",
      "cpp backend senior pizza 260",
      "java backend junior chicken 80",
      "python backend senior chicken 50",
    ],
    [
      "java and backend and junior and pizza 100",
      "python and frontend and senior and chicken 200",
      "cpp and - and senior and pizza 250",
      "- and backend and senior and - 150",
      "- and - and - and chicken 100",
      "- and - and - and - 150",
    ]
  )
);

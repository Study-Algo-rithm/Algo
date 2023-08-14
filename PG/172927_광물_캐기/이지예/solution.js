function solution(picks, minerals) {
  let answer = Infinity;
  const pickSum = picks.reduce((sum, val) => (sum += val), 0);
  const pickSeq = [];
  const pickTemp = [0, 0, 0];
  const DICT = { diamond: 0, iron: 1, stone: 2 };
  const ROUND = Math.min(pickSum * 5, minerals.length);

  const checkMin = () => {
    let pirodo = 0;
    for (let i = 0; i < ROUND; i++) {
      let pirodoCal = DICT[minerals[i]] - pickSeq[parseInt(i / 5)];
      if (pirodoCal === -2) {
        pirodo += 25;
      } else if (pirodoCal === -1) {
        pirodo += 5;
      } else {
        pirodo += 1;
      }
    }
    answer = Math.min(answer, pirodo);
  };

  const setSeq = () => {
    if (pickSeq.length === pickSum) {
      //최소인지 체크
      checkMin();
      return;
    }
    for (let i = 0; i < 3; i++) {
      if (pickTemp[i] < picks[i]) {
        pickSeq.push(i);
        pickTemp[i] += 1;
        setSeq();
        //재귀 돌아옴
        pickSeq.pop();
        pickTemp[i] -= 1;
      }
    }
  };

  setSeq();

  return answer;
}

console.log(
  solution([1, 3, 2], ["diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"])
); //12
console.log(
  solution(
    [0, 1, 1],
    [
      "diamond",
      "diamond",
      "diamond",
      "diamond",
      "diamond",
      "iron",
      "iron",
      "iron",
      "iron",
      "iron",
      "diamond",
    ]
  )
); //50

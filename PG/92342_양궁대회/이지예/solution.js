function solution(n, info) {
  let answer = Array(11).fill(0);
  let maxCount = 0;

  function findMaxPoint(apeachCount, ryanCount, usedShots, ind, arr) {
    if (n < usedShots) return; //쏴야되는 화살 수가 정해진 양을 넘었다
    if (ind > 10) {
      //모든 범위 다 돌았다.
      let diff = ryanCount - apeachCount;
      if (maxCount < diff) {
        // 점수차가 최대다
        arr[10] += n - usedShots; //남는 화살 다 버림
        maxCount = diff;
        answer = arr;
      }
      return;
    }
    if (n > usedShots) {
      //아직 화살을 쏠 수 있다
      //라이언이 점수 얻는 경우
      let current = [...arr];
      current[10 - ind] = info[10 - ind] + 1;
      findMaxPoint(apeachCount, ryanCount + ind, usedShots + info[10 - ind] + 1, ind + 1, current);
    }

    //----이제 화살 못쏘거나 재귀하다가 돌아온 경우----
    if (info[10 - ind] > 0) {
      //어피치 점수가 0이 아니다
      //어피치가 점수 얻는 경우
      findMaxPoint(apeachCount + ind, ryanCount, usedShots, ind + 1, arr);
    } else {
      //어피치도 못쐈고, 라이언은 화살이 없거나 재귀 돌아왔다
      //둘 다 점수 못얻는 경우
      findMaxPoint(apeachCount, ryanCount, usedShots, ind + 1, arr);
    }
  }
  findMaxPoint(0, 0, 0, 0, answer);
  return maxCount <= 0 ? [-1] : answer;
}
console.log(solution(5, [2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0]));
console.log(solution(1, [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]));
console.log(solution(9, [0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1]));
console.log(solution(10, [0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3]));

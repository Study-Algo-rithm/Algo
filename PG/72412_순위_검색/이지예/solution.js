function solution(info, query) {
  const answer = [];
  let map = {};

  //조합
  //받은 정보로 -가 들어갈 수 있는 모든 경우 만들어서 object 만들기
  function combination(cnt, key, arr, score) {
    if (cnt === 4) {
      if (!map[key]) map[key] = [score];
      else map[key].push(score); //이미 있는 key 값이면, value 늘려주기
      return;
    }
    combination(cnt + 1, key + arr[cnt], arr, score);
    combination(cnt + 1, key + "-", arr, score);
  }

  for (let i = 0; i < info.length; i++) {
    //사원 정보, 점수 잘라서 combination()으로 보내기
    const arr = info[i].split(" ");
    const score = Number(arr.pop());
    combination(0, "", arr, score);
  }

  for (let key in map) {
    map[key] = map[key].sort((a, b) => a - b); //오름차순
  }

  //문의조건을 하나씩 탐색해본다.
  for (let i = 0; i < query.length; i++) {
    const arr = query[i].replace(/ and /g, " ").split(" ");
    const score = Number(arr.pop());
    const key = arr.join("");
    const scoreArray = map[key];

    //이진탐색
    //object에서 문의조건에 해당하는 key값을 가진 값 배열을 살펴본다.
    if (scoreArray) {
      //범위 설정
      let left = 0;
      let right = scoreArray.length;

      //아직 pivot이 만나지 못했나? 탐색할 구역이 남아있나?
      while (left < right) {
        //중간값 설정
        const mid = parseInt((left + right) / 2);

        //중간값이 점수보다 크거나 같은가
        if (scoreArray[mid] >= score) {
          //오른쪽 인덱스 범위를 mid로 변경. 탐색할 구역 줄이기.
          right = mid;
          //중간값이 점수보다 낮다
        } else if (scoreArray[mid] < score) {
          //mid 다음값부터 탐색 범위 설정을 하기 위해 left를 mid+1로 변경
          left = mid + 1;
        }
      }
      //총 길이 - score 안되는 갯수
      answer.push(scoreArray.length - left);
    } else {
      //문의 조건에 해당하는 key 값을 가진 배열이 없는 경우
      answer.push(0);
    }
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

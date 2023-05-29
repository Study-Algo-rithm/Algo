function solution(relation) {
  const rowLen = relation.length; //6
  const colLen = relation[0].length; //4

  const bfs = () => {
    const queue = [...Array(colLen)].map((_, i) => [i]); //value, index 가져와서 [index] 인 배열을 colLen(4)개 만들겠다.
    //[[0],[1],[2],[3]]
    const candidate = [];
    while (queue.length) {
      const indices = queue.shift(); //앞에서부터 queue의 요소 뺀다.
      if (
        candidate.find((cand) => cand.every((index) => indices.includes(index)))
      ) {
        //만약 candidate에서 요소 탐색하는데 => 현재 queue에서 빼낸 요소에 index가 들어있는가? => while문 마지막 로직과 중복되는 속성 있는지 탐색
        continue;
      }
      const set = new Set(); //중복 제거용 set
      for (let i = 0; i < rowLen; i++) {
        // 해당 열(indices)의 모든 행 검사
        set.add(JSON.stringify(indices.map((index) => relation[i][index])));
        //indices의 모든 요소를 가져와서 index로 삼는다.
        //가져온 index를 relation의 열(속성)로 모든 i 행을 JSON으로 만들어서 set에 넣는다.
      }
      if (set.size === rowLen) {
        //set의 크기가 행의 크기와 같으면, 중복이 없는 것이므로
        candidate.push(indices); //후보키 배열에 해당 열을 나타내는 숫자를 넣는다.
      } else {
        for (let i = indices[indices.length - 1] + 1; i < colLen; i++) {
          //indices[마지막 인덱스]+1 (다음 속성 인덱스부터 시작). 속성 조합 만드는듯.
          queue.push([...indices, i]);
        }
      }
    }
    return candidate.length;
  };

  return bfs();
}

console.log(
  solution([
    ["100", "ryan", "music", "2"],
    ["200", "apeach", "math", "2"],
    ["300", "tube", "computer", "3"],
    ["400", "con", "computer", "4"],
    ["500", "muzi", "music", "3"],
    ["600", "apeach", "music", "2"],
  ])
);

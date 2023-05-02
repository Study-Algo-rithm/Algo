function solution(k, dungeons) {
  let answer = 0;
  let len = dungeons.length;
  const visited = Array.from({ length: dungeons.length }, () => false);
  //   const visited = new Array(dungeons.length).fill(false);
  //new Array로 배열 생성하지 않는걸 권장? 괄호안에 number를 넣는지 string을 넣는지에 따라 달라져서 일관성이 없어서?

  function DFS(kk, cnt) {
    //남은 피로도, 방문한 던전 수
    for (let i = 0; i < len; i++) {
      if (!visited[i] && kk >= dungeons[i][0]) {
        //방문 안했고, 남은 피로도로 입장 가능한가
        visited[i] = true; //입장
        DFS(kk - dungeons[i][1], cnt + 1); // 퇴장 피로도 깎아주고, 방문 횟수 증가
        visited[i] = false; //퇴장
      }
    }
    answer = Math.max(answer, cnt); //answer랑 방문횟수 중 큰 값 answer로 설정
  }
  DFS(k, 0);
  return answer;
}
console.log(
  solution(80, [
    [80, 20],
    [50, 40],
    [30, 10],
  ])
);

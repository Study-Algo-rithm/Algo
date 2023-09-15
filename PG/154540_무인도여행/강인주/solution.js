function solution(maps) {
  const row = maps.length;
  const col = maps[0].length;
  let island = {}; // 섬의 번호 : 머물 수 있는 일 수
  const direction = [[-1, 0], [0, 1], [1, 0], [0, -1]] // 반시계 방향
  
  visited = new Array(row); // 방문 유무를 표시할 2차원 배열
  for (let i=0; i<row; i++) visited[i] = new Array(col).fill(0);
  
  function BFS(r, c, islandNum) {
      q = [[r, c]];
      visited[r][c] = 1;
      while (q.length > 0) {
          v = q.shift();
          const days = Number(maps[v[0]][v[1]]);
          // console.log(v, days);
          Object.hasOwn(island, islandNum) ? island[islandNum] += days : island[islandNum] = days;
          direction.forEach((d) => {
              const [nr, nc] = [v[0]+d[0], v[1]+d[1]]; // 다음 위치
              if ((0<=nr && nr<row) && (0<=nc && nc<col)) {
                  if (visited[nr][nc] === 0 && maps[nr][nc] !== "X") { // 방문 안한 위치 추가
                      // console.log(nr, nc, isVisited)
                      q.push([nr, nc]);
                      visited[nr][nc] = 1;
                  }
              }
          })
      }
          
  }
  
  let cnt = 1; // 섬의 번호 지정
  for (let i=0; i<row; i++) {
      for (let j=0; j<col; j++) {
          if (maps[i][j] !== "X" && visited[i][j] === 0) {
              BFS(i, j, cnt);
              cnt += 1;
          }
      }
  }
  
  ans = Object.values(island); // island의 value값을 배열로 가져오기
  ans.sort((a, b) => a - b); // 오름차순 정렬

  if (ans.length === 0) ans = [-1];
  return ans 
}
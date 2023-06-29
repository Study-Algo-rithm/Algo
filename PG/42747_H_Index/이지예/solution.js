function solution(citations) {
  let h = citations.length;
  let len = h;
  while (h !== 0) {
    let more = [];
    for (let i = 0; i < len; i++) {
      let num = Number(citations[i]);
      if (num >= h) {
        more.push(num);
      }
    }
    if (more.length >= h && len - more.length <= h) return h;
    h--;
  }
}

console.log(solution([3, 0, 6, 1, 5])); //3

function solution(n) {
  return n
    .toString(2)
    .split("")
    .map(Number)
    .reduce((sum, val, i) => {
      if (val === 1) sum += 1;
      return sum;
    }, 0);
}
console.log(solution(5000));

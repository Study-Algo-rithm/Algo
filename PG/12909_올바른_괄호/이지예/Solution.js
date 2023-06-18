function solution(s) {
  let cnt = 0;
  const arr = s.split("");
  if (arr.length % 2 !== 0) return false;
  for (let i = arr.length - 1; i >= 0; i--) {
    if (arr[i] === ")") {
      cnt++;
    } else cnt--;
    if (cnt < 0) return false;
  }
  if (cnt !== 0) return false;
  return true;
}

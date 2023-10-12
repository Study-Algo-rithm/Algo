function solution(s) {
  const newS = s.toLowerCase().split('');
  // console.log(newS)
  
  newS[0] = newS[0].toUpperCase();
  for (let i=1; i<newS.length; i++) {
      if (newS[i-1] === ' ' && isNaN(newS[i])) newS[i] = newS[i].toUpperCase();
  }
  // console.log(newS)
  const ans = newS.reduce((acc, cur) => acc + cur, '');
  return ans
}
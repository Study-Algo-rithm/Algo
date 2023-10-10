function solution(w, h) {
  // 정사각형일 경우
  if (w === h) return w*(w-1);
  
  // 직사각형일 경우
  let [y1, y2] = [0, 0];
  let cnt = 0; // 잘린 삼각형의 개수
  
  for (let x=1; x<=w; x++) {
      y1 = h * x / w; // JS에서 곱셈을 먼저하고 나눗셈을 해야 값이 제대로 나옴
      // console.log(y1, y2);
      cnt += Math.ceil(y1) - Math.floor(y2);
      y2 = y1;
  }
  
  return w*h - cnt;
}
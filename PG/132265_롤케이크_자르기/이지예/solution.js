// const solution = (topping) => {
//   let answer = 0;
//   for (let i = 1; i < topping.length - 1; i++) {
//     let leftCount = countTopping(0, i, topping);
//     let rightCount = countTopping(i, topping.length, topping);
//     if (leftCount === rightCount) answer++;
//     else if (leftCount > rightCount) break;
//   }
//   console.log(answer);
//   return answer;
// };

// const countTopping = (start, end, topping) => {
//   const eatableToppingList = [];
//   let result = 0;
//   for (let i = start; i < end; i++) {
//     if (!eatableToppingList.includes(topping[i])) {
//       eatableToppingList.push(topping[i]);
//       result++;
//     }
//   }
//   return result;
// };
function solution(topping) {
  let answer = 0;
  for (let i = 1; i < topping.length - 1; i++) {
    let leftCount = countTopping(0, i, topping);
    let rightCount = countTopping(i, topping.length, topping);
    if (leftCount === rightCount) answer++;
    else if (leftCount > rightCount) break;
  }
  return answer;
}

function countTopping(start, end, topping) {
  const eatableToppingList = [];
  let result = 0;
  for (let i = start; i < end; i++) {
    if (!eatableToppingList.includes(topping[i])) {
      eatableToppingList.push(topping[i]);
      result++;
    }
  }
  return result;
}
solution([1, 2, 3, 1, 4]);

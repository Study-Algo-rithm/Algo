function solution(people, limit) {
  let answer = 0;
  people.sort((a, b) => b - a);
  for (let s = 0, e = people.length - 1; s <= e; s++) {
    if (people[s] + people[e] <= limit) e--;
    answer++;
  }
  return answer;
}
console.log(solution([70, 50, 80, 50], 100));
console.log(solution([70, 80, 50], 100));

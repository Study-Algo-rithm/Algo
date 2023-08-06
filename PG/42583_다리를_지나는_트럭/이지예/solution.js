function solution(bridge_length, weight, truck_weights) {
  let time = 0;
  const bridge = [];
  const bridge_time = [];
  let sum = 0;

  while (truck_weights.length !== 0 || bridge.length !== 0) {
    //트럭 한 대 더 다리에 올라가도 되는가
    if (sum + truck_weights[0] <= weight) {
      sum += truck_weights[0];
      bridge.push(truck_weights.shift());
      bridge_time.push(0);
    }

    //다리에 올라간 트럭들 주행시작
    for (let t = 0; t < bridge_time.length; t++) {
      bridge_time[t] += 1;
    }
    time++;
    //다리 나올 트럭 있는가
    if (bridge_time[0] === bridge_length) {
      sum -= bridge[0];
      bridge.shift();
      bridge_time.shift();
    }
  }

  return time + 1;
}

console.log(solution(2, 10, [7, 4, 5, 6])); //8
console.log(solution(100, 100, [10])); //101
console.log(solution(100, 100, [10, 10, 10, 10, 10, 10, 10, 10, 10, 10])); //110

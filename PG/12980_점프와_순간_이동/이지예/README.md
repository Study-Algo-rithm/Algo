# 문제

건전지 사용량을 최소로 하여 목적지에 도착했을 때, 건전지 사용량을 출력하는 문제.<br>
앞으로 한 칸씩 이동하거나, 현재까지 온 거리 x 2 만큼 순간이동 가능하다.<br>
이동한 거리만큼 건전지가 소모되나, 순간이동은 건전지 소모가 되지 않는다.

# Solution.js 의 결과

![image](https://user-images.githubusercontent.com/58285947/223608516-78a9c54e-fc75-4d9b-a9b8-b434cafc5068.png)
![image](https://user-images.githubusercontent.com/58285947/223608558-fe3965ff-a00f-4c4e-896e-b90617d0328d.png)
![image](https://user-images.githubusercontent.com/58285947/223608583-9d21b7d4-e385-4d50-9739-c7c787d1596a.png)

# solution2.js 의 결과

![image](https://github.com/bo-gyeong/Algo/assets/58285947/97ae1a51-cc22-4c4f-9fac-54e506b8a220)
![image](https://github.com/bo-gyeong/Algo/assets/58285947/c03a2d93-5357-4ffa-9825-cda28029f6fc)

# solution2 풀이

- 목적지를 2진수로 만들었을 때, 1의 갯수가 건전지 사용량
  - ex) 목적지 위치가 9일 때, 1칸 이동(필수) 후, 3번 순간이동 하고, 1칸 더 이동하면 도착
  - 2^3+1 => 1001(2)
- 입력받은 n을 2진수로 변경한다.
- 글자를 하나씩 쪼갠 후 숫자로 변경한다.
- 1의 갯수를 출력한다.

# 문제

입력된 문자열로 압축 알고리즘 LZW 를 구현하시오.

- 길이가 1인 모든 단어를 사전에 초기화한다.
- 사전에서 현재 입력과 일치하는 가장 긴 문자열을 찾는다.
- 사전에 없는 문자열은 새로 등록한다.

# 풀이

- 참고한 링크의 reduce에서 `사전에 인덱스가 있으면` answer에 인덱스를 추가하는 부분에 조건문을 삭제했다.
  - 처음 acc라면 한 글자이고, 처음이 아니라면 이전 return 값이기 때문에 사전에 있는 값이 acc로 들어오기 때문이다.

# 후기

- reduce 메서드에 누산기와 현재 값에 따로 설정을 하지 않으면, 0번째 인덱스 값이 누산기 값, 1번째 인덱스 값이 현재 값이 된다는 것을 알게 됐다.

# 채점 결과

![image](https://github.com/Study-Algo-rithm/Algo/assets/58285947/6b588f65-5035-4cf9-8725-fcb76d4f51f5)<br>
![image](https://github.com/Study-Algo-rithm/Algo/assets/58285947/7d6199ad-3e69-4c3d-b955-35bbfaa6ca6f)

# 참고 링크

https://velog.io/@kimjiwonpg98/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%95%95%EC%B6%95-javascript

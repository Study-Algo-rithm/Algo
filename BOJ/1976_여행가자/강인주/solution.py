import sys
from collections import deque

sys.stdin = open('input.txt')

# 도시 번호 : 1 ~ N
N = int(sys.stdin.readline()) # 도시의 수
M = int(sys.stdin.readline()) # 계획에 속한 도시 수
link = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
plan = list(map(int, sys.stdin.readline().split())) # 여행 계획

def BFS(city, want):
    possible = False
    cities = deque([city])
    visited = [0] * (N+1)
    visited[city] = 1
    while cities:
        cur = cities.popleft()
        if cur == want:
            possible = True
            break
        for i in range(1, N+1):
            if not visited[i] and link[cur-1][i-1]:
                cities.append(i)
                visited[i] = 1

    return possible

ans = "YES"
for i in range(1, M):
    if BFS(plan[i], plan[i-1]) == False:
        ans = "NO"
        break

print(ans)
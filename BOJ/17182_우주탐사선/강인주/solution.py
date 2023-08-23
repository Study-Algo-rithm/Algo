import sys

sys.stdin = open('input.txt')

N, K = map(int, sys.stdin.readline().split()) # N 행성 개수, K 행성 시작 위치
T = [list(map(int, sys.stdin.readline().split())) for _ in range(N)] # 행성 간 이동 시간 리스트

# 모든 행성을 탐사하기 위한 최소 시간 구하기
# 이미 방문한 행성도 중복 가능

for k in range(N):
    for i in range(N):
        for j in range(N):
            T[i][j] = min(T[i][j], (T[i][k] + T[k][j]))

# print(T)
minTime = int(1e9)
visited = [0] * N
visited[K] = 1
def spaceProbe(planet, time, cnt):
    global minTime
    if cnt == N:
        minTime = min(minTime, time)
        return

    for next in range(N):
        if not visited[next]:
            visited[next] = 1
            spaceProbe(next, time+T[planet][next], cnt+1)
            visited[next] = 0

spaceProbe(K, 0, 1)
print(minTime)

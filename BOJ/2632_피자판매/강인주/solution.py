import sys

sys.stdin = open('input.txt')

size = int(sys.stdin.readline().strip()) # 구하려는 피자 사이즈
m, n = map(int, sys.stdin.readline().split()) # m : A피자 조각 개수, n : B피자 조각 개수
A = []; B = [] # A피자 조각 사이즈 배열, B피자 조각 사이즈 배열
sumA = 0; sumB = 0
res = 0 # 피자 판매가 가능한 경우의 수

for _ in range(m):
    value = int(sys.stdin.readline().strip())
    A.append(value)
    sumA += value

for _ in range(n):
    value = int(sys.stdin.readline().strip())
    B.append(value)
    sumB += value

dpA = [0] * (size + 1); dpB = [0] * (size + 1) # A피자, B피자 각각의 DP 배열
dpA[0] = 1; dpB[0] = 1 # 아무것도 선택하지 않는 경우의 수는 1가지

# 전체 피자를 선택하는 경우 수도 1가지
if sumA <= size:
    dpA[sumA] = 1
if sumB <= size:
    dpB[sumB] = 1

def count_pieces(dp, piza):
    length = len(piza)
    for i in range(length):
        total = 0
        for j in range(length-1):
            total += piza[(i+j) % length]
            if total > size:
                break
            # print(i, j, total)
            dp[total] += 1

count_pieces(dpA, A)
count_pieces(dpB, B)

# print(dpA, dpB)

if sumA + sumB < size:
    print(0)
else:
    for i in range(size+1):
        res += dpA[i] * dpB[size-i]
    print(res)



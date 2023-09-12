import sys

sys.stdin = open('input.txt')

N = int(sys.stdin.readline())
numberArr = [0] * (N+1)
sosu = []

def isPrime(arr, N):
    value = 0
    for i in range(N, 0, -1):
        value += arr[i] * 10**(i-1)

    # print(value)
    for i in range(N-1, 0, -1):
        temp = value // 10**(i-1)
        # print(value, temp, i-1)
        for j in range(2, int(temp**0.5)+1):
            if temp % j == 0:
                return False
    return value


def DFS(idx, numArr, N):
    if idx == 0:
        # print(numArr)
        ans = isPrime(numArr, N)
        if ans:
            print(ans)
        return

    if idx == N:
        for x in [2, 3, 5, 7]:
            numArr[idx] = x
            DFS(idx-1, numArr, N)

    else:
        for x in [1, 3, 5, 7, 9]:
            numArr[idx] = x
            DFS(idx - 1, numArr, N)

DFS(N, numberArr, N)
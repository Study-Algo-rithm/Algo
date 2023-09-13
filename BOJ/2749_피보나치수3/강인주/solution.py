import sys

sys.stdin = open('input.txt')

n = int(sys.stdin.readline())
m = 15*(10**5)
dp = [0] * (m+1)

def fibonachi():
    dp[1] = 1
    for i in range(m-1):
        dp[i+2] = (dp[i+1] + dp[i]) % (10**6)

fibonachi()

k = n % m
print(dp[k])
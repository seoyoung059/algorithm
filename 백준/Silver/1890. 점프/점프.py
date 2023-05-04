import sys
input=sys.stdin.readline

n = int(input())

arr = [list(map(int, input().split())) for _ in range(n)]

dp = [[0] * n for _ in range(n)]
dp[0][0] = 1

for i in range(n):
    for j in range(n):
        if i == n-1 and j== n-1:
            print(dp[i][j])
            break
        current = arr[i][j]
        if current + j < n:
            dp[i][j+current] += dp[i][j]
        if current + i < n:
            dp[i+current][j] += dp[i][j]
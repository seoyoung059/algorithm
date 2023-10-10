# 퇴사

n = int(input())
arr = [list(map(int, input().split())) for i in range(n)]
dp = [0] * (n+1)

val = 0
for i in range(n-1, -1, -1):
    if i + arr[i][0] > n:
        if i==n-1:
            dp[i]=0
        else:
            dp[i]=max(0, dp[i+1])
        continue
    dp[i] = max(dp[i+1], dp[i+arr[i][0]]+arr[i][1])

print(dp[0])